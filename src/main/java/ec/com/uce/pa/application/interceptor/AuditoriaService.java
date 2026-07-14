package ec.com.uce.pa.application.interceptor;

import ec.com.uce.pa.domain.model.Auditoria;
import ec.com.uce.pa.infrastructure.AuditoriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuditoriaService {

    @Inject
    private AuditoriaRepositoryImpl au;

    public void crear(Auditoria auditoria) {
        this.au.crear(auditoria);
    }
}
