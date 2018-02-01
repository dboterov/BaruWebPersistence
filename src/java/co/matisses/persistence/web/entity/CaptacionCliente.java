package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CAPTACION_CLIENTE")
public class CaptacionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaptacion")
    private Integer idCaptacion;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "restaurante")
    private String restaurante;
    @Basic(optional = false)
    @Column(name = "conoceMatisses")
    private Boolean conoceMatisses;
    @Column(name = "codigo")
    private String codigo;

    public CaptacionCliente() {
    }

    public CaptacionCliente(Integer idCaptacion) {
        this.idCaptacion = idCaptacion;
    }

    public CaptacionCliente(Integer idCaptacion, String nombres, String apellidos, String correo, String celular, String restaurante, Boolean conoceMatisses, String codigo) {
        this.idCaptacion = idCaptacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.restaurante = restaurante;
        this.conoceMatisses = conoceMatisses;
        this.codigo = codigo;
    }

    public Integer getIdCaptacion() {
        return idCaptacion;
    }

    public void setIdCaptacion(Integer idCaptacion) {
        this.idCaptacion = idCaptacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public Boolean getConoceMatisses() {
        return conoceMatisses;
    }

    public void setConoceMatisses(Boolean conoceMatisses) {
        this.conoceMatisses = conoceMatisses;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaptacion != null ? idCaptacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaptacionCliente)) {
            return false;
        }
        CaptacionCliente other = (CaptacionCliente) object;
        if ((this.idCaptacion == null && other.idCaptacion != null) || (this.idCaptacion != null && !this.idCaptacion.equals(other.idCaptacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.CaptacionCliente[ idCaptacion=" + idCaptacion + " ]";
    }
}
