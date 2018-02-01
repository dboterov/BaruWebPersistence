package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "FRANQUICIA_TARJETA")
@NamedQueries({
    @NamedQuery(name = "FranquiciaTarjeta.findAll", query = "SELECT f FROM FranquiciaTarjeta f")})
public class FranquiciaTarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombreFranquicia")
    private String nombreFranquicia;
    @Basic(optional = false)
    @Column(name = "tipoFranquicia")
    private String tipoFranquicia;

    public FranquiciaTarjeta() {
    }

    public FranquiciaTarjeta(String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public FranquiciaTarjeta(String nombreFranquicia, String tipoFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
        this.tipoFranquicia = tipoFranquicia;
    }

    public String getNombreFranquicia() {
        return nombreFranquicia;
    }

    public void setNombreFranquicia(String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public String getTipoFranquicia() {
        return tipoFranquicia;
    }

    public void setTipoFranquicia(String tipoFranquicia) {
        this.tipoFranquicia = tipoFranquicia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreFranquicia != null ? nombreFranquicia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FranquiciaTarjeta)) {
            return false;
        }
        FranquiciaTarjeta other = (FranquiciaTarjeta) object;
        if ((this.nombreFranquicia == null && other.nombreFranquicia != null) || (this.nombreFranquicia != null && !this.nombreFranquicia.equals(other.nombreFranquicia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.FranquiciaTarjeta[ nombreFranquicia=" + nombreFranquicia + " ]";
    }

}
