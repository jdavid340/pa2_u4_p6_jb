package ec.com.uce.pa.application.service;

import java.util.List;

import ec.com.uce.pa.application.interceptor.Auditar;
import ec.com.uce.pa.domain.model.Carro;
import ec.com.uce.pa.infrastructure.CarroRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CarroService {

    @Inject
    private CarroRepositoryImpl cr;

    @Auditar
    public void crearCarro(Carro carro) {
        this.cr.persist(carro);
    }

    @Auditar
    public void crearListaCarro(List<Carro> carros) {
        carros.forEach(this.cr::persist);
    }

    @Auditar
    public void crearListaCarroParalelo(List<Carro> carros) {
        carros.parallelStream().forEach(this::crearCarro);
    }

    public List<Carro> listarCarros() {
        return this.cr.listAll();
    }

    public Carro buscarPorId(Integer id) {
        return this.cr.findById(id);
    }

    @Auditar
    public Carro actualizarCarro(Integer id, Carro carroModificado) {
        Carro entity = this.cr.findById(id);

        if (entity == null) {
            throw new IllegalArgumentException("El carro con ID " + id + " no existe.");
        }

        entity.setMarca(carroModificado.getMarca());
        entity.setModelo(carroModificado.getModelo());
        entity.setPlaca(carroModificado.getPlaca());
        entity.setAnio(carroModificado.getAnio());
        entity.setFechaRegistro(carroModificado.getFechaRegistro());

        return entity;
    }

    @Auditar
    public void eliminarCarro(Integer id) {
        this.cr.deleteById(id);
    }
}
