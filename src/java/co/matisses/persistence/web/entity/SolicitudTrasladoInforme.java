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
@Table(name = "[360_SOLICITUD_INFORME]")
public class SolicitudTrasladoInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudInforme")
    private Integer idSolicitudInforme;
    @Basic(optional = false)
    @Column(name = "almacen")
    private String almacen;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = true)
    @Column(name = "ubicaciones")
    private String ubicaciones;
    @JoinColumn(name = "idSolicitudDetalle", referencedColumnName = "idSolicitudDetalle")
    @ManyToOne(optional = false)
    private SolicitudTrasladoDetalle idSolicitudDetalle;

    public SolicitudTrasladoInforme() {
    }

    public SolicitudTrasladoInforme(Integer idSolicitudInforme) {
        this.idSolicitudInforme = idSolicitudInforme;
    }

    public SolicitudTrasladoInforme(Integer idSolicitudInforme, String almacen, Integer cantidad, String ubicaciones, SolicitudTrasladoDetalle idSolicitudDetalle) {
        this.idSolicitudInforme = idSolicitudInforme;
        this.almacen = almacen;
        this.cantidad = cantidad;
        this.ubicaciones = ubicaciones;
        this.idSolicitudDetalle = idSolicitudDetalle;
    }

    public Integer getIdSolicitudInforme() {
        return idSolicitudInforme;
    }

    public void setIdSolicitudInforme(Integer idSolicitudInforme) {
        this.idSolicitudInforme = idSolicitudInforme;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(String ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public SolicitudTrasladoDetalle getIdSolicitudDetalle() {
        return idSolicitudDetalle;
    }

    public void setIdSolicitudDetalle(SolicitudTrasladoDetalle idSolicitudDetalle) {
        this.idSolicitudDetalle = idSolicitudDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudInforme != null ? idSolicitudInforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudTrasladoInforme)) {
            return false;
        }
        SolicitudTrasladoInforme other = (SolicitudTrasladoInforme) object;
        if ((this.idSolicitudInforme == null && other.idSolicitudInforme != null) || (this.idSolicitudInforme != null && !this.idSolicitudInforme.equals(other.idSolicitudInforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.SolicitudTrasladoInforme[ idSolicitudInforme=" + idSolicitudInforme + " ]";
    }
}
