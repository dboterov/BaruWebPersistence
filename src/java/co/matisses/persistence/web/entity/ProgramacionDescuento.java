package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PROGRAMACION_DESCUENTO")
public class ProgramacionDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReglaDescuento")
    private Long idReglaDescuento;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private Double porcentaje;
    @Basic(optional = false)
    @Column(name = "canal")
    private String canal;
    @Basic(optional = false)
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public ProgramacionDescuento() {
    }

    public Long getIdReglaDescuento() {
        return idReglaDescuento;
    }

    public void setIdReglaDescuento(Long idReglaDescuento) {
        this.idReglaDescuento = idReglaDescuento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idReglaDescuento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgramacionDescuento other = (ProgramacionDescuento) obj;
        if (!Objects.equals(this.idReglaDescuento, other.idReglaDescuento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramacionDescuento{" + "idReglaDescuento=" + idReglaDescuento + ", referencia=" + referencia + ", porcentaje=" + porcentaje + ", canal=" + canal + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
