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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "DETALLE_OPERACION_COLUMNA")
@NamedQueries({
    @NamedQuery(name = "DetalleOperacionColumna.findAll", query = "SELECT d FROM DetalleOperacionColumna d")})
public class DetalleOperacionColumna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleOperacion")
    private Integer idDetalleOperacion;
    @Size(max = 10)
    @Column(name = "constante")
    private String constante;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "idOperacionColumnaProforma", referencedColumnName = "idOperacionColumnaProforma")
    @ManyToOne(optional = false)
    private OperacionColumnasProforma idOperacionColumnaProforma;
    @JoinColumn(name = "idOperacion", referencedColumnName = "idOperacion")
    @ManyToOne
    private Operacion idOperacion;
    @JoinColumn(name = "idColumna2", referencedColumnName = "idColumna")
    @ManyToOne
    private ColumnaProforma idColumna2;
    @JoinColumn(name = "idColumna1", referencedColumnName = "idColumna")
    @ManyToOne
    private ColumnaProforma idColumna1;

    public DetalleOperacionColumna() {
    }

    public DetalleOperacionColumna(Integer idDetalleOperacion) {
        this.idDetalleOperacion = idDetalleOperacion;
    }

    public Integer getIdDetalleOperacion() {
        return idDetalleOperacion;
    }

    public void setIdDetalleOperacion(Integer idDetalleOperacion) {
        this.idDetalleOperacion = idDetalleOperacion;
    }

    public String getConstante() {
        return constante;
    }

    public void setConstante(String constante) {
        this.constante = constante;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public OperacionColumnasProforma getIdOperacionColumnaProforma() {
        return idOperacionColumnaProforma;
    }

    public void setIdOperacionColumnaProforma(OperacionColumnasProforma idOperacionColumnaProforma) {
        this.idOperacionColumnaProforma = idOperacionColumnaProforma;
    }

    public Operacion getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Operacion idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ColumnaProforma getIdColumna2() {
        return idColumna2;
    }

    public void setIdColumna2(ColumnaProforma idColumna2) {
        this.idColumna2 = idColumna2;
    }

    public ColumnaProforma getIdColumna1() {
        return idColumna1;
    }

    public void setIdColumna1(ColumnaProforma idColumna1) {
        this.idColumna1 = idColumna1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleOperacion != null ? idDetalleOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOperacionColumna)) {
            return false;
        }
        DetalleOperacionColumna other = (DetalleOperacionColumna) object;
        if ((this.idDetalleOperacion == null && other.idDetalleOperacion != null) || (this.idDetalleOperacion != null && !this.idDetalleOperacion.equals(other.idDetalleOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleOperacionColumna[ idDetalleOperacion=" + idDetalleOperacion + " ]";
    }
}
