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
@Table(name = "[360_SOLICITUD]")
public class SolicitudTraslado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = true)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = true)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = true)
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Basic(optional = true)
    @Column(name = "usuarioFinaliza")
    private String usuarioFinaliza;
    @Basic(optional = true)
    @Column(name = "documentoSAP")
    private Integer documentoSAP;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = true)
    @Column(name = "usuarioResponsable")
    private String usuarioResponsable;

    public SolicitudTraslado() {
    }

    public SolicitudTraslado(Integer idReposicion) {
        this.idSolicitud = idReposicion;
    }

    public SolicitudTraslado(Integer idReposicion, String sucursal, Date fecha, String comentario, String autor, String usuario,
            Date fechaFinal, String usuarioFinaliza, Integer documentoSAP, String estado, String usuarioResponsable) {
        this.idSolicitud = idReposicion;
        this.sucursal = sucursal;
        this.fecha = fecha;
        this.comentario = comentario;
        this.autor = autor;
        this.usuario = usuario;
        this.fechaFinal = fechaFinal;
        this.usuarioFinaliza = usuarioFinaliza;
        this.documentoSAP = documentoSAP;
        this.estado = estado;
        this.usuarioResponsable = usuarioResponsable;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getUsuarioFinaliza() {
        return usuarioFinaliza;
    }

    public void setUsuarioFinaliza(String usuarioFinaliza) {
        this.usuarioFinaliza = usuarioFinaliza;
    }

    public Integer getDocumentoSAP() {
        return documentoSAP;
    }

    public void setDocumentoSAP(Integer documentoSAP) {
        this.documentoSAP = documentoSAP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(String usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudTraslado)) {
            return false;
        }
        SolicitudTraslado other = (SolicitudTraslado) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Reposicion[ idSolicitud=" + idSolicitud + " ]";
    }
}
