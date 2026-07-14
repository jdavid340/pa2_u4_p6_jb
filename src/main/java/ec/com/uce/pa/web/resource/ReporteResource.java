package ec.com.uce.pa.web.resource;

import java.util.List;

import ec.com.uce.pa.application.service.ReporteService;
import ec.com.uce.pa.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService rs;

    public Reporte buscarPorId(Integer id){
        return this.rs.buscarPorId(id);
    }

    public List<Reporte> buscarTodos(){
        return this.rs.listarTodos();
    }
}
