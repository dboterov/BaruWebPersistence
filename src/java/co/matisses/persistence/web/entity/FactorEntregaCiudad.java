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
@Table(name = "FACTOR_ENTREGA_CIUDAD")
@NamedQueries({
    @NamedQuery(name = "FactorEntregaCiudad.findAll", query = "SELECT f FROM FactorEntregaCiudad f")})
public class FactorEntregaCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactor")
    private Integer idFactor;
    @Basic(optional = false)
    @Column(name = "codigoCiudadOrigen")
    private String codigoCiudadOrigen;
    @Basic(optional = false)
    @Column(name = "codigoCiudadDestino")
    private String codigoCiudadDestino;
    @Basic(optional = false)
    @Column(name = "factor")
    private Integer factor;

    public FactorEntregaCiudad() {
    }

    public FactorEntregaCiudad(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public String getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(String codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idFactor);
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
        final FactorEntregaCiudad other = (FactorEntregaCiudad) obj;
        if (!Objects.equals(this.idFactor, other.idFactor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.FactorEntregaCiudad[ idFactor=" + idFactor + " ]";
    }
}
