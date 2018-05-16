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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "DETALLE_COTIZACION_WEB")
@NamedQueries({
    @NamedQuery(name = "DetalleCotizacionWeb.findAll", query = "SELECT d FROM DetalleCotizacionWeb d"),
    @NamedQuery(name = "DetalleCotizacionWeb.findByIdCotizacion", query = "SELECT d FROM DetalleCotizacionWeb d WHERE d.idCotizacion = :idCotizacion")})
public class DetalleCotizacionWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCotizacion")
    private Long idDetalleCotizacion;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "bodega")
    private String bodega;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = true)
    @Column(name = "precioUnitario")
    private double precioUnitario;
    @Basic(optional = true)
    @Column(name = "refProveedor")
    private String refProveedor;
    @Basic(optional = true)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idCotizacion", referencedColumnName = "idCotizacion")
    @ManyToOne(optional = true)
    private CotizacionWeb idCotizacion;

    public DetalleCotizacionWeb() {
    }

    public DetalleCotizacionWeb(Long idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public DetalleCotizacionWeb(Long idDetalleCotizacion, String referencia, String bodega, int cantidad, double precioUnitario, String refProveedor, String descripcion, CotizacionWeb idCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
        this.referencia = referencia;
        this.bodega = bodega;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.refProveedor = refProveedor;
        this.descripcion = descripcion;
        this.idCotizacion = idCotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRefProveedor() {
        return refProveedor;
    }

    public void setRefProveedor(String refProveedor) {
        this.refProveedor = refProveedor;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getIdDetalleCotizacion() {
        return idDetalleCotizacion;
    }

    public void setIdDetalleCotizacion(Long idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CotizacionWeb getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(CotizacionWeb idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCotizacion != null ? idDetalleCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCotizacionWeb)) {
            return false;
        }
        DetalleCotizacionWeb other = (DetalleCotizacionWeb) object;
        if ((this.idDetalleCotizacion == null && other.idDetalleCotizacion != null) || (this.idDetalleCotizacion != null && !this.idDetalleCotizacion.equals(other.idDetalleCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.DetalleCotizacionWeb[ idDetalleCotizacion=" + idDetalleCotizacion + " ]";
    }
}
