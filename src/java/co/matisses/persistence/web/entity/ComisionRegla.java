package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "COMISION_REGLA")
public class ComisionRegla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegla")
    private Integer idRegla;
    @Basic(optional = false)
    @Column(name = "validoHasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validoHasta;
    @Basic(optional = false)
    @Column(name = "valorRegla")
    private String valorRegla;
    @Basic(optional = false)
    @Column(name = "query")
    private Boolean query;
    @Column(name = "complementos")
    private Boolean complementos;
    @JoinColumn(name = "idTipoRegla", referencedColumnName = "idTipoRegla")
    @ManyToOne(optional = false)
    private ComisionTipoRegla idTipoRegla;

    public ComisionRegla() {
    }

    public ComisionRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public ComisionRegla(Integer idRegla, Date validoHasta, String valorRegla, Boolean query, Boolean complementos, ComisionTipoRegla idTipoRegla) {
        this.idRegla = idRegla;
        this.validoHasta = validoHasta;
        this.valorRegla = valorRegla;
        this.query = query;
        this.complementos = complementos;
        this.idTipoRegla = idTipoRegla;
    }

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public Date getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(Date validoHasta) {
        this.validoHasta = validoHasta;
    }

    public String getValorRegla() {
        return valorRegla;
    }

    public void setValorRegla(String valorRegla) {
        this.valorRegla = valorRegla;
    }

    public Boolean getQuery() {
        return query;
    }

    public void setQuery(Boolean query) {
        this.query = query;
    }

    public Boolean getComplementos() {
        return complementos;
    }

    public void setComplementos(Boolean complementos) {
        this.complementos = complementos;
    }

    public ComisionTipoRegla getIdTipoRegla() {
        return idTipoRegla;
    }

    public void setIdTipoRegla(ComisionTipoRegla idTipoRegla) {
        this.idTipoRegla = idTipoRegla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegla != null ? idRegla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionRegla)) {
            return false;
        }
        ComisionRegla other = (ComisionRegla) object;
        if ((this.idRegla == null && other.idRegla != null) || (this.idRegla != null && !this.idRegla.equals(other.idRegla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionRegla[ idRegla=" + idRegla + " ]";
    }
}
