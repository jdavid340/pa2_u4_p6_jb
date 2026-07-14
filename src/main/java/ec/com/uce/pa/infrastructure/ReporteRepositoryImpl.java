package ec.com.uce.pa.infrastructure;

import ec.com.uce.pa.domain.model.Reporte;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteRepositoryImpl  implements PanacheRepositoryBase<Reporte, Integer> {

}
