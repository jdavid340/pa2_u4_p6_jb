package ec.com.uce.pa.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "carro")
@Entity
public class Carro extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro_generador")
    @SequenceGenerator(name = "seq_carro_generador", sequenceName = "seq_carro", allocationSize = 1)
    @Column(name = "carr_id")
    private Integer id;

    @Column(name = "carr_placa")
    private String placa;

    @Column(name = "carr_marca")
    private String marca;

    @Column(name = "carr_modelo")
    private String modelo;

    @Column(name = "carr_anio")
    private Integer anio;

    @Column(name = "carr_fecha_registro")
    private LocalDate fechaRegistro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Carro [id=" + id + ", placa=" + placa + ", marca=" + marca
                + ", modelo=" + modelo + ", anio=" + anio
                + ", fechaRegistro=" + fechaRegistro + "]";
    }
}