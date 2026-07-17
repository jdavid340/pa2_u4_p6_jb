package ec.com.uce.pa.web.resource;

import java.util.List;

import ec.com.uce.pa.application.service.CarroService;
import ec.com.uce.pa.domain.model.Carro;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/carros")
public class CarroResource {

    @Inject
    private CarroService cs;

    @GET
    @Path("/todos")
    public List<Carro> listarCarros() {
        return this.cs.listarCarros();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer id) {
        Carro carro = cs.buscarPorId(id);

        if (carro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(carro).build();
    }

    @POST
    @Path("/crear")
    public Response crearCarro(Carro carro) {
        cs.crearCarro(carro);

        return Response.status(Response.Status.CREATED)
                .entity(carro)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarCarro(@PathParam("id") Integer id) {

        Carro carro = cs.buscarPorId(id);

        if (carro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cs.eliminarCarro(id);

        return Response.noContent().build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public Response actualizar(@PathParam("id") Integer id, Carro carro) {

        try {
            Carro actualizado = this.cs.actualizarCarro(id, carro);

            return Response.ok(actualizado).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarCarro(@PathParam("id") Integer id, Carro carro) {

        try {
            Carro actualizado = this.cs.actualizarCarro(id, carro);

            return Response.ok(actualizado).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
