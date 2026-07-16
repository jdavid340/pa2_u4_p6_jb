package ec.com.uce.pa.web.resource;

import java.util.List;

import ec.com.uce.pa.application.service.ReporteService;
import ec.com.uce.pa.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService rs;

    @GET
    @Path("/todos")
    public List<Reporte> buscarTodos() {
        return this.rs.listarTodos();
    }

    @Path("/{id}")
    @GET
    public Response buscarPorIdCodigo(@PathParam("id") Integer id) {
        Reporte reporte = rs.buscarPorId(id);
        if (reporte == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(reporte).build();
    }

    @POST
    @Path("/crear")
    public Response crearReporte(Reporte reporte) {
        rs.guardar(reporte);
        return Response.status(Response.Status.CREATED)
                .entity(reporte)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarReporte(@PathParam("id") Integer id) {

        Reporte reporte = rs.buscarPorId(id);

        if (reporte == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        rs.eliminar(id);

        return Response.noContent().build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public void actualizar(@PathParam("id") Integer id, Reporte reporte) {

        this.rs.actualizar(id, reporte);
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarReporte(@PathParam("id") Integer id, Reporte reporte) {

        try {
            Reporte actualizado = rs.actualizar(id, reporte);

            return Response.ok(actualizado).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
