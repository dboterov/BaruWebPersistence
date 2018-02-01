package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "DIRECCION_CLIENTE_WEB")
@NamedQueries({
    @NamedQuery(name = "DireccionClienteWeb.findAll", query = "SELECT d FROM DireccionClienteWeb d")})
public class DireccionClienteWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private Long idDireccion;
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "cod_ciudad")
    private String codCiudad;
    @Basic(optional = false)
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    @Basic(optional = false)
    @Column(name = "cod_departamento")
    private String codDepartamento;
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "lineNumSAP")
    private Integer lineNumSAP;

    public DireccionClienteWeb() {
    }

    public DireccionClienteWeb(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public DireccionClienteWeb(Long idDireccion, String nit, String nombre, String direccion, String codCiudad, String nombreCiudad, String codDepartamento, String nombreDepartamento, String email, String tipo) {
        this.idDireccion = idDireccion;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codCiudad = codCiudad;
        this.nombreCiudad = nombreCiudad;
        this.codDepartamento = codDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.email = email;
        this.tipo = tipo;
    }

    public DireccionClienteWeb(String nit, String nombre, String direccion, String codCiudad, String nombreCiudad, String codDepartamento, String nombreDepartamento, String telefono, String celular, String email, String tipo) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codCiudad = codCiudad;
        this.nombreCiudad = nombreCiudad;
        this.codDepartamento = codDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.tipo = tipo;
    }

    public static DireccionClienteWeb clone(DireccionClienteWeb original) {
        DireccionClienteWeb nueva = new DireccionClienteWeb();

        nueva.setNit(original.getNit());
        nueva.setNombre(original.getNombre());
        nueva.setDireccion(original.getDireccion());
        nueva.setCodCiudad(original.getCodCiudad());
        nueva.setNombreCiudad(original.getNombreCiudad());
        nueva.setCodDepartamento(original.getCodDepartamento());
        nueva.setNombreDepartamento(original.getNombreDepartamento());
        nueva.setTelefono(original.getTelefono());
        nueva.setCelular(original.getCelular());
        nueva.setEmail(original.getEmail());
        nueva.setTipo(original.getTipo());
        nueva.setLineNumSAP(original.getLineNumSAP());

        return nueva;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getLineNumSAP() {
        return lineNumSAP;
    }

    public void setLineNumSAP(Integer lineNumSAP) {
        this.lineNumSAP = lineNumSAP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionClienteWeb)) {
            return false;
        }
        DireccionClienteWeb other = (DireccionClienteWeb) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DireccionClienteWeb{" + "idDireccion=" + idDireccion + ", nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion + ", codCiudad=" + codCiudad + ", nombreCiudad=" + nombreCiudad + ", codDepartamento=" + codDepartamento + ", nombreDepartamento=" + nombreDepartamento + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", tipo=" + tipo + ", lineNumSAP=" + lineNumSAP + '}';
    }

}
