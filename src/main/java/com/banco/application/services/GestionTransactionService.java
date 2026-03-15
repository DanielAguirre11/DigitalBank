package com.banco.application.services;

import com.banco.application.dto.TransactionRequest;
import com.banco.application.dto.TransactionResponse;
import com.banco.application.port.out.AccountRepository;
import com.banco.application.port.out.TransactionRepository;
import com.banco.domain.model.entities.Account;
import com.banco.domain.model.entities.Transaction;
import com.banco.domain.model.valueobjects.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionTransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public GestionTransactionService(TransactionRepository transactionRepository,
                                     AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    public TransactionResponse crearTransaccion(TransactionRequest request) {
        Account account = accountRepository.buscarPorId(request.getAccountId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + request.getAccountId()));

        BigDecimal balanceBefore = account.getLedgerBalance();
        BigDecimal balanceAfter;

        if (request.getTransactionType() == TransactionType.CREDIT) {
            balanceAfter = balanceBefore.add(request.getAmount());
        } else {
            balanceAfter = balanceBefore.subtract(request.getAmount());
            if (balanceAfter.compareTo(BigDecimal.ZERO) < 0) {
                if (!account.isOverdraftAllowed()) {
                    throw new IllegalArgumentException(
                        "Saldo insuficiente. Saldo disponible: " + balanceBefore);
                }
                if (account.getOverdraftLimit() != null
                        && balanceAfter.abs().compareTo(account.getOverdraftLimit()) > 0) {
                    throw new IllegalArgumentException(
                        "El monto excede el limite de sobregiro permitido: " + account.getOverdraftLimit());
                }
            }
        }

        Transaction transaction = new Transaction(
            request.getAccountId(),
            request.getValueDate(),
            request.getTransactionType(),
            request.getTransactionCodeId(),
            request.getAmount(),
            balanceBefore,
            balanceAfter,
            request.getExternalReference(),
            request.getChannel(),
            request.getUserId(),
            null
        );

        account.setLedgerBalance(balanceAfter);
        account.setAvailableBalance(balanceAfter);
        accountRepository.actualizar(account);
        transactionRepository.guardar(transaction);

        return toResponse(transaction);
    }

    @Transactional(readOnly = true)
    public TransactionResponse buscarPorId(UUID transactionId) {
        return transactionRepository.buscarPorId(transactionId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la transaccion con id: " + transactionId));
    }

    @Transactional(readOnly = true)
    public List<TransactionResponse> buscarPorAccountId(UUID accountId) {
        accountRepository.buscarPorId(accountId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + accountId));
        return transactionRepository.buscarPorAccountId(accountId).stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public TransactionResponse revertirTransaccion(UUID transactionId) {
        Transaction original = transactionRepository.buscarPorId(transactionId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la transaccion con id: " + transactionId));

        if (original.isReversed()) {
            throw new IllegalArgumentException(
                "La transaccion con id " + transactionId + " ya fue revertida");
        }

        Account account = accountRepository.buscarPorId(original.getAccountId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro la cuenta con id: " + original.getAccountId()));

        TransactionType reversalType = original.getTransactionType() == TransactionType.DEBIT
            ? TransactionType.CREDIT
            : TransactionType.DEBIT;

        BigDecimal balanceBefore = account.getLedgerBalance();
        BigDecimal balanceAfter = reversalType == TransactionType.CREDIT
            ? balanceBefore.add(original.getAmount())
            : balanceBefore.subtract(original.getAmount());

        Transaction reversal = new Transaction(
            original.getAccountId(),
            original.getValueDate(),
            reversalType,
            original.getTransactionCodeId(),
            original.getAmount(),
            balanceBefore,
            balanceAfter,
            "REVERSAL OF " + transactionId,
            original.getChannel(),
            original.getUserId(),
            transactionId
        );

        original.setReversed(true);

        account.setLedgerBalance(balanceAfter);
        account.setAvailableBalance(balanceAfter);
        accountRepository.actualizar(account);
        transactionRepository.actualizar(original);
        transactionRepository.guardar(reversal);

        return toResponse(reversal);
    }


    private TransactionResponse toResponse(Transaction t) {
        return new TransactionResponse(
            t.getTransactionId(),
            t.getAccountId(),
            t.getTransactionDate(),
            t.getValueDate(),
            t.getTransactionType(),
            t.getTransactionCodeId(),
            t.getAmount(),
            t.getBalanceBefore(),
            t.getBalanceAfter(),
            t.getExternalReference(),
            t.getChannel(),
            t.getUserId(),
            t.isReversed(),
            t.getOriginalTxnId()
        );
    }
}
