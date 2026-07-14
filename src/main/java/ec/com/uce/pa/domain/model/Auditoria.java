package ec.com.uce.pa.domain.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_auditoria")
    @SequenceGenerator(name="seq_auditoria", allocationSize=1, sequenceName="seq_auditoria")
    private Long id;

    private String nombreMetodo;

    private String argumentos;

    private LocalDateTime fechaHoraEjecucion;

    private Long tiempoEjecucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }


    

    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    public LocalDateTime getFechaHoraEjecucion() {
        return fechaHoraEjecucion;
    }

    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;
    }

    
}
