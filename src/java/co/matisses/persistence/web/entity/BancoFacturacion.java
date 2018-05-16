package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "BANCO_FACTURACION")
public class BancoFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBancoFacturacion")
    private Integer idBancoFacturacion;
    @Basic(optional = false)
    @Column(name = "nombreBanco")
    private String nombreBanco;
    @Basic(optional = false)
    @Column(name = "franquicia")
    private String franquicia;

    public BancoFacturacion() {
    }

    public BancoFacturacion(Integer idBancoFacturacion) {
        this.idBancoFacturacion = idBancoFacturacion;
    }

    public BancoFacturacion(Integer idBancoFacturacion, String nombreBanco) {
        this.idBancoFacturacion = idBancoFacturacion;
        this.nombreBanco = nombreBanco;
    }

    public Integer getIdBancoFacturacion() {
        return idBancoFacturacion;
    }

    public void setIdBancoFacturacion(Integer idBancoFacturacion) {
        this.idBancoFacturacion = idBancoFacturacion;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBancoFacturacion != null ? idBancoFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BancoFacturacion)) {
            return false;
        }
        BancoFacturacion other = (BancoFacturacion) object;
        if ((this.idBancoFacturacion == null && other.idBancoFacturacion != null) || (this.idBancoFacturacion != null && !this.idBancoFacturacion.equals(other.idBancoFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.BancoFacturacion[ idBancoFacturacion=" + idBancoFacturacion + " ]";
    }
}
