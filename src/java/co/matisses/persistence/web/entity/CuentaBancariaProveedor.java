package co.matisses.persistence.web.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CUENTA_BANCARIA_PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "CuentaBancariaProveedor.findAll", query = "SELECT c FROM CuentaBancariaProveedor c")})
public class CuentaBancariaProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuentaBancaria")
    private Integer idCuentaBancaria;
    @Basic(optional = false)
    @Column(name = "cuentaBancaria")
    private String cuentaBancaria;
    @Basic(optional = false)
    @Column(name = "codProveedor")
    private String codProveedor;
    @Basic(optional = true)
    @Column(name = "iban")
    private String iban;
    @Basic(optional = true)
    @Column(name = "aba")
    private String aba;
    @JoinColumn(name = "idSucursalBanco", referencedColumnName = "idSucursalBanco")
    @ManyToOne
    private SucursalBancoCompras idSucursalBanco;

    public CuentaBancariaProveedor() {
    }

    public CuentaBancariaProveedor(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public CuentaBancariaProveedor(Integer idCuentaBancaria, String cuentaBancaria, String codProveedor, String iban, String aba, SucursalBancoCompras idSucursalBanco) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.cuentaBancaria = cuentaBancaria;
        this.codProveedor = codProveedor;
        this.iban = iban;
        this.aba = aba;
        this.idSucursalBanco = idSucursalBanco;
    }

    public Integer getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAba() {
        return aba;
    }

    public void setAba(String aba) {
        this.aba = aba;
    }

    public SucursalBancoCompras getIdSucursalBanco() {
        return idSucursalBanco;
    }

    public void setIdSucursalBanco(SucursalBancoCompras idSucursalBanco) {
        this.idSucursalBanco = idSucursalBanco;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaBancaria != null ? idCuentaBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancariaProveedor)) {
            return false;
        }
        CuentaBancariaProveedor other = (CuentaBancariaProveedor) object;
        if ((this.idCuentaBancaria == null && other.idCuentaBancaria != null) || (this.idCuentaBancaria != null && !this.idCuentaBancaria.equals(other.idCuentaBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.CuentaBancariaProveedor[ idCuentaBancaria=" + idCuentaBancaria + " ]";
    }

}
