package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TIPO_DATO")
@NamedQueries({
    @NamedQuery(name = "TipoDato.findAll", query = "SELECT t FROM TipoDato t")})
public class TipoDato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoDato")
    private Integer idTipoDato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoDato")
    private String tipoDato;
    @OneToMany(mappedBy = "idTipoDato")
    private List<ColumnaProforma> columnaProformaList1;

    public TipoDato() {
    }

    public TipoDato(Integer idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public TipoDato(Integer idTipoDato, String tipoDato) {
        this.idTipoDato = idTipoDato;
        this.tipoDato = tipoDato;
    }

    public Integer getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(Integer idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public List<ColumnaProforma> getColumnaProformaList1() {
        return columnaProformaList1;
    }

    public void setColumnaProformaList1(List<ColumnaProforma> columnaProformaList1) {
        this.columnaProformaList1 = columnaProformaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDato != null ? idTipoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDato)) {
            return false;
        }
        TipoDato other = (TipoDato) object;
        if ((this.idTipoDato == null && other.idTipoDato != null) || (this.idTipoDato != null && !this.idTipoDato.equals(other.idTipoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TipoDato[ idTipoDato=" + idTipoDato + " ]";
    }
}
