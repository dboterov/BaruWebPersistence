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
@Table(name = "DETALLE_IMPRESION_STICKER")
public class DetalleImpresionSticker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleImpresionSticker")
    private Integer idDetalleImpresionSticker;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "almacen")
    private String almacen;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "nombreReferencia")
    private String nombreReferencia;
    @Column(name = "referenciaProveedor")
    private String referenciaProveedor;
    @Column(name = "precio")
    private Integer precio;
    @JoinColumn(name = "idImpresionSticker", referencedColumnName = "idImpresionSticker")
    @ManyToOne(optional = false)
    private ImpresionSticker idImpresionSticker;

    public DetalleImpresionSticker() {
    }

    public DetalleImpresionSticker(Integer idDetalleImpresionSticker) {
        this.idDetalleImpresionSticker = idDetalleImpresionSticker;
    }

    public DetalleImpresionSticker(Integer idDetalleImpresionSticker, String referencia, Integer cantidad, String almacen, Date fecha, String nombreReferencia,
            String referenciaProveedor, Integer precio, ImpresionSticker idImpresionSticker) {
        this.idDetalleImpresionSticker = idDetalleImpresionSticker;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.almacen = almacen;
        this.fecha = fecha;
        this.nombreReferencia = nombreReferencia;
        this.referenciaProveedor = referenciaProveedor;
        this.precio = precio;
        this.idImpresionSticker = idImpresionSticker;
    }

    public Integer getIdDetalleImpresionSticker() {
        return idDetalleImpresionSticker;
    }

    public void setIdDetalleImpresionSticker(Integer idDetalleImpresionSticker) {
        this.idDetalleImpresionSticker = idDetalleImpresionSticker;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }

    public void setNombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    public String getReferenciaProveedor() {
        return referenciaProveedor;
    }

    public void setReferenciaProveedor(String referenciaProveedor) {
        this.referenciaProveedor = referenciaProveedor;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public ImpresionSticker getIdImpresionSticker() {
        return idImpresionSticker;
    }

    public void setIdImpresionSticker(ImpresionSticker idImpresionSticker) {
        this.idImpresionSticker = idImpresionSticker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleImpresionSticker != null ? idDetalleImpresionSticker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleImpresionSticker)) {
            return false;
        }
        DetalleImpresionSticker other = (DetalleImpresionSticker) object;
        if ((this.idDetalleImpresionSticker == null && other.idDetalleImpresionSticker != null) || (this.idDetalleImpresionSticker != null && !this.idDetalleImpresionSticker.equals(other.idDetalleImpresionSticker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleImpresionSticker[ idDetalleImpresionSticker=" + idDetalleImpresionSticker + " ]";
    }
}
