package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "INCOTERM")
public class Incoterm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncoterm")
    private Integer idIncoterm;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public Incoterm() {
    }

    public Incoterm(Integer idIncoterm) {
        this.idIncoterm = idIncoterm;
    }

    public Incoterm(Integer idIncoterm, String codigo, String descripcion) {
        this.idIncoterm = idIncoterm;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getIdIncoterm() {
        return idIncoterm;
    }

    public void setIdIncoterm(Integer idIncoterm) {
        this.idIncoterm = idIncoterm;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncoterm != null ? idIncoterm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incoterm)) {
            return false;
        }
        Incoterm other = (Incoterm) object;
        if ((this.idIncoterm == null && other.idIncoterm != null) || (this.idIncoterm != null && !this.idIncoterm.equals(other.idIncoterm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Incoterm[ idIncoterm=" + idIncoterm + " ]";
    }
}
