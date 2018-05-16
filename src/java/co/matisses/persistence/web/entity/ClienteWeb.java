package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "CLIENTE_WEB")
@NamedQueries({
    @NamedQuery(name = "ClienteWeb.findAll", query = "SELECT c FROM ClienteWeb c")})
@XmlRootElement
public class ClienteWeb implements Serializable, Comparable<ClienteWeb> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Column(name = "digitoVerificacion")
    private String digitoVerificacion;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "cod_ciudad")
    private String codCiudad;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = true)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = true)
    @Column(name = "codAsesor")
    private String codAsesor;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = true)
    @Column(name = "dirEstandarFac")
    private String dirEstadarFac;
    @Basic(optional = true)
    @Column(name = "dirEstandarEnt")
    private String dirEstandarEnt;
    @Column(name = "tipoPersona")
    private String tipoPersona;
    @Column(name = "origenModifica")
    private String origenModifica;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Column(name = "autorretenedor")
    private String autorretenedor;
    @Column(name = "regimen_tributario")
    private String regimenTributario;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nit", fetch = FetchType.EAGER)
    private List<DireccionClienteWeb> direcciones;

    public ClienteWeb() {
        estado = "     ";
        direcciones = new ArrayList<>();
    }

    public ClienteWeb(String nit) {
        this.nit = nit;
        estado = "     ";
        direcciones = new ArrayList<>();
        //retenciones = new ArrayList<>();
    }

    public ClienteWeb(String nit, String digitoVerificacion, String nombres, String apellido1, String apellido2, String razonSocial, String direccion, String ciudad, String codCiudad, String telefono, String celular, String email, String estado, String codAsesor, Date fechaNacimiento, String sexo, String dirEstadarFac, String dirEstandarEnt, String tipoPersona, String origenModifica, String tipoDocumento, String autorretenedor, String regimenTributario, String nacionalidad) {
        this.nit = nit;
        this.digitoVerificacion = digitoVerificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.codAsesor = codAsesor;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.dirEstadarFac = dirEstadarFac;
        this.dirEstandarEnt = dirEstandarEnt;
        this.tipoPersona = tipoPersona;
        this.origenModifica = origenModifica;
        this.tipoDocumento = tipoDocumento;
        this.autorretenedor = autorretenedor;
        this.regimenTributario = regimenTributario;
        this.nacionalidad = nacionalidad;
        direcciones = new ArrayList<>();
    }

    /**
     * @param nit
     * @param nombres
     * @param apellido1
     * @param razonSocial
     * @param direccion
     * @param ciudad
     * @param telefono
     * @param celular
     * @param email
     * @param codCiudad
     * @param estadoB codigo de estado para la informacion basica del cliente.
     * Admite los valores P/E
     * @param estadoD codigo de estado para la informacion de direcciones del
     * cliente. Admite los valores P/E
     * @param estadoC codigo de estado para la informacion de personas de
     * contacto del cliente. Admite los valores P/E
     * @param estadoR codigo de estado para la informacion de retenciones del
     * cliente. Admite los valores P/E
     * @param estadoG codigo de estado para el proceso general del cliente.
     * Admite los valores P/E
     * @param codAsesor
     * @param fechaNacimiento
     * @param sexo
     */
    public ClienteWeb(String nit, String nombres, String apellido1, String razonSocial, String direccion, String ciudad, String telefono, String celular, String email, String codCiudad, String estadoB, String estadoD, String estadoC, String estadoR, String estadoG, String codAsesor, Date fechaNacimiento, String sexo) {
        this.nit = nit;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.codCiudad = codCiudad;
        this.codAsesor = codAsesor;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estado = estadoG + estadoB + estadoD + estadoC + estadoR;
        direcciones = new ArrayList<>();
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @XmlTransient
    public List<DireccionClienteWeb> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionClienteWeb> direcciones) {
        this.direcciones = direcciones;
    }

    public String getDirEstadarFac() {
        return dirEstadarFac;
    }

    public void setDirEstadarFac(String dirEstadarFac) {
        this.dirEstadarFac = dirEstadarFac;
    }

    public String getDirEstandarEnt() {
        return dirEstandarEnt;
    }

    public void setDirEstandarEnt(String dirEstandarEnt) {
        this.dirEstandarEnt = dirEstandarEnt;
    }

    public String getCodAsesor() {
        return codAsesor;
    }

    public void setCodAsesor(String codAsesor) {
        this.codAsesor = codAsesor;
    }

    public String getEstadoB() {
        try {
            return estado.substring(1, 2);
        } catch (Exception e) {
            return "E";
        }
    }

    public void setEstadoB(String estadoB) {
        try {
            estado = estado.substring(0, 1) + estadoB + estado.substring(2);
        } catch (Exception e) {
        }
    }

    public String getEstadoG() {
        try {
            return estado.substring(0, 1);
        } catch (Exception e) {
            return "E";
        }
    }

    public void setEstadoG(String estadoG) {
        try {
            estado = estadoG + estado.substring(1);
        } catch (Exception e) {
        }
    }

    public String getEstadoD() {
        try {
            return estado.substring(2, 3);
        } catch (Exception e) {
            return "E";
        }
    }

    public void setEstadoD(String estadoD) {
        try {
            estado = estado.substring(0, 2) + estadoD + estado.substring(3);
        } catch (Exception e) {
        }
    }

    public String getEstadoC() {
        try {
            return estado.substring(3, 4);
        } catch (Exception e) {
            return "E";
        }
    }

    public void setEstadoC(String estadoC) {
        try {
            estado = estado.substring(0, 3) + estadoC + estado.substring(4);
        } catch (Exception e) {
        }
    }

    public String getEstadoR() {
        try {
            return estado.substring(4, 5);
        } catch (Exception e) {
            return "E";
        }
    }

    public void setEstadoR(String estadoR) {
        try {
            estado = estado.substring(0, 4) + estadoR;
        } catch (Exception e) {
        }
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAutorretenedor() {
        return autorretenedor;
    }

    public void setAutorretenedor(String autorretenedor) {
        this.autorretenedor = autorretenedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOrigenModifica() {
        return origenModifica;
    }

    public void setOrigenModifica(String origenModifica) {
        this.origenModifica = origenModifica;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRegimenTributario() {
        return regimenTributario;
    }

    public void setRegimenTributario(String regimenTributario) {
        this.regimenTributario = regimenTributario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nit);
        hash = 37 * hash + Objects.hashCode(this.tipoDocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteWeb other = (ClienteWeb) obj;
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ClienteWeb o) {
        return this.getNit().compareTo(o.getNit());
    }

    @Override
    public String toString() {
        return "ClienteWeb{" + "nit=" + nit + ", digitoVerificacion=" + digitoVerificacion + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", razonSocial=" + razonSocial + ", direccion=" + direccion + ", ciudad=" + ciudad + ", codCiudad=" + codCiudad + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", estado=" + estado + ", codAsesor=" + codAsesor + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", dirEstadarFac=" + dirEstadarFac + ", dirEstandarEnt=" + dirEstandarEnt + ", tipoPersona=" + tipoPersona + ", origenModifica=" + origenModifica + ", tipoDocumento=" + tipoDocumento + ", autorretenedor=" + autorretenedor + ", regimenTributario=" + regimenTributario + ", nacionalidad=" + nacionalidad + ", direcciones=" + direcciones + '}';
    }

}
