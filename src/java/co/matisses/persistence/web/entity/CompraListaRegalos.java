package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "COMPRA_LISTA_REGALOS")
@NamedQueries({
    @NamedQuery(name = "CompraListaRegalos.findAll", query = "SELECT c FROM CompraListaRegalos c")})
public class CompraListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Long idCompra;
    @JoinColumn(name = "idLista", referencedColumnName = "idLista")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ListaRegalos lista;
    @JoinColumn(name = "idProductoLista", referencedColumnName = "idProductoLista")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProductoListaRegalos producto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "quienCompra")
    private String quienCompra;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "factura")
    private String factura;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "total")
    private Long total;
    @Column(name = "devuelto")
    private Boolean devuelto;

    public CompraListaRegalos() {
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public ListaRegalos getLista() {
        return lista;
    }

    public void setLista(ListaRegalos lista) {
        this.lista = lista;
    }

    public ProductoListaRegalos getProducto() {
        return producto;
    }

    public void setProducto(ProductoListaRegalos producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getQuienCompra() {
        return quienCompra;
    }

    public void setQuienCompra(String quienCompra) {
        this.quienCompra = quienCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idCompra);
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
        final CompraListaRegalos other = (CompraListaRegalos) obj;
        if (!Objects.equals(this.idCompra, other.idCompra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompraListaRegalos{" + "idCompra=" + idCompra + ", lista=" + lista + ", producto=" + producto + ", cantidad=" + cantidad + ", quienCompra=" + quienCompra + ", fecha=" + fecha + ", factura=" + factura + ", mensaje=" + mensaje + ", total=" + total + '}';
    }

}
