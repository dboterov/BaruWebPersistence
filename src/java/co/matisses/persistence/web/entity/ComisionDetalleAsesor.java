package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "COMISION_DETALLE_ASESOR")
public class ComisionDetalleAsesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComisionDetalleAsesor")
    private Integer idComisionDetalleAsesor;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "documento")
    private Integer documento;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "porcentajeComision")
    private Double porcentajeComision;
    @Basic(optional = false)
    @Column(name = "valorDocumento")
    private BigDecimal valorDocumento;
    @Basic(optional = false)
    @Column(name = "baseComision")
    private BigDecimal baseComision;
    @Basic(optional = false)
    @Column(name = "aplicar")
    private Boolean aplicar;
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "comision")
    private BigDecimal comision;
    @Basic(optional = false)
    @Column(name = "documentoCerrado")
    private Boolean documentoCerrado;
    @Basic(optional = false)
    @Column(name = "incluir")
    private Boolean incluir;
    @JoinColumn(name = "idComisionAsesor", referencedColumnName = "idComisionAsesor")
    @ManyToOne(optional = false)
    private ComisionAsesor idComisionAsesor;

    public ComisionDetalleAsesor() {
    }

    public ComisionDetalleAsesor(Integer idDetalleComisionAsesor) {
        this.idComisionDetalleAsesor = idDetalleComisionAsesor;
    }

    public ComisionDetalleAsesor(Integer idComisionDetalleAsesor, Date fecha, Integer documento, String tipo, Double porcentajeComision, BigDecimal valorDocumento,
            BigDecimal baseComision, Boolean aplicar, BigDecimal valor, BigDecimal comision, Boolean documentoCerrado, Boolean incluir, ComisionAsesor idComisionAsesor) {
        this.idComisionDetalleAsesor = idComisionDetalleAsesor;
        this.fecha = fecha;
        this.documento = documento;
        this.tipo = tipo;
        this.porcentajeComision = porcentajeComision;
        this.valorDocumento = valorDocumento;
        this.baseComision = baseComision;
        this.aplicar = aplicar;
        this.valor = valor;
        this.comision = comision;
        this.documentoCerrado = documentoCerrado;
        this.incluir = incluir;
        this.idComisionAsesor = idComisionAsesor;
    }

    public Integer getIdComisionDetalleAsesor() {
        return idComisionDetalleAsesor;
    }

    public void setIdComisionDetalleAsesor(Integer idComisionDetalleAsesor) {
        this.idComisionDetalleAsesor = idComisionDetalleAsesor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public BigDecimal getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(BigDecimal valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public BigDecimal getBaseComision() {
        return baseComision;
    }

    public void setBaseComision(BigDecimal baseComision) {
        this.baseComision = baseComision;
    }

    public Boolean getAplicar() {
        return aplicar;
    }

    public void setAplicar(Boolean aplicar) {
        this.aplicar = aplicar;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Boolean getDocumentoCerrado() {
        return documentoCerrado;
    }

    public void setDocumentoCerrado(Boolean documentoCerrado) {
        this.documentoCerrado = documentoCerrado;
    }

    public Boolean getIncluir() {
        return incluir;
    }

    public void setIncluir(Boolean incluir) {
        this.incluir = incluir;
    }

    public ComisionAsesor getIdComisionAsesor() {
        return idComisionAsesor;
    }

    public void setIdComisionAsesor(ComisionAsesor idComisionAsesor) {
        this.idComisionAsesor = idComisionAsesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComisionDetalleAsesor != null ? idComisionDetalleAsesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionDetalleAsesor)) {
            return false;
        }
        ComisionDetalleAsesor other = (ComisionDetalleAsesor) object;
        if ((this.idComisionDetalleAsesor == null && other.idComisionDetalleAsesor != null) || (this.idComisionDetalleAsesor != null && !this.idComisionDetalleAsesor.equals(other.idComisionDetalleAsesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionDetalleAsesor[ idComisionDetalleAsesor=" + idComisionDetalleAsesor + " ]";
    }
}
