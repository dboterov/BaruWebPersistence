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

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CONTENEDOR_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "ContenedorProforma.findAll", query = "SELECT c FROM ContenedorProforma c")})
public class ContenedorProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContenedorProforma")
    private Integer idContenedorProforma;
    @Column(name = "fechaEmbarque")
    @Temporal(TemporalType.DATE)
    private Date fechaEmbarque;
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "cbmAcumulado")
    private Double cbmAcumulado;
    @Column(name = "tiempoProduccion")
    private Integer tiempoProduccion;
    @Column(name = "tiempoTransito")
    private Integer tiempoTransito;
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Column(name = "fechaMaxPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaxPago;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne(optional = false)
    private ProformaInvoice idProforma;
    @JoinColumn(name = "idContenedorProveedor", referencedColumnName = "idContenedorProveedor")
    @ManyToOne(optional = false)
    private ContenedorProveedor idContenedorProveedor;

    public ContenedorProforma() {
    }

    public ContenedorProforma(Integer idContenedorProforma) {
        this.idContenedorProforma = idContenedorProforma;
    }

    public ContenedorProforma(Integer idContenedorProforma, Date fechaEmbarque, Double valorTotal, Double cbmAcumulado, ProformaInvoice idProforma, ContenedorProveedor idContenedorProveedor) {
        this.idContenedorProforma = idContenedorProforma;
        this.fechaEmbarque = fechaEmbarque;
        this.valorTotal = valorTotal;
        this.cbmAcumulado = cbmAcumulado;
        this.idProforma = idProforma;
        this.idContenedorProveedor = idContenedorProveedor;
    }

    public Integer getIdContenedorProforma() {
        return idContenedorProforma;
    }

    public void setIdContenedorProforma(Integer idContenedorProforma) {
        this.idContenedorProforma = idContenedorProforma;
    }

    public ProformaInvoice getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(ProformaInvoice idProforma) {
        this.idProforma = idProforma;
    }

    public ContenedorProveedor getIdContenedorProveedor() {
        return idContenedorProveedor;
    }

    public void setIdContenedorProveedor(ContenedorProveedor idContenedorProveedor) {
        this.idContenedorProveedor = idContenedorProveedor;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getCbmAcumulado() {
        return cbmAcumulado;
    }

    public void setCbmAcumulado(Double cbmAcumulado) {
        this.cbmAcumulado = cbmAcumulado;
    }

    public Integer getTiempoProduccion() {
        return tiempoProduccion;
    }

    public void setTiempoProduccion(Integer tiempoProduccion) {
        this.tiempoProduccion = tiempoProduccion;
    }

    public Integer getTiempoTransito() {
        return tiempoTransito;
    }

    public void setTiempoTransito(Integer tiempoTransito) {
        this.tiempoTransito = tiempoTransito;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaMaxPago() {
        return fechaMaxPago;
    }

    public void setFechaMaxPago(Date fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContenedorProforma != null ? idContenedorProforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenedorProforma)) {
            return false;
        }
        ContenedorProforma other = (ContenedorProforma) object;
        if ((this.idContenedorProforma == null && other.idContenedorProforma != null) || (this.idContenedorProforma != null && !this.idContenedorProforma.equals(other.idContenedorProforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ContenedorProforma[ idContenedorProforma=" + idContenedorProforma + " ]";
    }
}
