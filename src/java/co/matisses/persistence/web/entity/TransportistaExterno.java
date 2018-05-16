package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TRANSPORTISTA_EXTERNO")
@NamedQueries({
    @NamedQuery(name = "TransportistaExterno.findAll", query = "SELECT m FROM TransportistaExterno m")})
public class TransportistaExterno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carrier_id")
    private Integer carrierId;
    @Basic(optional = false)
    @Column(name = "carrier_name")
    private String carrierName;
    @Basic(optional = false)
    @Column(name = "wsdl")
    private String wsdl;
    @Basic(optional = false)
    @Column(name = "class_name")
    private String className;
    @Basic(optional = false)
    @Column(name = "quoting_method")
    private String quotingMethod;
    @Basic(optional = false)
    @Column(name = "tracking_method")
    private String trackingMethod;
    @Basic(optional = false)
    @Column(name = "active")
    private Boolean active;
    @Basic(optional = true)
    @Column(name = "cuenta_sap")
    private String cuentaSAP;

    public TransportistaExterno() {
    }

    public TransportistaExterno(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public TransportistaExterno(Integer carrierId, String carrierName, String wsdl, String className, String quotingMethod, String trackingMethod, Boolean active, String cuentaSAP) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.wsdl = wsdl;
        this.className = className;
        this.quotingMethod = quotingMethod;
        this.trackingMethod = trackingMethod;
        this.active = active;
        this.cuentaSAP = cuentaSAP;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getQuotingMethod() {
        return quotingMethod;
    }

    public void setQuotingMethod(String quotingMethod) {
        this.quotingMethod = quotingMethod;
    }

    public String getTrackingMethod() {
        return trackingMethod;
    }

    public void setTrackingMethod(String trackingMethod) {
        this.trackingMethod = trackingMethod;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCuentaSAP() {
        return cuentaSAP;
    }

    public void setCuentaSAP(String cuentaSAP) {
        this.cuentaSAP = cuentaSAP;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.carrierId);
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
        final TransportistaExterno other = (TransportistaExterno) obj;
        if (!Objects.equals(this.carrierId, other.carrierId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransportistaExterno{" + "carrierId=" + carrierId + ", carrierName=" + carrierName + ", wsdl=" + wsdl + ", className=" + className + ", quotingMethod=" + quotingMethod + ", trackingMethod=" + trackingMethod + ", active=" + active + ", cuentaSAP=" + cuentaSAP + '}';
    }

}
