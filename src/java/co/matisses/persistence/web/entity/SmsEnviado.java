package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "SMS_ENVIADO")
public class SmsEnviado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSMSEnviado")
    private Integer idSMSEnviado;
    @Basic(optional = false)
    @Column(name = "codigoPais")
    private Integer codigoPais;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "mensajeRespuesta")
    private String mensajeRespuesta;
    @Basic(optional = false)
    @Column(name = "referenciaRespuesta")
    private String referenciaRespuesta;
    @Basic(optional = false)
    @Column(name = "estadoRespuesta")
    private String estadoRespuesta;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;

    public SmsEnviado() {
    }

    public SmsEnviado(Integer idSMSEnviado) {
        this.idSMSEnviado = idSMSEnviado;
    }

    public SmsEnviado(Integer idSMSEnviado, Integer codigoPais, String celular, Date fecha, String mensaje, String mensajeRespuesta,
            String referenciaRespuesta, String estadoRespuesta, String usuario, String ip) {
        this.idSMSEnviado = idSMSEnviado;
        this.codigoPais = codigoPais;
        this.celular = celular;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.mensajeRespuesta = mensajeRespuesta;
        this.referenciaRespuesta = referenciaRespuesta;
        this.estadoRespuesta = estadoRespuesta;
        this.usuario = usuario;
        this.ip = ip;
    }

    public Integer getIdSMSEnviado() {
        return idSMSEnviado;
    }

    public void setIdSMSEnviado(Integer idSMSEnviado) {
        this.idSMSEnviado = idSMSEnviado;
    }

    public Integer getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public String getReferenciaRespuesta() {
        return referenciaRespuesta;
    }

    public void setReferenciaRespuesta(String referenciaRespuesta) {
        this.referenciaRespuesta = referenciaRespuesta;
    }

    public String getEstadoRespuesta() {
        return estadoRespuesta;
    }

    public void setEstadoRespuesta(String estadoRespuesta) {
        this.estadoRespuesta = estadoRespuesta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSMSEnviado != null ? idSMSEnviado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmsEnviado)) {
            return false;
        }
        SmsEnviado other = (SmsEnviado) object;
        if ((this.idSMSEnviado == null && other.idSMSEnviado != null) || (this.idSMSEnviado != null && !this.idSMSEnviado.equals(other.idSMSEnviado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.SmsEnviado[ idSMSEnviado=" + idSMSEnviado + " ]";
    }
}
