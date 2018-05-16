package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "NOTIFICACION_PROFORMA")
public class NotificacionProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotificacionProforma")
    private Integer idNotificacionProforma;
    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "correoUsuario")
    private String correoUsuario;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Column(name = "respuesta")
    private Boolean respuesta;
    @Column(name = "fechaRespuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuesta;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne
    private ProformaInvoice idProforma;

    public NotificacionProforma() {
    }

    public NotificacionProforma(Integer idNotificacionProforma) {
        this.idNotificacionProforma = idNotificacionProforma;
    }

    public NotificacionProforma(Integer idNotificacionProforma, String correoUsuario, String token, Boolean respuesta, Date fechaRespuesta, String comentario, ProformaInvoice idProforma) {
        this.idNotificacionProforma = idNotificacionProforma;
        this.correoUsuario = correoUsuario;
        this.token = token;
        this.respuesta = respuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.comentario = comentario;
        this.idProforma = idProforma;
    }

    public Integer getIdNotificacionProforma() {
        return idNotificacionProforma;
    }

    public void setIdNotificacionProforma(Integer idNotificacionProforma) {
        this.idNotificacionProforma = idNotificacionProforma;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public ProformaInvoice getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(ProformaInvoice idProforma) {
        this.idProforma = idProforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacionProforma != null ? idNotificacionProforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionProforma)) {
            return false;
        }
        NotificacionProforma other = (NotificacionProforma) object;
        if ((this.idNotificacionProforma == null && other.idNotificacionProforma != null) || (this.idNotificacionProforma != null && !this.idNotificacionProforma.equals(other.idNotificacionProforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.NotificacionProforma[ idNotificacionProforma=" + idNotificacionProforma + " ]";
    }
}
