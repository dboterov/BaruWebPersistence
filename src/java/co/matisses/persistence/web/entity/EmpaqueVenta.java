package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "EMPAQUE_VENTA")
@XmlRootElement
public class EmpaqueVenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpaqueVenta")
    private Integer idEmpaqueVenta;
    @Basic(optional = false)
    @Column(name = "numeroFactura")
    private String numeroFactura;
    @Basic(optional = false)
    @Column(name = "cantBS")
    private Integer cantBS;
    @Basic(optional = false)
    @Column(name = "cantBM")
    private Integer cantBM;
    @Basic(optional = false)
    @Column(name = "cantBL")
    private Integer cantBL;
    @Basic(optional = false)
    @Column(name = "cantCS")
    private Integer cantCS;
    @Basic(optional = false)
    @Column(name = "cantCM")
    private Integer cantCM;
    @Basic(optional = false)
    @Column(name = "cantCL")
    private Integer cantCL;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;

    public EmpaqueVenta() {
    }

    public Integer getIdEmpaqueVenta() {
        return idEmpaqueVenta;
    }

    public void setIdEmpaqueVenta(Integer idEmpaqueVenta) {
        this.idEmpaqueVenta = idEmpaqueVenta;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Integer getCantBS() {
        return cantBS;
    }

    public void setCantBS(Integer cantBS) {
        this.cantBS = cantBS;
    }

    public Integer getCantBM() {
        return cantBM;
    }

    public void setCantBM(Integer cantBM) {
        this.cantBM = cantBM;
    }

    public Integer getCantBL() {
        return cantBL;
    }

    public void setCantBL(Integer cantBL) {
        this.cantBL = cantBL;
    }

    public Integer getCantCS() {
        return cantCS;
    }

    public void setCantCS(Integer cantCS) {
        this.cantCS = cantCS;
    }

    public Integer getCantCM() {
        return cantCM;
    }

    public void setCantCM(Integer cantCM) {
        this.cantCM = cantCM;
    }

    public Integer getCantCL() {
        return cantCL;
    }

    public void setCantCL(Integer cantCL) {
        this.cantCL = cantCL;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idEmpaqueVenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpaqueVenta other = (EmpaqueVenta) obj;
        if (!Objects.equals(this.idEmpaqueVenta, other.idEmpaqueVenta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpaqueVenta{" + "idEmpaqueVenta=" + idEmpaqueVenta + ", numeroFactura=" + numeroFactura + ", cantBS=" + cantBS + ", cantBM=" + cantBM + ", cantBL=" + cantBL + ", cantCS=" + cantCS + ", cantCM=" + cantCM + ", cantCL=" + cantCL + ", fecha=" + fecha + ", usuario=" + usuario + '}';
    }

}
