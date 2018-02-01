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
@Table(name = "SUCURSAL_BANCO_COMPRAS")
@NamedQueries({
    @NamedQuery(name = "SucursalBancoCompras.findAll", query = "SELECT s FROM SucursalBancoCompras s")})
public class SucursalBancoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSucursalBanco")
    private Integer idSucursalBanco;
    @Basic(optional = false)
    @Size(min = 1, max = 500)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "swift")
    private String swift;
    @JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
    @ManyToOne
    private BancoCompras idBanco;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne
    private Ciudad idCiudad;

    public SucursalBancoCompras() {
    }

    public SucursalBancoCompras(Integer idSucursalBanco) {
        this.idSucursalBanco = idSucursalBanco;
    }

    public SucursalBancoCompras(Integer idSucursalBanco, String direccion, String swift, BancoCompras idBanco, Ciudad idCiudad) {
        this.idSucursalBanco = idSucursalBanco;
        this.direccion = direccion;
        this.swift = swift;
        this.idBanco = idBanco;
        this.idCiudad = idCiudad;
    }

    public Integer getIdSucursalBanco() {
        return idSucursalBanco;
    }

    public void setIdSucursalBanco(Integer idSucursalBanco) {
        this.idSucursalBanco = idSucursalBanco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public BancoCompras getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(BancoCompras idBanco) {
        this.idBanco = idBanco;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursalBanco != null ? idSucursalBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalBancoCompras)) {
            return false;
        }
        SucursalBancoCompras other = (SucursalBancoCompras) object;
        if ((this.idSucursalBanco == null && other.idSucursalBanco != null) || (this.idSucursalBanco != null && !this.idSucursalBanco.equals(other.idSucursalBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.NewEntity[ idSucursalBanco=" + idSucursalBanco + " ]";
    }
}
