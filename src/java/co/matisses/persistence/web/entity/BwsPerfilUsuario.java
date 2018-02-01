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
@Table(name = "BWS_PERFIL_USUARIO")
@NamedQueries({
    @NamedQuery(name = "BwsPerfilUsuario.findAll", query = "SELECT b FROM BwsPerfilUsuario b")})
public class BwsPerfilUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private BwsUsuario usuario;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private BwsPerfil codigoPerfil;

    public BwsPerfilUsuario() {
    }

    public BwsPerfilUsuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BwsUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BwsUsuario usuario) {
        this.usuario = usuario;
    }

    public BwsPerfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(BwsPerfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
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
        if (!(object instanceof BwsPerfilUsuario)) {
            return false;
        }
        BwsPerfilUsuario other = (BwsPerfilUsuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsPerfilUsuario[ codigo=" + codigo + " ]";
    }
    
}
