package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_PERFIL")
@NamedQueries({
    @NamedQuery(name = "BwsPerfil.findAll", query = "SELECT b FROM BwsPerfil b")})
public class BwsPerfil implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPerfil", fetch = FetchType.EAGER)
    private List<BwsPerfilAccionObjeto> bwsPerfilAccionObjetoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPerfil", fetch = FetchType.EAGER)
    private List<BwsPerfilUsuario> bwsPerfilUsuarioList;

    public BwsPerfil() {
    }

    public BwsPerfil(Integer codigo) {
        this.codigo = codigo;
    }

    public BwsPerfil(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public List<BwsPerfilAccionObjeto> getBwsPerfilAccionObjetoList() {
        return bwsPerfilAccionObjetoList;
    }

    public void setBwsPerfilAccionObjetoList(List<BwsPerfilAccionObjeto> bwsPerfilAccionObjetoList) {
        this.bwsPerfilAccionObjetoList = bwsPerfilAccionObjetoList;
    }

    public List<BwsPerfilUsuario> getBwsPerfilUsuarioList() {
        return bwsPerfilUsuarioList;
    }

    public void setBwsPerfilUsuarioList(List<BwsPerfilUsuario> bwsPerfilUsuarioList) {
        this.bwsPerfilUsuarioList = bwsPerfilUsuarioList;
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
        if (!(object instanceof BwsPerfil)) {
            return false;
        }
        BwsPerfil other = (BwsPerfil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsPerfil[ codigo=" + codigo + " ]";
    }
    
}
