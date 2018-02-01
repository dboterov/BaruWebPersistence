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
@Table(name = "COMISION_PORCENTAJE")
public class ComisionPorcentaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPorcentaje")
    private Integer idPorcentaje;
    @Basic(optional = false)
    @Column(name = "limiteInferior")
    private Integer limiteInferior;
    @Basic(optional = false)
    @Column(name = "limiteSuperior")
    private Integer limiteSuperior;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private Double porcentaje;
    @Basic(optional = false)
    @Column(name = "mesVencidoAplicable")
    private Integer mesVencidoAplicable;
    @JoinColumn(name = "idCentro", referencedColumnName = "idCentro")
    @ManyToOne(optional = false)
    private ComisionCentro idCentro;
    @JoinColumn(name = "idRegla", referencedColumnName = "idRegla")
    @ManyToOne(optional = false)
    private ComisionRegla idRegla;

    public ComisionPorcentaje() {
    }

    public ComisionPorcentaje(Integer idPorcentaje) {
        this.idPorcentaje = idPorcentaje;
    }

    public ComisionPorcentaje(Integer idPorcentaje, Integer limiteInferior, Integer limiteSuperior, Double porcentaje, Integer mesVencidoAplicable, ComisionCentro idCentro, ComisionRegla idRegla) {
        this.idPorcentaje = idPorcentaje;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.porcentaje = porcentaje;
        this.mesVencidoAplicable = mesVencidoAplicable;
        this.idCentro = idCentro;
        this.idRegla = idRegla;
    }

    public Integer getIdPorcentaje() {
        return idPorcentaje;
    }

    public void setIdPorcentaje(Integer idPorcentaje) {
        this.idPorcentaje = idPorcentaje;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getMesVencidoAplicable() {
        return mesVencidoAplicable;
    }

    public void setMesVencidoAplicable(Integer mesVencidoAplicable) {
        this.mesVencidoAplicable = mesVencidoAplicable;
    }

    public ComisionCentro getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(ComisionCentro idCentro) {
        this.idCentro = idCentro;
    }

    public ComisionRegla getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(ComisionRegla idRegla) {
        this.idRegla = idRegla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPorcentaje != null ? idPorcentaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionPorcentaje)) {
            return false;
        }
        ComisionPorcentaje other = (ComisionPorcentaje) object;
        if ((this.idPorcentaje == null && other.idPorcentaje != null) || (this.idPorcentaje != null && !this.idPorcentaje.equals(other.idPorcentaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionPorcentaje[ idPorcentaje=" + idPorcentaje + " ]";
    }
}
