package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "PROVEEDORES_EXTERIOR")
public class ProveedoresExterior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    @Column(name = "nombreProveedor")
    private String nombreProveedor;
    @Column(name = "complemento")
    private Boolean complemento;
    @Column(name = "consignacion")
    private Boolean consignacion;

    public ProveedoresExterior() {
    }

    public ProveedoresExterior(String proveedor) {
        this.proveedor = proveedor;
    }

    public ProveedoresExterior(String proveedor, String nombreProveedor, Boolean complemento) {
        this.proveedor = proveedor;
        this.nombreProveedor = nombreProveedor;
        this.complemento = complemento;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Boolean getComplemento() {
        return complemento;
    }

    public void setComplemento(Boolean complemento) {
        this.complemento = complemento;
    }

    public Boolean getConsignacion() {
        return consignacion;
    }

    public void setConsignacion(Boolean consignacion) {
        this.consignacion = consignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedor != null ? proveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedoresExterior)) {
            return false;
        }
        ProveedoresExterior other = (ProveedoresExterior) object;
        if ((this.proveedor == null && other.proveedor != null) || (this.proveedor != null && !this.proveedor.equals(other.proveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ProveedoresExterior[ proveedor=" + proveedor + " ]";
    }
}
