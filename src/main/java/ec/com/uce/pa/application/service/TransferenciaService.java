package ec.com.uce.pa.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransferenciaService {

    @Inject
    private CuentaBancariaService cbs;

    @Inject
    private MailService ms;

    @Inject
    private AuditoriaService as;

    public String realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {

        BigDecimal saldoDestino = this.cbs.agregarMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen = this.cbs.restaMonto(cuentaOrigen, monto);

        this.ms.enviarMail("rocket@email.com", "asunto", "mensaje");
        this.as.guardar("Auditoria");
        String mensaje = "Se realizo con exito su saldo destino es: " + saldoDestino + " su saldo Origen es: "
                + saldoOrigen;
        return mensaje;
    }

    public String transferenciaReactica(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
        Uni<BigDecimal> saldoDestino = this.cbs.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.cbs.restaMontoPromesa(cuentaOrigen, monto);

        return Uni.combine()
                .all()
                .unis(saldoDestino, saldoOrigen)
                .asTuple()
                .map((result) -> {
                    String mensaje= "Se realizó con éxito. Saldo destino: "
                            + result.getItem1()
                            + ", Saldo origen: "
                            + result.getItem2();

                    ms.enviarMail("rocket@email.com", "asunto", "mensaje");
                    as.guardar("Auditoria");

                    return mensaje;
                })
                .await().indefinitely();


    }
}
