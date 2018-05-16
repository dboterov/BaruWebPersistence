package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "HABILITAR_UBICACION")
@NamedQueries({
    @NamedQuery(name = "HabilitarUbicacion.findAll", query = "SELECT h FROM HabilitarUbicacion h")})
public class HabilitarUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHabilitarUbicacion")
    private Integer idHabilitarUbicacion;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = true)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = true)
    @Column(name = "mensaje")
    private String mensaje;

    public HabilitarUbicacion() {
    }

    public HabilitarUbicacion(Integer idHabilitarUbicacion, String usuario, Date fecha, String sucursal, String estado, String mensaje) {
        this.idHabilitarUbicacion = idHabilitarUbicacion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public Integer getIdHabilitarUbicacion() {
        return idHabilitarUbicacion;
    }

    public void setIdHabilitarUbicacion(Integer idHabilitarUbicacion) {
        this.idHabilitarUbicacion = idHabilitarUbicacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabilitarUbicacion != null ? idHabilitarUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabilitarUbicacion)) {
            return false;
        }
        HabilitarUbicacion other = (HabilitarUbicacion) object;
        if ((this.idHabilitarUbicacion == null && other.idHabilitarUbicacion != null) || (this.idHabilitarUbicacion != null && !this.idHabilitarUbicacion.equals(other.idHabilitarUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.HabilitarUbicacion[ idHabilitarUbicacion=" + idHabilitarUbicacion + " ]";
    }
}
