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
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "RESULTADO_CONTEO")
public class ResultadoConteo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResultadoConteo")
    private Long idResultadoConteo;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private long cantidad;
    @JoinColumn(name = "idConteo", referencedColumnName = "idConteo")
    @ManyToOne(optional = false)
    private ConteoTienda idConteo;

    public ResultadoConteo() {
    }

    public ResultadoConteo(Long idResultadoConteo) {
        this.idResultadoConteo = idResultadoConteo;
    }

    public ResultadoConteo(Long idResultadoConteo, String referencia, long cantidad, ConteoTienda idConteo) {
        this.idResultadoConteo = idResultadoConteo;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.idConteo = idConteo;
    }

    public Long getIdResultadoConteo() {
        return idResultadoConteo;
    }

    public void setIdResultadoConteo(Long idResultadoConteo) {
        this.idResultadoConteo = idResultadoConteo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public ConteoTienda getIdConteo() {
        return idConteo;
    }

    public void setIdConteo(ConteoTienda idConteo) {
        this.idConteo = idConteo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoConteo != null ? idResultadoConteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idResultadoConteo fields are not set
        if (!(object instanceof ResultadoConteo)) {
            return false;
        }
        ResultadoConteo other = (ResultadoConteo) object;
        if ((this.idResultadoConteo == null && other.idResultadoConteo != null) || (this.idResultadoConteo != null && !this.idResultadoConteo.equals(other.idResultadoConteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ResultadoConteo[ idResultadoConteo=" + idResultadoConteo + " ]";
    }
}
