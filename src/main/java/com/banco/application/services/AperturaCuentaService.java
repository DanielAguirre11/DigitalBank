package com.banco.application.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.application.dto.AperturaCuentaRequest;
import com.banco.application.dto.AperturaCuentaResponse;
import com.banco.application.port.out.ClienteRepository;
import com.banco.application.port.out.CuentaRepository;
import com.banco.application.port.out.TransaccionRepository;
import com.banco.domain.model.entities.Cliente;
import com.banco.domain.model.entities.Cuenta;
import com.banco.domain.model.entities.Transaccion;
import com.banco.domain.model.valueobjects.ClienteId;
import com.banco.domain.model.valueobjects.CuentaId;
import com.banco.domain.model.valueobjects.Dinero;
import com.banco.domain.model.valueobjects.Moneda;
import com.banco.domain.model.valueobjects.TipoCuenta;
import com.banco.domain.model.valueobjects.TransaccionId;
import com.banco.domain.model.valueobjects.TransaccionId.TipoTransaccion;




@Service
@Transactional
public class AperturaCuentaService {

    //INYECCION DE DEPENDENCIA
    private final ClienteRepository clienteRepository;
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    // CONSTRUCTOR CON INYECCIÓN
    public AperturaCuentaService(ClienteRepository clienteRepository, CuentaRepository cuentaRepository,
            TransaccionRepository transaccionRepository) {
        this.clienteRepository = clienteRepository;
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }




    // METODOS DE CUENTA
    public AperturaCuentaResponse ejecutarAperturaCuenta(AperturaCuentaRequest request){

        validarRequest(request);

        //CARGAR Y VALIDAR CLIENTE
        Cliente cliente = cargarYValidarCliente(request);

        //CREAR VALUE OBJECTS
        Moneda moneda = Moneda.fromCodigo(request.getMoneda());
        TipoCuenta tipoCuenta = TipoCuenta.fromString(request.getTipoCuenta());

        //GENERAR NUMERO DE CUENTA UNICO
        CuentaId cuentaId = generarNumeroCuenta(request.getSucursal());

        //CREAR ENTIDAD CUENTA
        Cuenta cuenta = crearCuenta(cuentaId, cliente.getClienteId(), moneda, tipoCuenta);

        //PROCESAR SALDO INICIAL (si existe)
        if(request.getSaldoInicial() != null && request.getSaldoInicial().compareTo(BigDecimal.ZERO) > 0){
            saldoInicialMinimo(cuenta, request.getSaldoInicial(), moneda);
        }

        //ASOCIAR CUENTA AL CLIENTE
        cliente.agregarCuenta(cuentaId);

        // GUARDAR CAMBIOS
        clienteRepository.actualizar(cliente);
        cuentaRepository.guardar(cuenta);

        return crearRespuestaExitosa(cuenta, request, cliente);
    }


    private Cuenta crearCuenta(CuentaId cuentaId, ClienteId clienteId, Moneda moneda, TipoCuenta tipoCuenta){
        Cuenta cuenta = new Cuenta(cuentaId, clienteId, moneda);
        System.out.println("Cuenta creada: " + cuentaId + " - Tipo: " + tipoCuenta + " - Moneda: " + moneda);
        return cuenta;
    }

    private void saldoInicialMinimo(Cuenta cuenta, BigDecimal monto, Moneda moneda){

        //VALIDAR MONTO MÍNIMO (ejemplo: $100 para cuentas corrientes)
        BigDecimal minimo = new BigDecimal("100");
        if(monto.compareTo(minimo) < 0) throw new IllegalArgumentException(
            "Saldo inicial minimo $" + minimo + ". Se recibio $" + monto);

        Dinero saldoInicial = new Dinero(monto, moneda);
        cuenta.depositar(saldoInicial);

        //CREAR TRANSACCIÓN DE APERTURA
        Transaccion transaccionApertura = new Transaccion(
            generarIdTransaccion(),
            TipoTransaccion.DEPOSITO,
            null,
            cuenta.getCuentaId(),
            saldoInicial,
            "Deposito inicial apertura de cuenta");

        transaccionApertura.completar();
        transaccionRepository.guardar(transaccionApertura);

        System.out.println("Saldo inicial depositado: " + saldoInicial);
    }

    private TransaccionId generarIdTransaccion() {
        int año = java.time.Year.now().getValue();
        String id = "TXN-" + año + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
        return new TransaccionId(id);
    }

    public void cerrarCuenta(String cuentaString){
        CuentaId cuentaId = CuentaId.newCuentaId(cuentaString);
        Cuenta cuenta = cuentaRepository.buscarPorId(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.cerrar();
        cuentaRepository.actualizar(cuenta);
        System.out.println("Cuenta cerrada: " + cuentaId);
    }

    public void abrirCuenta(String cuentaString){
        CuentaId cuentaId = CuentaId.newCuentaId(cuentaString);
        Cuenta cuenta = cuentaRepository.buscarPorId(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.activarCuenta();
        cuentaRepository.actualizar(cuenta);
        System.out.println("Cuenta activada: " + cuentaId);
    }


    //VALIDACIONES DATOS DE ENTRADA
    private void validarRequest(AperturaCuentaRequest request){

        if(request == null) throw new IllegalArgumentException("La solicitud no puede ser nula");

        if(request.getClienteId() == null) throw new IllegalArgumentException("Se necesita id del cliente");

        if(request.getMoneda() == null) throw new IllegalArgumentException("Se requiere moneda");

        if(request.getTipoCuenta() == null) throw new IllegalArgumentException("Se requiere tipo de cuenta");

        if(request.getSaldoInicial() != null && request.getSaldoInicial().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El saldo inicial no puede ser menor a 0");
    }

    private Cliente cargarYValidarCliente(AperturaCuentaRequest request){
        return clienteRepository.buscarPorId(request.getClienteId())
            .filter(c -> c.getActiva())
            .orElseThrow(() -> new IllegalStateException(
                "Cliente no encontrado o inactivo: " + request.getClienteId()));
    }

    private int calcularDigitoVerificador(String numero) {
        int suma = 0;
        boolean doble = false;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));

            if (doble) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }

            suma += digito;
            doble = !doble;
        }

        return (10 - (suma % 10)) % 10;
    }

    private CuentaId generarNumeroCuenta(String sucursal){
        String codigoPais = "ARG";
        String codigoBanco = "017";
        String codigoSucursal = sucursal != null
            ? String.format("%03d", Integer.parseInt(sucursal)) : "001";

        long secuencia = System.currentTimeMillis() % 100000000L;
        String numeroSecuencial = String.format("%08d", secuencia);

        String base = codigoBanco + codigoSucursal + numeroSecuencial + "0000000".substring(0, 7);
        int digitoVerificador = calcularDigitoVerificador(base);

        String numeroCompleto = codigoPais + base + digitoVerificador;
        return CuentaId.newCuentaId(numeroCompleto);
    }


    // RESPUESTA EXITOSA
    public AperturaCuentaResponse crearRespuestaExitosa(Cuenta cuenta, AperturaCuentaRequest request, Cliente cliente) {

        String mensaje = String.format(
            "Cuenta %s creada exitosamente para %s. %s",
            cuenta.getCuentaId(),
            cliente.getNombre(),
            request.getSaldoInicial() != null &&
            request.getSaldoInicial().compareTo(BigDecimal.ZERO) > 0 ?
            "Saldo inicial: $" + request.getSaldoInicial() : "Sin saldo inicial"
        );

        return new AperturaCuentaResponse(
            cuenta.getCuentaId().getValor(),
            cliente.getClienteId().getValor(),
            request.getTipoCuenta(),
            request.getMoneda(),
            request.getSaldoInicial(),
            LocalDateTime.now(),
            mensaje
        );
    }

}
