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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CONTENEDOR_PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "ContenedorProveedor.findAll", query = "SELECT c FROM ContenedorProveedor c")})
public class ContenedorProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContenedorProveedor")
    private Integer idContenedorProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigoProveedor")
    private String codigoProveedor;
    @Column(name = "volumenReal")
    private Integer volumenReal;
    @JoinColumn(name = "idContenedor", referencedColumnName = "idContenedor")
    @ManyToOne(optional = false)
    private Contenedor idContenedor;

    public ContenedorProveedor() {
    }

    public ContenedorProveedor(Integer idContenedorProveedor) {
        this.idContenedorProveedor = idContenedorProveedor;
    }

    public ContenedorProveedor(Integer idContenedorProveedor, String codigoProveedor) {
        this.idContenedorProveedor = idContenedorProveedor;
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getIdContenedorProveedor() {
        return idContenedorProveedor;
    }

    public void setIdContenedorProveedor(Integer idContenedorProveedor) {
        this.idContenedorProveedor = idContenedorProveedor;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Integer getVolumenReal() {
        return volumenReal;
    }

    public void setVolumenReal(Integer volumenReal) {
        this.volumenReal = volumenReal;
    }

    public Contenedor getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(Contenedor idContenedor) {
        this.idContenedor = idContenedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContenedorProveedor != null ? idContenedorProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenedorProveedor)) {
            return false;
        }
        ContenedorProveedor other = (ContenedorProveedor) object;
        if ((this.idContenedorProveedor == null && other.idContenedorProveedor != null) || (this.idContenedorProveedor != null && !this.idContenedorProveedor.equals(other.idContenedorProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ContenedorProveedor[ idContenedorProveedor=" + idContenedorProveedor + " ]";
    }
}
 