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
@Table(name = "DEMOSTRACION")
public class Demostracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDemostracion")
    private Integer idDemostracion;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "codigoAsesor")
    private String codigoAsesor;
    @Basic(optional = false)
    @Column(name = "almacen")
    private String almacen;
    @Column(name = "cedulaCliente")
    private String cedulaCliente;
    @Column(name = "estado")
    private String estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "slotDemo")
    private String slotDemo;
    @Column(name = "emailAsesor")
    private String emailAsesor;
    @Column(name = "nroTraslado")
    private Integer nroTraslado;
    @Column(name = "facturaAsociada")
    private Integer facturaAsociada;
    @Column(name = "cancelar")
    private Boolean cancelar;
    @Column(name = "modificar")
    private Boolean modificar;
    @Column(name = "facturar")
    private Boolean facturar;
    @Column(name = "borrar")
    private String borrar;

    public Demostracion() {
    }

    public Demostracion(Integer idDemostracion) {
        this.idDemostracion = idDemostracion;
    }

    public Demostracion(Integer idDemostracion, String alias, Date fechaCreacion, Date fechaInicio, Date fechaFin, String codigoAsesor, String almacen, String cedulaCliente, String estado,
            String nit, String slotDemo, String emailAsesor, Integer nroTraslado, Integer facturaAsociada, Boolean cancelar, Boolean modificar, Boolean facturar, String borrar) {
        this.idDemostracion = idDemostracion;
        this.alias = alias;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.codigoAsesor = codigoAsesor;
        this.almacen = almacen;
        this.cedulaCliente = cedulaCliente;
        this.estado = estado;
        this.usuario = nit;
        this.slotDemo = slotDemo;
        this.emailAsesor = emailAsesor;
        this.nroTraslado = nroTraslado;
        this.facturaAsociada = facturaAsociada;
        this.cancelar = cancelar;
        this.modificar = modificar;
        this.facturar = facturar;
        this.borrar = borrar;
    }

    public Integer getIdDemostracion() {
        return idDemostracion;
    }

    public void setIdDemostracion(Integer idDemostracion) {
        this.idDemostracion = idDemostracion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigoAsesor() {
        return codigoAsesor;
    }

    public void setCodigoAsesor(String codigoAsesor) {
        this.codigoAsesor = codigoAsesor;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSlotDemo() {
        return slotDemo;
    }

    public void setSlotDemo(String slotDemo) {
        this.slotDemo = slotDemo;
    }

    public String getEmailAsesor() {
        return emailAsesor;
    }

    public void setEmailAsesor(String emailAsesor) {
        this.emailAsesor = emailAsesor;
    }

    public Integer getNroTraslado() {
        return nroTraslado;
    }

    public void setNroTraslado(Integer nroTraslado) {
        this.nroTraslado = nroTraslado;
    }

    public Integer getFacturaAsociada() {
        return facturaAsociada;
    }

    public void setFacturaAsociada(Integer facturaAsociada) {
        this.facturaAsociada = facturaAsociada;
    }

    public Boolean getCancelar() {
        return cancelar;
    }

    public void setCancelar(Boolean cancelar) {
        this.cancelar = cancelar;
    }

    public Boolean getModificar() {
        return modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    public Boolean getFacturar() {
        return facturar;
    }

    public void setFacturar(Boolean facturar) {
        this.facturar = facturar;
    }

    public String getBorrar() {
        return borrar;
    }

    public void setBorrar(String borrar) {
        this.borrar = borrar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemostracion != null ? idDemostracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demostracion)) {
            return false;
        }
        Demostracion other = (Demostracion) object;
        if ((this.idDemostracion == null && other.idDemostracion != null) || (this.idDemostracion != null && !this.idDemostracion.equals(other.idDemostracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Demostracion[ idDemostracion=" + idDemostracion + " ]";
    }
}
