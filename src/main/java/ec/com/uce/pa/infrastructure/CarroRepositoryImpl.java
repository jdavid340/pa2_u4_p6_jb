package ec.com.uce.pa.infrastructure;

import ec.com.uce.pa.domain.model.Carro;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class CarroRepositoryImpl implements PanacheRepositoryBase<Carro, Integer>{


    
}
