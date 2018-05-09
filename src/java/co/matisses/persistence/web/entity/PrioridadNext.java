package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "PrioridadNext")
public class PrioridadNext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrioridad")
    private Integer idPrioridad;
    @Basic(optional = false)
    @Column(name = "prioridad")
    private String prioridad;

    public PrioridadNext() {
    }

    public PrioridadNext(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public PrioridadNext(Integer idPrioridad, String prioridad) {
        this.idPrioridad = idPrioridad;
        this.prioridad = prioridad;
    }

    public Integer getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridad != null ? idPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrioridadNext)) {
            return false;
        }
        PrioridadNext other = (PrioridadNext) object;
        if ((this.idPrioridad == null && other.idPrioridad != null) || (this.idPrioridad != null && !this.idPrioridad.equals(other.idPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.soporte.entity.Prioridad[ idPrioridad=" + idPrioridad + " ]";
    }
}
