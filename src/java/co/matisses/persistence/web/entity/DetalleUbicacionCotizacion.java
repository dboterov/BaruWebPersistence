package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "DETALLE_UBICACION_COTIZACION")
@NamedQueries({
    @NamedQuery(name = "DetalleUbicacionCotizacion.findAll", query = "SELECT d FROM DetalleUbicacionCotizacion d")})
public class DetalleUbicacionCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleUbicacion")
    private Long idDetalleUbicacion;
    @Basic(optional = false)
    @Column(name = "idDetalleCotizacion")
    private Long idDetalleCotizacion;
    @Basic(optional = false)
    @Column(name = "codigoUbicacion")
    private String codigoUbicacion;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    public DetalleUbicacionCotizacion() {
    }

    public DetalleUbicacionCotizacion(Long idDetalleUbicacion) {
        this.idDetalleUbicacion = idDetalleUbicacion;
    }

    public DetalleUbicacionCotizacion(Long idDetalleUbicacion, String codigoUbicacion, int cantidad) {
        this.idDetalleUbicacion = idDetalleUbicacion;
        this.codigoUbicacion = codigoUbicacion;
        this.cantidad = cantidad;
    }

    public Long getIdDetalleUbicacion() {
        return idDetalleUbicacion;
    }

    public void setIdDetalleUbicacion(Long idDetalleUbicacion) {
        this.idDetalleUbicacion = idDetalleUbicacion;
    }

    public Long getIdDetalleCotizacion() {
        return idDetalleCotizacion;
    }

    public void setIdDetalleCotizacion(Long idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public String getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(String codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleUbicacion != null ? idDetalleUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleUbicacionCotizacion)) {
            return false;
        }
        DetalleUbicacionCotizacion other = (DetalleUbicacionCotizacion) object;
        if ((this.idDetalleUbicacion == null && other.idDetalleUbicacion != null) || (this.idDetalleUbicacion != null && !this.idDetalleUbicacion.equals(other.idDetalleUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.DetalleUbicacionCotizacion[ idDetalleUbicacion=" + idDetalleUbicacion + " ]";
    }

}
