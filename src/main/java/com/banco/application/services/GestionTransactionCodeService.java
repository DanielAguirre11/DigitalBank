package com.banco.application.services;

import com.banco.application.dto.ActualizarTransactionCodeRequest;
import com.banco.application.dto.TransactionCodeRequest;
import com.banco.application.dto.TransactionCodeResponse;
import com.banco.application.port.out.TransactionCodeRepository;
import com.banco.domain.model.entities.TransactionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GestionTransactionCodeService {

    private final TransactionCodeRepository repository;

    public GestionTransactionCodeService(TransactionCodeRepository repository) {
        this.repository = repository;
    }


    public TransactionCodeResponse crearTransactionCode(TransactionCodeRequest request) {
        if (repository.existePorCodigo(request.getCode())) {
            throw new IllegalArgumentException("Ya existe un codigo de transaccion con el codigo: " + request.getCode());
        }

        TransactionCode transactionCode = new TransactionCode(
            request.getCode(),
            request.getName(),
            request.getDescription(),
            request.getCategory(),
            request.getDefaultEntryType(),
            request.getGlDebitAccountCode(),
            request.getGlCreditAccountCode(),
            request.getAllowedChannels(),
            request.isRequiresAuthorization(),
            request.isGeneratesTax(),
            request.isGeneratesGlEntry(),
            request.isReversible(),
            request.isActive(),
            request.getEffectiveDate(),
            request.getExpiryDate()
        );

        repository.guardar(transactionCode);
        return toResponse(transactionCode);
    }

    @Transactional(readOnly = true)
    public TransactionCodeResponse buscarPorId(Short transactionCodeId) {
        return repository.buscarPorId(transactionCodeId)
            .map(this::toResponse)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el codigo de transaccion con id: " + transactionCodeId));
    }

    @Transactional(readOnly = true)
    public List<TransactionCodeResponse> buscarTodos() {
        return repository.buscarTodos().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public TransactionCodeResponse actualizarTransactionCode(Short transactionCodeId,
                                                             ActualizarTransactionCodeRequest request) {
        TransactionCode transactionCode = repository.buscarPorId(transactionCodeId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el codigo de transaccion con id: " + transactionCodeId));

        request.getCode().ifPresent(code -> {
            if (repository.existePorCodigoExcluyendo(code, transactionCodeId)) {
                throw new IllegalArgumentException("Ya existe un codigo de transaccion con el codigo: " + code);
            }
            transactionCode.setCode(code);
        });
        request.getName().ifPresent(transactionCode::setName);
        request.getDescription().ifPresent(transactionCode::setDescription);
        request.getCategory().ifPresent(transactionCode::setCategory);
        request.getDefaultEntryType().ifPresent(transactionCode::setDefaultEntryType);
        request.getGlDebitAccountCode().ifPresent(transactionCode::setGlDebitAccountCode);
        request.getGlCreditAccountCode().ifPresent(transactionCode::setGlCreditAccountCode);
        request.getAllowedChannels().ifPresent(transactionCode::setAllowedChannels);
        request.getRequiresAuthorization().ifPresent(transactionCode::setRequiresAuthorization);
        request.getGeneratesTax().ifPresent(transactionCode::setGeneratesTax);
        request.getGeneratesGlEntry().ifPresent(transactionCode::setGeneratesGlEntry);
        request.getReversible().ifPresent(transactionCode::setReversible);
        request.getActive().ifPresent(transactionCode::setActive);
        request.getEffectiveDate().ifPresent(transactionCode::setEffectiveDate);
        request.getExpiryDate().ifPresent(transactionCode::setExpiryDate);

        repository.actualizar(transactionCode);
        return toResponse(transactionCode);
    }

    public void eliminarTransactionCode(Short transactionCodeId) {
        repository.buscarPorId(transactionCodeId)
            .orElseThrow(() -> new IllegalArgumentException(
                "No se encontro el codigo de transaccion con id: " + transactionCodeId));
        repository.eliminar(transactionCodeId);
    }


    private TransactionCodeResponse toResponse(TransactionCode tc) {
        return new TransactionCodeResponse(
            tc.getTransactionCodeId(),
            tc.getCode(),
            tc.getName(),
            tc.getDescription(),
            tc.getCategory(),
            tc.getDefaultEntryType(),
            tc.getGlDebitAccountCode(),
            tc.getGlCreditAccountCode(),
            tc.getAllowedChannels(),
            tc.isRequiresAuthorization(),
            tc.isGeneratesTax(),
            tc.isGeneratesGlEntry(),
            tc.isReversible(),
            tc.isActive(),
            tc.getEffectiveDate(),
            tc.getExpiryDate()
        );
    }
}
