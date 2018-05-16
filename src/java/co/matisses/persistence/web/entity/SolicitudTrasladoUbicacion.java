package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "[360_SOLICITUD_UBICACION]")
public class SolicitudTrasladoUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudUbicacion")
    private Integer idSolicitudUbicacion;
    @Basic(optional = false)
    @Column(name = "absEntry")
    private Integer absEntry;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idSolicitudInforme", referencedColumnName = "idSolicitudInforme")
    @ManyToOne(optional = false)
    private SolicitudTrasladoInforme idSolicitudInforme;

    public SolicitudTrasladoUbicacion() {
    }

    public SolicitudTrasladoUbicacion(Integer idSolicitudUbicacion) {
        this.idSolicitudUbicacion = idSolicitudUbicacion;
    }

    public SolicitudTrasladoUbicacion(Integer idSolicitudUbicacion, Integer absEntry, Integer cantidad, SolicitudTrasladoInforme idSolicitudInforme) {
        this.idSolicitudUbicacion = idSolicitudUbicacion;
        this.absEntry = absEntry;
        this.cantidad = cantidad;
        this.idSolicitudInforme = idSolicitudInforme;
    }

    public Integer getIdSolicitudUbicacion() {
        return idSolicitudUbicacion;
    }

    public void setIdSolicitudUbicacion(Integer idSolicitudUbicacion) {
        this.idSolicitudUbicacion = idSolicitudUbicacion;
    }

    public Integer getAbsEntry() {
        return absEntry;
    }

    public void setAbsEntry(Integer absEntry) {
        this.absEntry = absEntry;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public SolicitudTrasladoInforme getIdSolicitudInforme() {
        return idSolicitudInforme;
    }

    public void setIdSolicitudInforme(SolicitudTrasladoInforme idSolicitudInforme) {
        this.idSolicitudInforme = idSolicitudInforme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudUbicacion != null ? idSolicitudUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudTrasladoUbicacion)) {
            return false;
        }
        SolicitudTrasladoUbicacion other = (SolicitudTrasladoUbicacion) object;
        if ((this.idSolicitudUbicacion == null && other.idSolicitudUbicacion != null) || (this.idSolicitudUbicacion != null && !this.idSolicitudUbicacion.equals(other.idSolicitudUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.SolicitudTrasladoUbicacion[ idSolicitudUbicacion=" + idSolicitudUbicacion + " ]";
    }
}
