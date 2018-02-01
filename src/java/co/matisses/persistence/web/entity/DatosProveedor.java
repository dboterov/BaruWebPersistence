package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "DATOS_PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "DatosProveedor.findAll", query = "SELECT d FROM DatosProveedor d")})
public class DatosProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProveedor")
    private String codProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1500)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(max = 150)
    @Column(name = "nombreSocioNegocios")
    private String nombreSocioNegocios;
    @Size(max = 1500)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1500)
    @Column(name = "personaContacto")
    private String personaContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "logo")
    private String logo;
    @JoinColumn(name = "estado", referencedColumnName = "idEstado")
    @ManyToOne(optional = false)
    private Estados estado;

    public DatosProveedor() {
    }

    public DatosProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public DatosProveedor(String codProveedor, String razonSocial, String nombreSocioNegocios, String direccion, String telefono, String correo, String personaContacto,
            String logo, Estados estado) {
        this.codProveedor = codProveedor;
        this.razonSocial = razonSocial;
        this.nombreSocioNegocios = nombreSocioNegocios;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.personaContacto = personaContacto;
        this.logo = logo;
        this.estado = estado;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getNombreSocioNegocios() {
        return nombreSocioNegocios;
    }

    public void setNombreSocioNegocios(String nombreSocioNegocios) {
        this.nombreSocioNegocios = nombreSocioNegocios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProveedor != null ? codProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosProveedor)) {
            return false;
        }
        DatosProveedor other = (DatosProveedor) object;
        if ((this.codProveedor == null && other.codProveedor != null) || (this.codProveedor != null && !this.codProveedor.equals(other.codProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DatosProveedor[ codProveedor=" + codProveedor + " ]";
    }
}
