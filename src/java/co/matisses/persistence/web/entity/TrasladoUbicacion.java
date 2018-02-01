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
@Table(name = "TRASLADO_UBICACION")
@NamedQueries({
    @NamedQuery(name = "TrasladoUbicacion.findAll", query = "SELECT t FROM TrasladoUbicacion t")})
public class TrasladoUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrasladoUbicacion")
    private Integer idTrasladoUbicacion;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "nit")
    private String nit;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "almacen")
    private String almacen;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "referencia")
    private String referencia;
    @NotNull
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "ubicacionOrigen")
    private String ubicacionOrigen;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "ubicacionDestino")
    private String ubicacionDestino;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
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
    @Column(name = "nroFactura")
    private Integer nroFactura;
    @Column(name = "nroTrasladoSAP")
    private Integer nroTrasladoSAP;
    @JoinColumn(name = "idEncabezadoTrasladoUbicacion", referencedColumnName = "idEncabezadoTrasladoUbicacion")
    @ManyToOne
    private EncabezadoTrasladoUbicacion idEncabezadoTrasladoUbicacion;

    public TrasladoUbicacion() {
    }

    public TrasladoUbicacion(Integer idTrasladoUbicacion) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
    }

    public TrasladoUbicacion(Integer idTrasladoUbicacion, String nit, String almacen, String referencia, Integer cantidad, String ubicacionOrigen, String ubicacionDestino, String usuario, Date fecha, String estado, Integer nroFactura, Integer nroTrasladoSAP, EncabezadoTrasladoUbicacion idEncabezadoTrasladoUbicacion) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
        this.nit = nit;
        this.almacen = almacen;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.ubicacionOrigen = ubicacionOrigen;
        this.ubicacionDestino = ubicacionDestino;
        this.usuario = usuario;
        this.fecha = fecha;
        this.estado = estado;
        this.nroFactura = nroFactura;
        this.nroTrasladoSAP = nroTrasladoSAP;
        this.idEncabezadoTrasladoUbicacion = idEncabezadoTrasladoUbicacion;
    }

    public Integer getIdTrasladoUbicacion() {
        return idTrasladoUbicacion;
    }

    public void setIdTrasladoUbicacion(Integer idTrasladoUbicacion) {
        this.idTrasladoUbicacion = idTrasladoUbicacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
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

    public String getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(String ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Integer getNroTrasladoSAP() {
        return nroTrasladoSAP;
    }

    public void setNroTrasladoSAP(Integer nroTrasladoSAP) {
        this.nroTrasladoSAP = nroTrasladoSAP;
    }

    public EncabezadoTrasladoUbicacion getIdEncabezadoTrasladoUbicacion() {
        return idEncabezadoTrasladoUbicacion;
    }

    public void setIdEncabezadoTrasladoUbicacion(EncabezadoTrasladoUbicacion idEncabezadoTrasladoUbicacion) {
        this.idEncabezadoTrasladoUbicacion = idEncabezadoTrasladoUbicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrasladoUbicacion != null ? idTrasladoUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoUbicacion)) {
            return false;
        }
        TrasladoUbicacion other = (TrasladoUbicacion) object;
        if ((this.idTrasladoUbicacion == null && other.idTrasladoUbicacion != null) || (this.idTrasladoUbicacion != null && !this.idTrasladoUbicacion.equals(other.idTrasladoUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TrasladoUbicacion[ idTrasladoUbicacion=" + idTrasladoUbicacion + " ]";
    }
}
