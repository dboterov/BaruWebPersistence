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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "ENCABEZADO_TRASLADO_UBICACION")
@NamedQueries({
    @NamedQuery(name = "EncabezadoTrasladoUbicacion.findAll", query = "SELECT e FROM EncabezadoTrasladoUbicacion e")})
public class EncabezadoTrasladoUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEncabezadoTrasladoUbicacion")
    private Integer idEncabezadoTrasladoUbicacion;
    @NotNull
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "nroTrasladoSAP")
    private Integer nroTrasladoSAP;
    @Size(min = 1, max = 10)
    @Column(name = "almacen")
    private String almacen;
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Size(min = 1, max = 20)
    @Column(name = "cedulaEmpleado")
    private String cedulaEmpleado;
    @Size(min = 1, max = 20)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(min = 1, max = 20)
    @Column(name = "movimiento")
    private String movimiento;
    @Size(min = 1, max = 20)
    @Column(name = "ubicacionDestino")
    private String ubicacionDestino;

    public EncabezadoTrasladoUbicacion() {
    }

    public EncabezadoTrasladoUbicacion(Integer idEncabezadoTrasladoUbicacion) {
        this.idEncabezadoTrasladoUbicacion = idEncabezadoTrasladoUbicacion;
    }

    public EncabezadoTrasladoUbicacion(Integer idEncabezadoTrasladoUbicacion, Date fecha, String estado, Integer nroTrasladoSAP, String almacen, String usuario, String cedulaEmpleado, String ubicacion, String movimiento) {
        this.idEncabezadoTrasladoUbicacion = idEncabezadoTrasladoUbicacion;
        this.fecha = fecha;
        this.estado = estado;
        this.nroTrasladoSAP = nroTrasladoSAP;
        this.almacen = almacen;
        this.usuario = usuario;
        this.cedulaEmpleado = cedulaEmpleado;
        this.ubicacion = ubicacion;
        this.movimiento = movimiento;
    }

    public Integer getIdEncabezadoTrasladoUbicacion() {
        return idEncabezadoTrasladoUbicacion;
    }

    public void setIdEncabezadoTrasladoUbicacion(Integer idEncabezadoTrasladoUbicacion) {
        this.idEncabezadoTrasladoUbicacion = idEncabezadoTrasladoUbicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNroTrasladoSAP() {
        return nroTrasladoSAP;
    }

    public void setNroTrasladoSAP(Integer nroTrasladoSAP) {
        this.nroTrasladoSAP = nroTrasladoSAP;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncabezadoTrasladoUbicacion != null ? idEncabezadoTrasladoUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncabezadoTrasladoUbicacion)) {
            return false;
        }
        EncabezadoTrasladoUbicacion other = (EncabezadoTrasladoUbicacion) object;
        if ((this.idEncabezadoTrasladoUbicacion == null && other.idEncabezadoTrasladoUbicacion != null) || (this.idEncabezadoTrasladoUbicacion != null && !this.idEncabezadoTrasladoUbicacion.equals(other.idEncabezadoTrasladoUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.EncabezadoTrasladoUbicacion[ idEncabezadoTrasladoUbicacion=" + idEncabezadoTrasladoUbicacion + " ]";
    }
}
