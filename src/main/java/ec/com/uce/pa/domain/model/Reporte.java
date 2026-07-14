package ec.com.uce.pa.domain.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "reporte")
@Entity
public class Reporte extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")
    @SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
    @Column(name = "rep_id")
    private Integer id;

    @Column(name = "rep_nombre")
    private String nombre;

    @Column(name = "rep_descripcion")
    private String descripcion;

    @Column(name = "rep_tipo")
    private String tipo;

    @Column(name = "rep_fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @Column(name = "rep_estado")
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reporte [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", tipo=" + tipo + ", fechaGeneracion=" + fechaGeneracion
                + ", estado=" + estado + "]";
    }
}