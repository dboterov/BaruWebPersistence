package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "LISTA_REGALOS_CARRITO")
@NamedQueries({
    @NamedQuery(name = "CarritoListaRegalos.findAll", query = "SELECT b FROM CarritoListaRegalos b")})
public class CarritoListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrito")
    private Long idCarrito;
    @Column(name = "idSesion")
    private String idSesion;
    @Column(name = "tipoSesion")
    private String tipoSesion;
    @Column(name = "nit")
    private String nit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrito",fetch = FetchType.EAGER)
    private List<DetalleCarritoListaRegalos> productos;

    public CarritoListaRegalos() {
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getTipoSesion() {
        return tipoSesion;
    }

    public void setTipoSesion(String tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<DetalleCarritoListaRegalos> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleCarritoListaRegalos> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idCarrito);
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
        final CarritoListaRegalos other = (CarritoListaRegalos) obj;
        return Objects.equals(this.idCarrito, other.idCarrito);
    }

    @Override
    public String toString() {
        return "CarritoListaRegalos{" + "idCarrito=" + idCarrito + ", idSesion=" + idSesion + ", tipoSesion=" + tipoSesion + ", nit=" + nit + ", productos=" + productos + '}';
    }

}
