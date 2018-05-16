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
@Table(name = "COMPONENTES_CUSTODIAS_EMPLEADO")
public class ComponenteCustodiaEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleComponente")
    private Integer idDetalleComponente;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "cantidadBaja")
    private Integer cantidadBaja;
    @JoinColumn(name = "idComponente", referencedColumnName = "idComponenteCustodia")
    @ManyToOne(optional = false)
    private ComponenteCustodia idComponente;
    @JoinColumn(name = "idDetalleCustodia", referencedColumnName = "idDetalleCustodia")
    @ManyToOne(optional = true)
    private DetalleCustodia idDetalleCustodia;

    public ComponenteCustodiaEmpleado() {
    }

    public ComponenteCustodiaEmpleado(Integer idDetalleComponente) {
        this.idDetalleComponente = idDetalleComponente;
    }

    public ComponenteCustodiaEmpleado(Integer idDetalleComponente, Integer cantidad, String comentario, Integer cantidadBaja, ComponenteCustodia idComponente, DetalleCustodia idDetalleCustodia) {
        this.idDetalleComponente = idDetalleComponente;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.cantidadBaja = cantidadBaja;
        this.idComponente = idComponente;
        this.idDetalleCustodia = idDetalleCustodia;
    }

    public Integer getIdDetalleComponente() {
        return idDetalleComponente;
    }

    public void setIdDetalleComponente(Integer idDetalleComponente) {
        this.idDetalleComponente = idDetalleComponente;
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

    public Integer getCantidadBaja() {
        return cantidadBaja;
    }

    public void setCantidadBaja(Integer cantidadBaja) {
        this.cantidadBaja = cantidadBaja;
    }

    public ComponenteCustodia getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(ComponenteCustodia idComponente) {
        this.idComponente = idComponente;
    }

    public DetalleCustodia getIdDetalleCustodia() {
        return idDetalleCustodia;
    }

    public void setIdDetalleCustodia(DetalleCustodia idDetalleCustodia) {
        this.idDetalleCustodia = idDetalleCustodia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleComponente != null ? idDetalleComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponenteCustodiaEmpleado)) {
            return false;
        }
        ComponenteCustodiaEmpleado other = (ComponenteCustodiaEmpleado) object;
        if ((this.idDetalleComponente == null && other.idDetalleComponente != null) || (this.idDetalleComponente != null && !this.idDetalleComponente.equals(other.idDetalleComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComponenteCustodiaEmpleado[ id=" + idDetalleComponente + " ]";
    }
}
