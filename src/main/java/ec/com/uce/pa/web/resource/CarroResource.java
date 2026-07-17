package ec.com.uce.pa.web.resource;

import java.util.List;

import ec.com.uce.pa.application.service.CarroService;
import ec.com.uce.pa.domain.model.Carro;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path(("/carros"))
public class CarroResource {

    @Inject
    private CarroService cs;

    @GET
    public List<Carro> listarCarros() {
        return this.cs.listarCarros();
    }
}
