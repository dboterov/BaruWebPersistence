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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "DETALLE_HABILITAR_UBICACION")
@NamedQueries({
    @NamedQuery(name = "DetalleHabilitarUbicacion.findAll", query = "SELECT d FROM DetalleHabilitarUbicacion d")})
public class DetalleHabilitarUbicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleHabilitarUbicacion")
    private Integer idDetalleHabilitarUbicacion;
    @Column(name = "almacen")
    private String almacen;
    @Column(name = "piso")
    private String piso;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "activar")
    private Boolean activar;
    @JoinColumn(name = "idHabilitarUbicacion", referencedColumnName = "idHabilitarUbicacion")
    @ManyToOne(optional = false)
    private HabilitarUbicacion idHabilitarUbicacion;

    public DetalleHabilitarUbicacion() {
    }

    public DetalleHabilitarUbicacion(Integer idDetalleHabilitarUbicacion, String almacen, String piso, String ubicacion, Boolean activar, HabilitarUbicacion idHabilitarUbicacion) {
        this.idDetalleHabilitarUbicacion = idDetalleHabilitarUbicacion;
        this.almacen = almacen;
        this.piso = piso;
        this.ubicacion = ubicacion;
        this.activar = activar;
        this.idHabilitarUbicacion = idHabilitarUbicacion;
    }

    public Integer getIdDetalleHabilitarUbicacion() {
        return idDetalleHabilitarUbicacion;
    }

    public void setIdDetalleHabilitarUbicacion(Integer idDetalleHabilitarUbicacion) {
        this.idDetalleHabilitarUbicacion = idDetalleHabilitarUbicacion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Boolean getActivar() {
        return activar;
    }

    public void setActivar(Boolean activar) {
        this.activar = activar;
    }

    public HabilitarUbicacion getIdHabilitarUbicacion() {
        return idHabilitarUbicacion;
    }

    public void setIdHabilitarUbicacion(HabilitarUbicacion idHabilitarUbicacion) {
        this.idHabilitarUbicacion = idHabilitarUbicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleHabilitarUbicacion != null ? idDetalleHabilitarUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHabilitarUbicacion)) {
            return false;
        }
        DetalleHabilitarUbicacion other = (DetalleHabilitarUbicacion) object;
        if ((this.idDetalleHabilitarUbicacion == null && other.idDetalleHabilitarUbicacion != null)
                || (this.idDetalleHabilitarUbicacion != null && !this.idDetalleHabilitarUbicacion.equals(other.idDetalleHabilitarUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleHabilitarUbicacion[ idDetalleHabilitarUbicacion=" + idDetalleHabilitarUbicacion + " ]";
    }
}
