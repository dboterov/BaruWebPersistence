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

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_PERFIL_ACCION_OBJETO")
@NamedQueries({
    @NamedQuery(name = "BwsPerfilAccionObjeto.findAll", query = "SELECT b FROM BwsPerfilAccionObjeto b")})
public class BwsPerfilAccionObjeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerfilAccionObjeto")
    private Integer idPerfilAccionObjeto;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private BwsPerfil codigoPerfil;
    @JoinColumn(name = "idAccionObjeto", referencedColumnName = "idAccionObjeto")
    @ManyToOne(optional = false)
    private BwsAccionObjeto idAccionObjeto;

    public BwsPerfilAccionObjeto() {
    }

    public BwsPerfilAccionObjeto(Integer idPerfilAccionObjeto) {
        this.idPerfilAccionObjeto = idPerfilAccionObjeto;
    }

    public Integer getIdPerfilAccionObjeto() {
        return idPerfilAccionObjeto;
    }

    public void setIdPerfilAccionObjeto(Integer idPerfilAccionObjeto) {
        this.idPerfilAccionObjeto = idPerfilAccionObjeto;
    }

    public BwsPerfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(BwsPerfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public BwsAccionObjeto getIdAccionObjeto() {
        return idAccionObjeto;
    }

    public void setIdAccionObjeto(BwsAccionObjeto idAccionObjeto) {
        this.idAccionObjeto = idAccionObjeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilAccionObjeto != null ? idPerfilAccionObjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsPerfilAccionObjeto)) {
            return false;
        }
        BwsPerfilAccionObjeto other = (BwsPerfilAccionObjeto) object;
        if ((this.idPerfilAccionObjeto == null && other.idPerfilAccionObjeto != null) || (this.idPerfilAccionObjeto != null && !this.idPerfilAccionObjeto.equals(other.idPerfilAccionObjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsPerfilAccionObjeto[ idPerfilAccionObjeto=" + idPerfilAccionObjeto + " ]";
    }
    
}
