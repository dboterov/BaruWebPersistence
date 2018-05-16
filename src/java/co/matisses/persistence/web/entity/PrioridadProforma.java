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
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "PRIORIDAD_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "PrioridadProforma.findAll", query = "SELECT p FROM PrioridadProforma p")})
public class PrioridadProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrioridadProforma")
    private Integer idPrioridadProforma;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne
    private ProformaInvoice idProforma;
    @JoinColumn(name = "idPrioridad", referencedColumnName = "idPrioridad")
    @ManyToOne
    private Prioridad idPrioridad;

    public PrioridadProforma() {
    }

    public PrioridadProforma(Integer idPrioridadProforma) {
        this.idPrioridadProforma = idPrioridadProforma;
    }

    public PrioridadProforma(Integer idPrioridadProforma, String usuario, Date fecha, ProformaInvoice idProforma, Prioridad idPrioridad) {
        this.idPrioridadProforma = idPrioridadProforma;
        this.usuario = usuario;
        this.fecha = fecha;
        this.idProforma = idProforma;
        this.idPrioridad = idPrioridad;
    }

    public Integer getIdPrioridadProforma() {
        return idPrioridadProforma;
    }

    public void setIdPrioridadProforma(Integer idPrioridadProforma) {
        this.idPrioridadProforma = idPrioridadProforma;
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

    public ProformaInvoice getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(ProformaInvoice idProforma) {
        this.idProforma = idProforma;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridadProforma != null ? idPrioridadProforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrioridadProforma)) {
            return false;
        }
        PrioridadProforma other = (PrioridadProforma) object;
        if ((this.idPrioridadProforma == null && other.idPrioridadProforma != null) || (this.idPrioridadProforma != null && !this.idPrioridadProforma.equals(other.idPrioridadProforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.PrioridadProforma[ idPrioridadProforma=" + idPrioridadProforma + " ]";
    }
}
