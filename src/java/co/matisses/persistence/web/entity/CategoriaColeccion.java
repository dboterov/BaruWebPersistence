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
 * @author dbotero
 */
@Entity
@Table(name = "CATEGORIA_COLECCION")
@NamedQueries({
    @NamedQuery(name = "CategoriaColeccion.findAll", query = "SELECT c FROM CategoriaColeccion c")})
public class CategoriaColeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoriaColeccion")
    private Integer idCategoriaColeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigoSubgrupo")
    private String codigoSubgrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreSubgrupo")
    private String nombreSubgrupo;
    @JoinColumn(name = "idColeccion", referencedColumnName = "idColeccion")
    @ManyToOne(optional = false)
    private Coleccion idColeccion;

    public CategoriaColeccion() {
    }

    public CategoriaColeccion(Integer idCategoriaColeccion) {
        this.idCategoriaColeccion = idCategoriaColeccion;
    }

    public CategoriaColeccion(Integer idCategoriaColeccion, String codigoSubgrupo, String nombreSubgrupo) {
        this.idCategoriaColeccion = idCategoriaColeccion;
        this.codigoSubgrupo = codigoSubgrupo;
        this.nombreSubgrupo = nombreSubgrupo;
    }

    public Integer getIdCategoriaColeccion() {
        return idCategoriaColeccion;
    }

    public void setIdCategoriaColeccion(Integer idCategoriaColeccion) {
        this.idCategoriaColeccion = idCategoriaColeccion;
    }

    public String getCodigoSubgrupo() {
        return codigoSubgrupo;
    }

    public void setCodigoSubgrupo(String codigoSubgrupo) {
        this.codigoSubgrupo = codigoSubgrupo;
    }

    public String getNombreSubgrupo() {
        return nombreSubgrupo;
    }

    public void setNombreSubgrupo(String nombreSubgrupo) {
        this.nombreSubgrupo = nombreSubgrupo;
    }

    public Coleccion getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Coleccion idColeccion) {
        this.idColeccion = idColeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaColeccion != null ? idCategoriaColeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CategoriaColeccion)) {
            return false;
        }
        CategoriaColeccion other = (CategoriaColeccion) object;
        if ((this.idCategoriaColeccion == null && other.idCategoriaColeccion != null) || (this.idCategoriaColeccion != null && !this.idCategoriaColeccion.equals(other.idCategoriaColeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.CategoriaColeccion[ idCategoriaColeccion=" + idCategoriaColeccion + " ]";
    }
    
}
