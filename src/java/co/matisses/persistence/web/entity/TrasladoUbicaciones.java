package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "[360_TRASLADO_UBICACION]")
public class TrasladoUbicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrasladoUbicacion")
    private Integer idTrasladoUbicacion;
    @Basic(optional = true)
    @Column(name = "ubicacionOrigen")
    private String ubicacionOrigen;
    @Basic(optional = true)
    @Column(name = "ubicacionDestino")
    private String ubicacionDestino;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idTrasladoDetalle", referencedColumnName = "idTrasladoDetalle")
    @ManyToOne
    private TrasladoDetalle idTrasladoDetalle;

    public TrasladoUbicaciones() {
    }

    public TrasladoUbicaciones(Integer idTrasladoUbicacion) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
    }

    public TrasladoUbicaciones(Integer idTrasladoUbicacion, String ubicacionOrigen, String ubicacionDestino, Integer cantidad, Date fecha, TrasladoDetalle idTrasladoDetalle) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
        this.ubicacionOrigen = ubicacionOrigen;
        this.ubicacionDestino = ubicacionDestino;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.idTrasladoDetalle = idTrasladoDetalle;
    }

    public Integer getIdTrasladoUbicacion() {
        return idTrasladoUbicacion;
    }

    public void setIdTrasladoUbicacion(Integer idTrasladoUbicacion) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
    }

    public String getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(String ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TrasladoDetalle getIdTrasladoDetalle() {
        return idTrasladoDetalle;
    }

    public void setIdTrasladoDetalle(TrasladoDetalle idTrasladoDetalle) {
        this.idTrasladoDetalle = idTrasladoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrasladoUbicacion != null ? idTrasladoUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoUbicaciones)) {
            return false;
        }
        TrasladoUbicaciones other = (TrasladoUbicaciones) object;
        if ((this.idTrasladoUbicacion == null && other.idTrasladoUbicacion != null) || (this.idTrasladoUbicacion != null && !this.idTrasladoUbicacion.equals(other.idTrasladoUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TrasladoUbicaciones[ idTrasladoUbicacion=" + idTrasladoUbicacion + " ]";
    }

}
