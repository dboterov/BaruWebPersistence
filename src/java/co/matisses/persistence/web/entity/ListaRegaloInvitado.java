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
 * @author jguisao
 */
@Entity
@Table(name = "LISTA_REGALOS_INVITADOS")
public class ListaRegaloInvitado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInvitado")
    private Long idInvitado;
    @Basic(optional = false)
    @Column(name = "idLista")
    private Long idLista;
    @Basic(optional = false)
    @Column(name = "nombreInvitado")
    private String nombreInvitado;
    @Basic(optional = false)
    @Column(name = "apellidosInvitado")
    private String apellidosInvitado;
    @Basic(optional = false)
    @Column(name = "correoInvitado")
    private String correoInvitado;
    @Basic(optional = false)
    @Column(name = "telefonoInvitado")
    private String telefonoInvitado;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @Column(name = "alergico")
    private Boolean alergico;
    @Column(name = "alergia")
    private String alergia;

    public ListaRegaloInvitado() {
    }

    public ListaRegaloInvitado(Long idInvitado, Long idLista, String nombreInvitado, String apellidosInvitado, String correoInvitado, String telefonoInvitado, Boolean asistencia, Boolean alergico, String alergia) {
        this.idInvitado = idInvitado;
        this.idLista = idLista;
        this.nombreInvitado = nombreInvitado;
        this.apellidosInvitado = apellidosInvitado;
        this.correoInvitado = correoInvitado;
        this.telefonoInvitado = telefonoInvitado;
        this.asistencia = asistencia;
        this.alergico = alergico;
        this.alergia = alergia;
    }

    public Long getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(Long idInvitado) {
        this.idInvitado = idInvitado;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNombreInvitado() {
        return nombreInvitado;
    }

    public void setNombreInvitado(String nombreInvitado) {
        this.nombreInvitado = nombreInvitado;
    }

    public String getApellidosInvitado() {
        return apellidosInvitado;
    }

    public void setApellidosInvitado(String apellidosInvitado) {
        this.apellidosInvitado = apellidosInvitado;
    }

    public String getCorreoInvitado() {
        return correoInvitado;
    }

    public void setCorreoInvitado(String correoInvitado) {
        this.correoInvitado = correoInvitado;
    }

    public String getTelefonoInvitado() {
        return telefonoInvitado;
    }

    public void setTelefonoInvitado(String telefonoInvitado) {
        this.telefonoInvitado = telefonoInvitado;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Boolean getAlergico() {
        return alergico;
    }

    public void setAlergico(Boolean alergico) {
        this.alergico = alergico;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvitado != null ? idInvitado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaRegaloInvitado)) {
            return false;
        }
        ListaRegaloInvitado other = (ListaRegaloInvitado) object;
        return !((this.idInvitado == null && other.idInvitado != null) || (this.idInvitado != null && !this.idInvitado.equals(other.idInvitado)));
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ListaRegaloInvitado[ id=" + idInvitado + " ]";
    }
}