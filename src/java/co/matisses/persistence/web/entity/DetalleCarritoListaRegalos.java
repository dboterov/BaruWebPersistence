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
@Table(name = "LISTA_REGALOS_DETALLE_CARRITO")
@NamedQueries({
    @NamedQuery(name = "DetalleCarritoListaRegalos.findAll", query = "SELECT b FROM DetalleCarritoListaRegalos b")})
public class DetalleCarritoListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCarrito")
    private Long idDetalleCarrito;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "idProductoLista")
    private Long idProductoLista;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "impuesto")
    private Integer impuesto;
    @JoinColumn(name = "idCarrito", referencedColumnName = "idCarrito")
    @ManyToOne(optional = false)
    private CarritoListaRegalos carrito;

    public DetalleCarritoListaRegalos() {
    }

    public Long getIdDetalleCarrito() {
        return idDetalleCarrito;
    }

    public void setIdDetalleCarrito(Long idDetalleCarrito) {
        this.idDetalleCarrito = idDetalleCarrito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public Long getIdProductoLista() {
        return idProductoLista;
    }

    public void setIdProductoLista(Long idProductoLista) {
        this.idProductoLista = idProductoLista;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }

    public CarritoListaRegalos getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoListaRegalos carrito) {
        this.carrito = carrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idDetalleCarrito);
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
        final DetalleCarritoListaRegalos other = (DetalleCarritoListaRegalos) obj;
        return Objects.equals(this.idDetalleCarrito, other.idDetalleCarrito);
    }

    @Override
    public String toString() {
        return "DetalleCarritoListaRegalos{" + "idDetalleCarrito=" + idDetalleCarrito + ", referencia=" + referencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idProductoLista=" + idProductoLista + ", cantidad=" + cantidad + ", precio=" + precio + ", impuesto=" + impuesto + ", carrito=" + carrito + '}';
    }

}
