package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "COMISION_ASESOR")
public class ComisionAsesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComisionAsesor")
    private Integer idComisionAsesor;
    @Basic(optional = false)
    @Column(name = "codigoAsesor")
    private String codigoAsesor;
    @Basic(optional = false)
    @Column(name = "asesor")
    private String asesor;
    @Basic(optional = false)
    @Column(name = "inicioPeriodo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioPeriodo;
    @Basic(optional = false)
    @Column(name = "finPeriodo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finPeriodo;
    @Basic(optional = false)
    @Column(name = "ventasComplementos")
    private String ventasComplementos;
    @Basic(optional = false)
    @Column(name = "ventasMobiliario")
    private String ventasMobiliario;
    @Basic(optional = false)
    @Column(name = "porcentajeComisionComplementos")
    private String porcentajeComisionComplementos;
    @Basic(optional = false)
    @Column(name = "porcentajeComisionMobiliario")
    private String porcentajeComisionMobiliario;
    @Basic(optional = false)
    @Column(name = "totalDevuelto")
    private String totalDevuelto;
    @Basic(optional = false)
    @Column(name = "totalVendido")
    private String totalVendido;
    @Basic(optional = false)
    @Column(name = "totalComision")
    private String totalComision;
    @Basic(optional = false)
    @Column(name = "comisiona")
    private Boolean comisiona;
    @Basic(optional = false)
    @Column(name = "usuarioAplica")
    private String usuarioAplica;
    @Basic(optional = false)
    @Column(name = "fechaAplica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAplica;

    public ComisionAsesor() {
    }

    public ComisionAsesor(Integer idComisionAsesor) {
        this.idComisionAsesor = idComisionAsesor;
    }

    public ComisionAsesor(Integer idComisionAsesor, String codigoAsesor, String asesor, Date inicioPeriodo, Date finPeriodo, String ventasComplementos, String ventasMobiliario,
            String porcentajeComisionComplementos, String porcentajeComisionMobiliario, String totalDevuelto, String totalVendido, String totalComision, Boolean comisiona,
            String usuarioAplica, Date fechaAplica) {
        this.idComisionAsesor = idComisionAsesor;
        this.codigoAsesor = codigoAsesor;
        this.asesor = asesor;
        this.inicioPeriodo = inicioPeriodo;
        this.finPeriodo = finPeriodo;
        this.ventasComplementos = ventasComplementos;
        this.ventasMobiliario = ventasMobiliario;
        this.porcentajeComisionComplementos = porcentajeComisionComplementos;
        this.porcentajeComisionMobiliario = porcentajeComisionMobiliario;
        this.totalDevuelto = totalDevuelto;
        this.totalVendido = totalVendido;
        this.totalComision = totalComision;
        this.comisiona = comisiona;
        this.usuarioAplica = usuarioAplica;
        this.fechaAplica = fechaAplica;
    }

    public Integer getIdComisionAsesor() {
        return idComisionAsesor;
    }

    public void setIdComisionAsesor(Integer idComisionAsesor) {
        this.idComisionAsesor = idComisionAsesor;
    }

    public String getCodigoAsesor() {
        return codigoAsesor;
    }

    public void setCodigoAsesor(String codigoAsesor) {
        this.codigoAsesor = codigoAsesor;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getFinPeriodo() {
        return finPeriodo;
    }

    public void setFinPeriodo(Date finPeriodo) {
        this.finPeriodo = finPeriodo;
    }

    public String getVentasComplementos() {
        return ventasComplementos;
    }

    public void setVentasComplementos(String ventasComplementos) {
        this.ventasComplementos = ventasComplementos;
    }

    public String getVentasMobiliario() {
        return ventasMobiliario;
    }

    public void setVentasMobiliario(String ventasMobiliario) {
        this.ventasMobiliario = ventasMobiliario;
    }

    public String getPorcentajeComisionComplementos() {
        return porcentajeComisionComplementos;
    }

    public void setPorcentajeComisionComplementos(String porcentajeComisionComplementos) {
        this.porcentajeComisionComplementos = porcentajeComisionComplementos;
    }

    public String getPorcentajeComisionMobiliario() {
        return porcentajeComisionMobiliario;
    }

    public void setPorcentajeComisionMobiliario(String porcentajeComisionMobiliario) {
        this.porcentajeComisionMobiliario = porcentajeComisionMobiliario;
    }

    public String getTotalDevuelto() {
        return totalDevuelto;
    }

    public void setTotalDevuelto(String totalDevuelto) {
        this.totalDevuelto = totalDevuelto;
    }

    public String getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(String totalVendido) {
        this.totalVendido = totalVendido;
    }

    public String getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(String totalComision) {
        this.totalComision = totalComision;
    }

    public Boolean getComisiona() {
        return comisiona;
    }

    public void setComisiona(Boolean comisiona) {
        this.comisiona = comisiona;
    }

    public String getUsuarioAplica() {
        return usuarioAplica;
    }

    public void setUsuarioAplica(String usuarioAplica) {
        this.usuarioAplica = usuarioAplica;
    }

    public Date getFechaAplica() {
        return fechaAplica;
    }

    public void setFechaAplica(Date fechaAplica) {
        this.fechaAplica = fechaAplica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComisionAsesor != null ? idComisionAsesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionAsesor)) {
            return false;
        }
        ComisionAsesor other = (ComisionAsesor) object;
        if ((this.idComisionAsesor == null && other.idComisionAsesor != null) || (this.idComisionAsesor != null && !this.idComisionAsesor.equals(other.idComisionAsesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionAsesor[ idComisionAsesor=" + idComisionAsesor + " ]";
    }
}
