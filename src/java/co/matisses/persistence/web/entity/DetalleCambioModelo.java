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
@Table(name = "DETALLE_CAMBIO_MODELO")
public class DetalleCambioModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCambioModelo")
    private Integer idDetalleCambioModelo;
    @Basic(optional = false)
    @Column(name = "referenciaAnterior")
    private String referenciaAnterior;
    @Basic(optional = false)
    @Column(name = "referenciaNueva")
    private String referenciaNueva;
    @Basic(optional = false)
    @Column(name = "fotosHercules")
    private Boolean fotosHercules;
    @Basic(optional = false)
    @Column(name = "fotosSAP")
    private Boolean fotosSAP;
    @Basic(optional = false)
    @Column(name = "materiales")
    private Boolean materiales;
    @Basic(optional = false)
    @Column(name = "colores")
    private Boolean colores;
    @JoinColumn(name = "idCambioModelo", referencedColumnName = "idCAmbioModelo")
    @ManyToOne
    private CambioModelo idCambioModelo;

    public DetalleCambioModelo() {
    }

    public DetalleCambioModelo(Integer idDetalleCambioModelo, String referenciaAnterior, String referenciaNueva, Boolean fotosHercules, Boolean fotosSAP, Boolean materiales, Boolean colores, CambioModelo idCambioModelo) {
        this.idDetalleCambioModelo = idDetalleCambioModelo;
        this.referenciaAnterior = referenciaAnterior;
        this.referenciaNueva = referenciaNueva;
        this.fotosHercules = fotosHercules;
        this.fotosSAP = fotosSAP;
        this.materiales = materiales;
        this.colores = colores;
        this.idCambioModelo = idCambioModelo;
    }

    public Integer getIdDetalleCambioModelo() {
        return idDetalleCambioModelo;
    }

    public void setIdDetalleCambioModelo(Integer idDetalleCambioModelo) {
        this.idDetalleCambioModelo = idDetalleCambioModelo;
    }

    public String getReferenciaAnterior() {
        return referenciaAnterior;
    }

    public void setReferenciaAnterior(String referenciaAnterior) {
        this.referenciaAnterior = referenciaAnterior;
    }

    public String getReferenciaNueva() {
        return referenciaNueva;
    }

    public void setReferenciaNueva(String referenciaNueva) {
        this.referenciaNueva = referenciaNueva;
    }

    public Boolean getFotosHercules() {
        return fotosHercules;
    }

    public void setFotosHercules(Boolean fotosHercules) {
        this.fotosHercules = fotosHercules;
    }

    public Boolean getFotosSAP() {
        return fotosSAP;
    }

    public void setFotosSAP(Boolean fotosSAP) {
        this.fotosSAP = fotosSAP;
    }

    public Boolean getMateriales() {
        return materiales;
    }

    public void setMateriales(Boolean materiales) {
        this.materiales = materiales;
    }

    public Boolean getColores() {
        return colores;
    }

    public void setColores(Boolean colores) {
        this.colores = colores;
    }

    public CambioModelo getIdCambioModelo() {
        return idCambioModelo;
    }

    public void setIdCambioModelo(CambioModelo idCambioModelo) {
        this.idCambioModelo = idCambioModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCambioModelo != null ? idDetalleCambioModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCambioModelo)) {
            return false;
        }
        DetalleCambioModelo other = (DetalleCambioModelo) object;
        if ((this.idDetalleCambioModelo == null && other.idDetalleCambioModelo != null) || (this.idDetalleCambioModelo != null && !this.idDetalleCambioModelo.equals(other.idDetalleCambioModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleCambioModelo[ idDetalleCambioModelo=" + idDetalleCambioModelo + " ]";
    }
}
