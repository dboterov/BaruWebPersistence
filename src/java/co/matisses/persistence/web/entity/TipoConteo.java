package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "TIPO_CONTEO")
public class TipoConteo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTipoConteo")
    private Integer idTipoConteo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoConteo() {
    }

    public TipoConteo(Integer idTipoConteo) {
        this.idTipoConteo = idTipoConteo;
    }

    public TipoConteo(Integer idTipoConteo, String nombre, String descripcion) {
        this.idTipoConteo = idTipoConteo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoConteo() {
        return idTipoConteo;
    }

    public void setIdTipoConteo(Integer idTipoConteo) {
        this.idTipoConteo = idTipoConteo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoConteo != null ? idTipoConteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConteo)) {
            return false;
        }
        TipoConteo other = (TipoConteo) object;
        if ((this.idTipoConteo == null && other.idTipoConteo != null) || (this.idTipoConteo != null && !this.idTipoConteo.equals(other.idTipoConteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TipoConteo[ idTipoConteo=" + idTipoConteo + " ]";
    }
}
