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
 * @author dbotero
 */
@Entity
@Table(name = "LABOR_CCYGA")
@NamedQueries({
    @NamedQuery(name = "LaborCcyga.findAll", query = "SELECT l FROM LaborCcyga l")})
public class LaborCcyga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLabor")
    private Integer idLabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "horaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codRevisado")
    private String codRevisado;
    @JoinColumn(name = "idProcesoProducto", referencedColumnName = "idProcesoProducto")
    @ManyToOne(optional = false)
    private ProcesoProductoCcyga idProcesoProducto;

    public LaborCcyga() {
    }

    public LaborCcyga(Integer idLabor) {
        this.idLabor = idLabor;
    }

    public LaborCcyga(Integer idLabor, Date fecha, Date horaInicio, String codRevisado) {
        this.idLabor = idLabor;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.codRevisado = codRevisado;
    }

    public Integer getIdLabor() {
        return idLabor;
    }

    public void setIdLabor(Integer idLabor) {
        this.idLabor = idLabor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getCodRevisado() {
        return codRevisado;
    }

    public void setCodRevisado(String codRevisado) {
        this.codRevisado = codRevisado;
    }

    public ProcesoProductoCcyga getIdProcesoProducto() {
        return idProcesoProducto;
    }

    public void setIdProcesoProducto(ProcesoProductoCcyga idProcesoProducto) {
        this.idProcesoProducto = idProcesoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLabor != null ? idLabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaborCcyga)) {
            return false;
        }
        LaborCcyga other = (LaborCcyga) object;
        if ((this.idLabor == null && other.idLabor != null) || (this.idLabor != null && !this.idLabor.equals(other.idLabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.LaborCcyga[ idLabor=" + idLabor + " ]";
    }
    
}
