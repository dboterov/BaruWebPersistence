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
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "TRANSACCION_BANCARIA")
@NamedQueries({
    @NamedQuery(name = "TransaccionBancaria.findAll", query = "SELECT t FROM TransaccionBancaria t")})
public class TransaccionBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransaccionBancaria")
    private Integer idTransaccionBancaria;
    @Basic(optional = false)
    @Column(name = "tipoGiro")
    private String tipoGiro;
    @Basic(optional = false)
    @Column(name = "totalInvoice")
    private Double totalInvoice;
    @Column(name = "porcentajeAnticipo")
    private Double porcentajeAnticipo;
    @Basic(optional = true)
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = true)
    @Column(name = "fechaGiro")
    @Temporal(TemporalType.DATE)
    private Date fechaGiro;
    @Column(name = "anticipo")
    private Double anticipo;
    @Column(name = "anticipoCuenta")
    private Double anticipoCuenta;
    @Column(name = "balance")
    private Double balance;
    @Basic(optional = false)
    @Column(name = "totalGiro")
    private Double totalGiro;
    @Column(name = "codProveedor")
    private String codProveedor;
    @Column(name = "firmado")
    private Boolean firmado;
    @Column(name = "cancelado")
    private Boolean cancelado;
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuentaBancaria")
    @ManyToOne
    private CuentaBancariaProveedor idCuenta;
    @JoinColumn(name = "idProformaInvoice", referencedColumnName = "idProforma")
    @ManyToOne
    private ProformaInvoice idProformaInvoice;

    public TransaccionBancaria() {
    }

    public TransaccionBancaria(Integer idTransaccionBancaria) {
        this.idTransaccionBancaria = idTransaccionBancaria;
    }

    public TransaccionBancaria(Integer idTransaccionBancaria, Double totalInvoice, Double porcentajeAnticipo, String descripcion, Date fecha, String usuario, String estado, Date fechaGiro,
            Double anticipo, Double anticipoCuenta, Double balance, Double totalGiro, String codProveedor, CuentaBancariaProveedor idCuenta, String tipoGiro, ProformaInvoice idProformaInvoice) {
        this.idTransaccionBancaria = idTransaccionBancaria;
        this.totalInvoice = totalInvoice;
        this.porcentajeAnticipo = porcentajeAnticipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.estado = estado;
        this.fechaGiro = fechaGiro;
        this.anticipo = anticipo;
        this.anticipoCuenta = anticipoCuenta;
        this.balance = balance;
        this.totalGiro = totalGiro;
        this.codProveedor = codProveedor;
        this.idCuenta = idCuenta;
        this.tipoGiro = tipoGiro;
        this.idProformaInvoice = idProformaInvoice;
    }

    public Integer getIdTransaccionBancaria() {
        return idTransaccionBancaria;
    }

    public void setIdTransaccionBancaria(Integer idTransaccionBancaria) {
        this.idTransaccionBancaria = idTransaccionBancaria;
    }

    public Double getTotalInvoice() {
        return totalInvoice;
    }

    public void setTotalInvoice(Double totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public Double getPorcentajeAnticipo() {
        return porcentajeAnticipo;
    }

    public void setPorcentajeAnticipo(Double porcentajeAnticipo) {
        this.porcentajeAnticipo = porcentajeAnticipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaGiro() {
        return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }

    public Double getAnticipoCuenta() {
        return anticipoCuenta;
    }

    public void setAnticipoCuenta(Double anticipoCuenta) {
        this.anticipoCuenta = anticipoCuenta;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getTotalGiro() {
        return totalGiro;
    }

    public void setTotalGiro(Double totalGiro) {
        this.totalGiro = totalGiro;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Boolean getFirmado() {
        return firmado;
    }

    public void setFirmado(Boolean firmado) {
        this.firmado = firmado;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public CuentaBancariaProveedor getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaBancariaProveedor idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoGiro() {
        return tipoGiro;
    }

    public void setTipoGiro(String tipoGiro) {
        this.tipoGiro = tipoGiro;
    }

    public ProformaInvoice getIdProformaInvoice() {
        return idProformaInvoice;
    }

    public void setIdProformaInvoice(ProformaInvoice idProformaInvoice) {
        this.idProformaInvoice = idProformaInvoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccionBancaria != null ? idTransaccionBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionBancaria)) {
            return false;
        }
        TransaccionBancaria other = (TransaccionBancaria) object;
        if ((this.idTransaccionBancaria == null && other.idTransaccionBancaria != null) || (this.idTransaccionBancaria != null && !this.idTransaccionBancaria.equals(other.idTransaccionBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TransaccionBancaria[ idTransaccionBancaria=" + idTransaccionBancaria + " ]";
    }
}
