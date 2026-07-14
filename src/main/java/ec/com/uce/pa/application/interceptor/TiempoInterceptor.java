package ec.com.uce.pa.application.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@MedirTiempo
public class TiempoInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext ctx) throws Exception {
        Long inicio = System.currentTimeMillis();
        Object resultado = ctx.proceed();
        Long fin = System.currentTimeMillis();
        System.out.println("Tiempo Interceptor: " + (fin - inicio));

        return resultado;

    }
}
