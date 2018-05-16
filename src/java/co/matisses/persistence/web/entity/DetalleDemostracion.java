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
@Table(name = "DETALLE_DEMOSTRACION")
public class DetalleDemostracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleDemo")
    private Integer idDetalleDemo;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "almacenOrigen")
    private String almacenOrigen;
    @Column(name = "ubicacionOrigen")
    private String ubicacionOrigen;
    @Basic(optional = false)
    @Column(name = "almacenDestino")
    private String almacenDestino;
    @Basic(optional = false)
    @Column(name = "ubicacionDestino")
    private String ubicacionDestino;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idDemostracion", referencedColumnName = "idDemostracion")
    @ManyToOne(optional = false)
    private Demostracion idDemostracion;

    public DetalleDemostracion() {
    }

    public DetalleDemostracion(Integer idDetalleDemo) {
        this.idDetalleDemo = idDetalleDemo;
    }

    public DetalleDemostracion(Integer idDetalleDemo, String referencia, int cantidad, String almacenOrigen, String ubicacionOrigen, String almacenDestino, String ubicacionDestino,
            String estado, Demostracion idDemostracion) {
        this.idDetalleDemo = idDetalleDemo;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.almacenOrigen = almacenOrigen;
        this.ubicacionOrigen = ubicacionOrigen;
        this.almacenDestino = almacenDestino;
        this.ubicacionDestino = ubicacionDestino;
        this.estado = estado;
        this.idDemostracion = idDemostracion;
    }

    public Integer getIdDetalleDemo() {
        return idDetalleDemo;
    }

    public void setIdDetalleDemo(Integer idDetalleDemo) {
        this.idDetalleDemo = idDetalleDemo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(String almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    public String getUbicacionOrigen() {
        return ubicacionOrigen;
    }

    public void setUbicacionOrigen(String ubicacionOrigen) {
        this.ubicacionOrigen = ubicacionOrigen;
    }

    public String getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(String almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Demostracion getIdDemostracion() {
        return idDemostracion;
    }

    public void setIdDemostracion(Demostracion idDemostracion) {
        this.idDemostracion = idDemostracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDemo != null ? idDetalleDemo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDemostracion)) {
            return false;
        }
        DetalleDemostracion other = (DetalleDemostracion) object;
        if ((this.idDetalleDemo == null && other.idDetalleDemo != null) || (this.idDetalleDemo != null && !this.idDetalleDemo.equals(other.idDetalleDemo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleDemostracion[ idDetalleDemo=" + idDetalleDemo + " ]";
    }
}
