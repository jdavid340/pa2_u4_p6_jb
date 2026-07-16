package ec.com.uce.pa.application.service;

import java.util.List;

import ec.com.uce.pa.application.interceptor.Auditar;
import ec.com.uce.pa.domain.model.Reporte;
import ec.com.uce.pa.infrastructure.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl rr;

    @Auditar
    public void guardar(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre hilo guardar ReporteService:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        this.rr.persist(reporte);
    }

    public Reporte buscarPorId(Integer id) {
        return this.rr.findById(id);
    }

    @Auditar
    public void guardarListaReporte(List<Reporte> lista) {
        for (Reporte reporte : lista) {
            guardar(reporte);
        }

    }

    @Auditar
    public void guardarListaReporteParalelo(List<Reporte> lista) {
        lista.parallelStream()
                .forEach(reporte -> {
                    this.guardar(reporte);
                });

    }

    @Auditar
    public Reporte actualizar(Integer id, Reporte reporteModificado) {

        Reporte entity = this.rr.findById(id);

        if (entity == null) {
            throw new IllegalArgumentException("El reporte con ID " + id + " no existe.");
        }

        if (reporteModificado.getNombre() != null) {
            entity.setNombre(reporteModificado.getNombre());
        }

        if (reporteModificado.getDescripcion() != null) {
            entity.setDescripcion(reporteModificado.getDescripcion());
        }

        if (reporteModificado.getTipo() != null) {
            entity.setTipo(reporteModificado.getTipo());
        }

        if (reporteModificado.getFechaGeneracion() != null) {
            entity.setFechaGeneracion(reporteModificado.getFechaGeneracion());
        }

        if (reporteModificado.getEstado() != null) {
            entity.setEstado(reporteModificado.getEstado());
        }

        return entity;
    }

    @Auditar
    public boolean eliminar(Integer id) {
        return this.rr.deleteById(id);
    }

    public List<Reporte> listarTodos() {
        return this.rr.listAll();
    }
}
