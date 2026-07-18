package ec.com.uce.pa.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    public BigDecimal agregarMonto(String numeroCuenta, BigDecimal monto) {
        System.out.println("Hilo: " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo = saldo.add(monto);
        return saldo;
    }

    public BigDecimal restaMonto(String numeroCuenta, BigDecimal monto) {
        System.out.println("Hilo: " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo = saldo.subtract(monto);
        return saldo;
    }

    public Uni<BigDecimal> agregarMontoPromesa(String numeroCuenta, BigDecimal monto) {

        return Uni.createFrom().item(() -> {

            System.out.println("Agregar hilo: "
                    + Thread.currentThread().threadId());

            return this.agregarMonto(numeroCuenta, monto);
        });
    }

    public Uni<BigDecimal> restaMontoPromesa(String numeroCuenta, BigDecimal monto) {
        System.out.println("Hilo: " + Thread.currentThread().threadId());
        return Uni.createFrom().item(() -> {
            System.out.println("Agregar hilo: "
                    + Thread.currentThread().threadId());
            return this.restaMonto(numeroCuenta, monto);
        });
    }
}
