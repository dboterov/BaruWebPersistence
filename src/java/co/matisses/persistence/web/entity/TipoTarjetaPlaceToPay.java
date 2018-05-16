package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TIPO_TARJETA_PLACETOPAY")
public class TipoTarjetaPlaceToPay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTarjetaPlaceToPay")
    private String idTarjetaPlaceToPay;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "idTarjetaSAP")
    private Integer idTarjetaSAP;

    public TipoTarjetaPlaceToPay() {
    }

    public String getIdTarjetaPlaceToPay() {
        return idTarjetaPlaceToPay;
    }

    public void setIdTarjetaPlaceToPay(String idTarjetaPlaceToPay) {
        this.idTarjetaPlaceToPay = idTarjetaPlaceToPay;
    }

    public Integer getIdTarjetaSAP() {
        return idTarjetaSAP;
    }

    public void setIdTarjetaSAP(Integer idTarjetaSAP) {
        this.idTarjetaSAP = idTarjetaSAP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idTarjetaPlaceToPay);
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
        final TipoTarjetaPlaceToPay other = (TipoTarjetaPlaceToPay) obj;
        if (!Objects.equals(this.idTarjetaPlaceToPay, other.idTarjetaPlaceToPay)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoTarjetaPlaceToPay{" + "idTarjetaPlaceToPay=" + idTarjetaPlaceToPay + ", nombre=" + nombre + ", idTarjetaSAP=" + idTarjetaSAP + '}';
    }

}
