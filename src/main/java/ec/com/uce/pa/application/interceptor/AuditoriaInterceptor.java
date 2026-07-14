package ec.com.uce.pa.application.interceptor;
import java.time.LocalDateTime;

import ec.com.uce.pa.domain.model.Auditoria;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Auditar
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService as;

    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception {
        System.out.println("Iniciando Auditoria");
        String nombre = ctx.getMethod().getName();

        Long tiempoInicio = System.currentTimeMillis();
        Object context = ctx.proceed();
        Object[] parametros = ctx.getParameters();
        Long tiempoFin = System.currentTimeMillis();

        Auditoria a1 = new Auditoria();
        a1.setArgumentos(null);
        a1.setNombreMetodo(nombre);
        a1.setFechaHoraEjecucion(LocalDateTime.now());

        Long tiempoFinal = tiempoFin - tiempoInicio;
        a1.setTiempoEjecucion(tiempoFinal);

        as.crear(a1);
        System.out.println("Tiempo: " +tiempoFinal+" ms");
        System.out.println("Fin auditoria");
        return context;
    }
}
