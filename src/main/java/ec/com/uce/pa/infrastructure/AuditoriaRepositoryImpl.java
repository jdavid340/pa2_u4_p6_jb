package ec.com.uce.pa.infrastructure;

import ec.com.uce.pa.domain.model.Auditoria;
import ec.com.uce.pa.domain.repository.AuditoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@ApplicationScoped
@Transactional
public class AuditoriaRepositoryImpl implements  AuditoriaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Auditoria auditoria) {
        this.em.persist(auditoria);
    }


}
