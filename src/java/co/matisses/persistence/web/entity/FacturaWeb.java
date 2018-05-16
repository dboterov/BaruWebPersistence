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
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "FACTURA_WEB")
public class FacturaWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "facturaSAP")
    private Integer facturaSAP;
    @Column(name = "nit")
    private String nit;
    @Column(name = "estado")
    private String estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "sucursal")
    private String sucursal;

    public FacturaWeb() {
    }

    public FacturaWeb(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaWeb(Integer idFactura, Date fecha, Integer facturaSAP, String nit, String estado, String usuario) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.facturaSAP = facturaSAP;
        this.nit = nit;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getFacturaSAP() {
        return facturaSAP;
    }

    public void setFacturaSAP(Integer facturaSAP) {
        this.facturaSAP = facturaSAP;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaWeb)) {
            return false;
        }
        FacturaWeb other = (FacturaWeb) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.FacturaWeb[ idFactura=" + idFactura + " ]";
    }
}
