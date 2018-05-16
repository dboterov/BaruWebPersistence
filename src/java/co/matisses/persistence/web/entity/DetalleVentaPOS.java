package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "DETALLE_VENTA_POS")
@NamedQueries({
    @NamedQuery(name = "DetalleVentaPOS.findAll", query = "SELECT d FROM DetalleVentaPOS d")})
public class DetalleVentaPOS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleVenta")
    private Long idDetalleVenta;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVentaPOS")
    @ManyToOne(optional = false)
    private VentaPOS idVenta;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "refProveedor")
    private String refProveedor;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "precio")
    private Integer precio;
    @Basic(optional = false)
    @Column(name = "descuento")
    private Integer descuento;
    @Basic(optional = false)
    @Column(name = "impuesto")
    private Integer impuesto;

    public DetalleVentaPOS() {
    }

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public VentaPOS getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(VentaPOS idVenta) {
        this.idVenta = idVenta;
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

    public String getRefProveedor() {
        return refProveedor;
    }

    public void setRefProveedor(String refProveedor) {
        this.refProveedor = refProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Integer getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "DetalleVentaPOS{" + "idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", referencia=" + referencia + ", cantidad=" + cantidad + ", refProveedor=" + refProveedor + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + ", impuesto=" + impuesto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idDetalleVenta);
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
        final DetalleVentaPOS other = (DetalleVentaPOS) obj;
        if (!Objects.equals(this.idDetalleVenta, other.idDetalleVenta)) {
            return false;
        }
        return true;
    }

}
