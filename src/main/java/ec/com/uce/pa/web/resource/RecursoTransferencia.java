package ec.com.uce.pa.web.resource;

import ec.com.uce.pa.application.interceptor.MedirTiempo;
import ec.com.uce.pa.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/transferencia")
public class RecursoTransferencia {
    @Inject
    private TransferenciaService ts;

    @Path("/realizar")
    @POST
    @MedirTiempo
    public String realizarTransferencia(TransferenciaResource transferencia) {
        System.out.println("Hilo: " + Thread.currentThread().threadId());

        return this.ts.transferenciaReactica(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(),
                transferencia.getMonto());
    }
}
