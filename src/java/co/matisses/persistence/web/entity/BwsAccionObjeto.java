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
@Table(name = "BWS_ACCION_OBJETO")
@NamedQueries({
    @NamedQuery(name = "BwsAccionObjeto.findAll", query = "SELECT b FROM BwsAccionObjeto b")})
public class BwsAccionObjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAccionObjeto")
    private Integer idAccionObjeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "codigo_objeto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private BwsObjeto codigoObjeto;
    @JoinColumn(name = "codigo_accion", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private BwsAccion codigoAccion;
//    @OneToMany(mappedBy = "idAccionObjeto")
//    private List<BwsItemMenu> bwsItemMenuList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccionObjeto")
//    private List<BwsPerfilAccionObjeto> bwsPerfilAccionObjetoList;

    public BwsAccionObjeto() {
    }

    public BwsAccionObjeto(Integer idAccionObjeto) {
        this.idAccionObjeto = idAccionObjeto;
    }

    public BwsAccionObjeto(Integer idAccionObjeto, String nombre) {
        this.idAccionObjeto = idAccionObjeto;
        this.nombre = nombre;
    }

    public Integer getIdAccionObjeto() {
        return idAccionObjeto;
    }

    public void setIdAccionObjeto(Integer idAccionObjeto) {
        this.idAccionObjeto = idAccionObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BwsObjeto getCodigoObjeto() {
        return codigoObjeto;
    }

    public void setCodigoObjeto(BwsObjeto codigoObjeto) {
        this.codigoObjeto = codigoObjeto;
    }

    public BwsAccion getCodigoAccion() {
        return codigoAccion;
    }

    public void setCodigoAccion(BwsAccion codigoAccion) {
        this.codigoAccion = codigoAccion;
    }

//    public List<BwsItemMenu> getBwsItemMenuList() {
//        return bwsItemMenuList;
//    }
//
//    public void setBwsItemMenuList(List<BwsItemMenu> bwsItemMenuList) {
//        this.bwsItemMenuList = bwsItemMenuList;
//    }
//
//    public List<BwsPerfilAccionObjeto> getBwsPerfilAccionObjetoList() {
//        return bwsPerfilAccionObjetoList;
//    }
//
//    public void setBwsPerfilAccionObjetoList(List<BwsPerfilAccionObjeto> bwsPerfilAccionObjetoList) {
//        this.bwsPerfilAccionObjetoList = bwsPerfilAccionObjetoList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccionObjeto != null ? idAccionObjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsAccionObjeto)) {
            return false;
        }
        BwsAccionObjeto other = (BwsAccionObjeto) object;
        if ((this.idAccionObjeto == null && other.idAccionObjeto != null) || (this.idAccionObjeto != null && !this.idAccionObjeto.equals(other.idAccionObjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsAccionObjeto[ idAccionObjeto=" + idAccionObjeto + " ]";
    }

}
