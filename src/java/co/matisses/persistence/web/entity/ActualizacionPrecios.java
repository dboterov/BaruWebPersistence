package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "ACTUALIZACION_PRECIOS")
@NamedQueries({
    @NamedQuery(name = "ActualizacionPrecios.findAll", query = "SELECT a FROM ActualizacionPrecios a")})
public class ActualizacionPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @Basic(optional = false)
    @Column(name = "saldo")
    private Integer saldo;

    public ActualizacionPrecios() {
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferenciaCorta() {
        if (referencia == null) {
            return "";
        }
        return referencia.substring(0, 3).concat(".").concat(referencia.substring(15));
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.referencia);
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
        final ActualizacionPrecios other = (ActualizacionPrecios) obj;
        return Objects.equals(this.referencia, other.referencia);
    }

    @Override
    public String toString() {
        return "ActualizacionPrecios{" + "referencia=" + referencia + ", precio=" + precio + ", actualizado=" + actualizado + ", saldo=" + saldo + '}';
    }

}
