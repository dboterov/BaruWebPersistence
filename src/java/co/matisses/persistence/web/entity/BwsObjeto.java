package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_OBJETO")
@NamedQueries({
    @NamedQuery(name = "BwsObjeto.findAll", query = "SELECT b FROM BwsObjeto b")})
public class BwsObjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "java_name")
    private String javaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoObjeto")
    private List<BwsAccionObjeto> bwsAccionObjetoList;
    @OneToMany(mappedBy = "idObjeto")
    private List<BwsItemMenu> bwsItemMenuList;

    public BwsObjeto() {
    }

    public BwsObjeto(Integer codigo) {
        this.codigo = codigo;
    }

    public BwsObjeto(Integer codigo, String nombre, String javaName) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.javaName = javaName;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public List<BwsAccionObjeto> getBwsAccionObjetoList() {
        return bwsAccionObjetoList;
    }

    public void setBwsAccionObjetoList(List<BwsAccionObjeto> bwsAccionObjetoList) {
        this.bwsAccionObjetoList = bwsAccionObjetoList;
    }

    public List<BwsItemMenu> getBwsItemMenuList() {
        return bwsItemMenuList;
    }

    public void setBwsItemMenuList(List<BwsItemMenu> bwsItemMenuList) {
        this.bwsItemMenuList = bwsItemMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsObjeto)) {
            return false;
        }
        BwsObjeto other = (BwsObjeto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsObjeto[ codigo=" + codigo + " ]";
    }

}
