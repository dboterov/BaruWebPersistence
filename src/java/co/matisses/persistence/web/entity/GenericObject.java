package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "GENERIC_OBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericObject.findAll", query = "SELECT g FROM GenericObject g")})
public class GenericObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idGenericObject")
    private Long idGenericObject;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public GenericObject() {
    }

    public GenericObject(Long idGenericObject) {
        this.idGenericObject = idGenericObject;
    }

    public GenericObject(Long idGenericObject, String name, String type) {
        this.idGenericObject = idGenericObject;
        this.name = name;
        this.type = type;
    }

    public Long getIdGenericObject() {
        return idGenericObject;
    }

    public void setIdGenericObject(Long idGenericObject) {
        this.idGenericObject = idGenericObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenericObject != null ? idGenericObject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericObject)) {
            return false;
        }
        GenericObject other = (GenericObject) object;
        if ((this.idGenericObject == null && other.idGenericObject != null) || (this.idGenericObject != null && !this.idGenericObject.equals(other.idGenericObject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.webintegrator.dto.GenericObject[ idGenericObject=" + idGenericObject + " ]";
    }

}
