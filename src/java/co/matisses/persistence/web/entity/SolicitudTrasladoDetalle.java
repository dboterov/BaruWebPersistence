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
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "[360_SOLICITUD_DETALLE]")
public class SolicitudTrasladoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudDetalle")
    private Integer idSolicitudDetalle;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = true)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud")
    @ManyToOne(optional = false)
    private SolicitudTraslado idSolicitud;

    public SolicitudTrasladoDetalle() {
    }

    public SolicitudTrasladoDetalle(Integer idDetalleReposicion) {
        this.idSolicitudDetalle = idDetalleReposicion;
    }

    public SolicitudTrasladoDetalle(Integer idDetalleReposicion, String referencia, Integer cantidad, String comentario, String usuario, SolicitudTraslado idReposicion) {
        this.idSolicitudDetalle = idDetalleReposicion;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.usuario = usuario;
        this.idSolicitud = idReposicion;
    }

    public Integer getIdSolicitudDetalle() {
        return idSolicitudDetalle;
    }

    public void setIdSolicitudDetalle(Integer idSolicitudDetalle) {
        this.idSolicitudDetalle = idSolicitudDetalle;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SolicitudTraslado getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(SolicitudTraslado idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudDetalle != null ? idSolicitudDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudTrasladoDetalle)) {
            return false;
        }
        SolicitudTrasladoDetalle other = (SolicitudTrasladoDetalle) object;
        if ((this.idSolicitudDetalle == null && other.idSolicitudDetalle != null) || (this.idSolicitudDetalle != null && !this.idSolicitudDetalle.equals(other.idSolicitudDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleReposicion[ idDetalleReposicion=" + idSolicitudDetalle + " ]";
    }
}
