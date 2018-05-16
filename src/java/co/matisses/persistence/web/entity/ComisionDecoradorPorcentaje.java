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
@Table(name = "COMISION_DECORADOR_PORCENTAJE")
public class ComisionDecoradorPorcentaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPorcentaje")
    private Integer idPorcentaje;
    @Basic(optional = false)
    @Column(name = "medioPago")
    private String medioPago;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private Double porcentaje;
    @Basic(optional = false)
    @Column(name = "mesVencido")
    private Integer mesVencido;

    public ComisionDecoradorPorcentaje() {
    }

    public ComisionDecoradorPorcentaje(Integer idPorcentaje) {
        this.idPorcentaje = idPorcentaje;
    }

    public ComisionDecoradorPorcentaje(Integer idPorcentaje, String medioPago, Double porcentaje, Integer mesVencido) {
        this.idPorcentaje = idPorcentaje;
        this.medioPago = medioPago;
        this.porcentaje = porcentaje;
        this.mesVencido = mesVencido;
    }

    public Integer getIdPorcentaje() {
        return idPorcentaje;
    }

    public void setIdPorcentaje(Integer idPorcentaje) {
        this.idPorcentaje = idPorcentaje;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getMesVencido() {
        return mesVencido;
    }

    public void setMesVencido(Integer mesVencido) {
        this.mesVencido = mesVencido;
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
        if (!(object instanceof ComisionDecoradorPorcentaje)) {
            return false;
        }
        ComisionDecoradorPorcentaje other = (ComisionDecoradorPorcentaje) object;
        if ((this.idPorcentaje == null && other.idPorcentaje != null) || (this.idPorcentaje != null && !this.idPorcentaje.equals(other.idPorcentaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionDecoradorPorcentaje[ idPorcentaje=" + idPorcentaje + " ]";
    }
}
