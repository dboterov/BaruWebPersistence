package co.matisses.persistence.web.entity;

import java.io.Serializable;
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

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PRODUCTO_LISTA_REGALOS")
@NamedQueries({
    @NamedQuery(name = "ProductoListaRegalos.findAll", query = "SELECT p FROM ProductoListaRegalos p")})
public class ProductoListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductoLista")
    private Long idProductoLista;
    @JoinColumn(name = "idLista", referencedColumnName = "idLista")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ListaRegalos lista;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "descripcionProducto")
    private String descripcionProducto;
    @Basic(optional = false)
    @Column(name = "precio")
    private Integer precio;
    @Basic(optional = false)
    @Column(name = "impuesto")
    private Integer impuesto;
    @Basic(optional = false)
    @Column(name = "cantidadElegida")
    private Integer cantidadElegida;
    @Basic(optional = false)
    @Column(name = "cantidadComprada")
    private Integer cantidadComprada;
    @Basic(optional = false)
    @Column(name = "cantidadEntregada")
    private Integer cantidadEntregada;
    @Basic(optional = true)
    @Column(name = "mensajeAgradecimiento")
    private String mensajeAgradecimiento;
    @Basic(optional = false)
    @Column(name = "favorito")
    private Boolean favorito;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;

    public ProductoListaRegalos() {
    }

    public ProductoListaRegalos(Long idProductoLista) {
        this.idProductoLista = idProductoLista;
    }

    public Long getIdProductoLista() {
        return idProductoLista;
    }

    public void setIdProductoLista(Long idProductoLista) {
        this.idProductoLista = idProductoLista;
    }

    public Integer getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }

    public ListaRegalos getLista() {
        return lista;
    }

    public void setLista(ListaRegalos lista) {
        this.lista = lista;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getCantidadElegida() {
        return cantidadElegida;
    }

    public void setCantidadElegida(Integer cantidadElegida) {
        this.cantidadElegida = cantidadElegida;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Integer getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(Integer cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public String getMensajeAgradecimiento() {
        return mensajeAgradecimiento;
    }

    public void setMensajeAgradecimiento(String mensajeAgradecimiento) {
        this.mensajeAgradecimiento = mensajeAgradecimiento;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idProductoLista);
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
        final ProductoListaRegalos other = (ProductoListaRegalos) obj;
        return Objects.equals(this.idProductoLista, other.idProductoLista);
    }

    @Override
    public String toString() {
        return "ProductoListaRegalos{" + "idProductoLista=" + idProductoLista + ", lista=" + lista + ", referencia=" + referencia + ", descripcionProducto=" + descripcionProducto + ", precio=" + precio + ", impuesto=" + impuesto + ", cantidadElegida=" + cantidadElegida + ", cantidadComprada=" + cantidadComprada + ", cantidadEntregada=" + cantidadEntregada + ", mensajeAgradecimiento=" + mensajeAgradecimiento + ", favorito=" + favorito + ", activo=" + activo + '}';
    }
}