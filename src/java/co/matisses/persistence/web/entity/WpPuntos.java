package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jguisao
 */
@Entity
@Table(name = "WP_PUNTOS")
public class WpPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idPunto")
    private Integer idPunto;
    @Basic(optional = false)
    @Column(name = "idRegla")
    private Integer idRegla;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @Basic(optional = false)
    @Column(name = "minimo")
    private Integer minimo;
    @Basic(optional = false)
    @Column(name = "maximo")
    private Integer maximo;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    public WpPuntos() {
    }

    public WpPuntos(Integer idPunto, Integer idRegla, BigDecimal porcentaje, Integer minimo, Integer maximo, boolean estado) {
        this.idPunto = idPunto;
        this.idRegla = idRegla;
        this.porcentaje = porcentaje;
        this.minimo = minimo;
        this.maximo = maximo;
        this.estado = estado;
    }

    public Integer getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPunto != null ? idPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpPuntos)) {
            return false;
        }
        WpPuntos other = (WpPuntos) object;
        if ((this.idPunto == null && other.idPunto != null) || (this.idPunto != null && !this.idPunto.equals(other.idPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.WpPuntos[ id=" + idPunto + " ]";
    }
}