package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "OPERACION_COLUMNAS_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "OperacionColumnasProforma.findAll", query = "SELECT o FROM OperacionColumnasProforma o")})
public class OperacionColumnasProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperacionColumnaProforma")
    private Integer idOperacionColumnaProforma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperacionColumnaProforma")
    private List<DetalleOperacionColumna> detalleOperacionColumnaList;
    @OneToMany(mappedBy = "idOperacionColumna")
    private List<ColumnaProforma> columnaProformaList;

    public OperacionColumnasProforma() {
    }

    public OperacionColumnasProforma(Integer idOperacionColumnaProforma) {
        this.idOperacionColumnaProforma = idOperacionColumnaProforma;
    }

    public Integer getIdOperacionColumnaProforma() {
        return idOperacionColumnaProforma;
    }

    public void setIdOperacionColumnaProforma(Integer idOperacionColumnaProforma) {
        this.idOperacionColumnaProforma = idOperacionColumnaProforma;
    }

    public List<DetalleOperacionColumna> getDetalleOperacionColumnaList() {
        return detalleOperacionColumnaList;
    }

    public void setDetalleOperacionColumnaList(List<DetalleOperacionColumna> detalleOperacionColumnaList) {
        this.detalleOperacionColumnaList = detalleOperacionColumnaList;
    }

    public List<ColumnaProforma> getColumnaProformaList() {
        return columnaProformaList;
    }

    public void setColumnaProformaList(List<ColumnaProforma> columnaProformaList) {
        this.columnaProformaList = columnaProformaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacionColumnaProforma != null ? idOperacionColumnaProforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionColumnasProforma)) {
            return false;
        }
        OperacionColumnasProforma other = (OperacionColumnasProforma) object;
        if ((this.idOperacionColumnaProforma == null && other.idOperacionColumnaProforma != null) || (this.idOperacionColumnaProforma != null && !this.idOperacionColumnaProforma.equals(other.idOperacionColumnaProforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.OperacionColumnasProforma[ idOperacionColumnaProforma=" + idOperacionColumnaProforma + " ]";
    }
}
