package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "BWS_USUARIO")
@NamedQueries({
    @NamedQuery(name = "BwsUsuario.findAll", query = "SELECT b FROM BwsUsuario b")})
public class BwsUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVendedor")
    private int idVendedor;
    @Size(max = 10)
    @Column(name = "nombreMostrar")
    private String nombreMostrar;
    @Size(max = 64)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<BwsPerfilUsuario> bwsPerfilUsuarioList;

    public BwsUsuario() {
    }

    public BwsUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BwsUsuario(String usuario, int idVendedor) {
        this.usuario = usuario;
        this.idVendedor = idVendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreMostrar() {
        return nombreMostrar;
    }

    public void setNombreMostrar(String nombreMostrar) {
        this.nombreMostrar = nombreMostrar;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsUsuario)) {
            return false;
        }
        BwsUsuario other = (BwsUsuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsUsuario[ usuario=" + usuario + " ]";
    }
    
}