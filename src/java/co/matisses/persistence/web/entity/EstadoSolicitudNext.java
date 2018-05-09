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
@Table(name = "EstadoSolicitudNext")
public class EstadoSolicitudNext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstSolicitud")
    private Integer idEstSolicitud;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud")
    @ManyToOne
    private SolicitudNext idSolicitud;
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    @ManyToOne
    private EstadosNext idEstado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public EstadoSolicitudNext() {
    }

    public EstadoSolicitudNext(Integer idEstSolicitud) {
        this.idEstSolicitud = idEstSolicitud;
    }

    public EstadoSolicitudNext(Integer idEstSolicitud, String usuario, SolicitudNext idSolicitud, EstadosNext idEstado, Date fecha) {
        this.idEstSolicitud = idEstSolicitud;
        this.usuario = usuario;
        this.idSolicitud = idSolicitud;
        this.idEstado = idEstado;
        this.fecha = fecha;
    }

    public Integer getIdEstSolicitud() {
        return idEstSolicitud;
    }

    public void setIdEstSolicitud(Integer idEstSolicitud) {
        this.idEstSolicitud = idEstSolicitud;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SolicitudNext getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(SolicitudNext idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public EstadosNext getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadosNext idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstSolicitud != null ? idEstSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSolicitudNext)) {
            return false;
        }
        EstadoSolicitudNext other = (EstadoSolicitudNext) object;
        if ((this.idEstSolicitud == null && other.idEstSolicitud != null) || (this.idEstSolicitud != null && !this.idEstSolicitud.equals(other.idEstSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.EstadoSolicitudNext[ idEstSolicitud=" + idEstSolicitud + " ]";
    }
}
