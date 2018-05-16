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
@Table(name = "COMISION_TIPO_REGLA")
public class ComisionTipoRegla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoRegla")
    private Integer idTipoRegla;
    @Basic(optional = false)
    @Column(name = "tipoRegla")
    private String tipoRegla;

    public ComisionTipoRegla() {
    }

    public ComisionTipoRegla(Integer idTipoRegla) {
        this.idTipoRegla = idTipoRegla;
    }

    public ComisionTipoRegla(Integer idTipoRegla, String tipoRegla) {
        this.idTipoRegla = idTipoRegla;
        this.tipoRegla = tipoRegla;
    }

    public Integer getIdTipoRegla() {
        return idTipoRegla;
    }

    public void setIdTipoRegla(Integer idTipoRegla) {
        this.idTipoRegla = idTipoRegla;
    }

    public String getTipoRegla() {
        return tipoRegla;
    }

    public void setTipoRegla(String tipoRegla) {
        this.tipoRegla = tipoRegla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRegla != null ? idTipoRegla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionTipoRegla)) {
            return false;
        }
        ComisionTipoRegla other = (ComisionTipoRegla) object;
        if ((this.idTipoRegla == null && other.idTipoRegla != null) || (this.idTipoRegla != null && !this.idTipoRegla.equals(other.idTipoRegla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComisionTipoRegla[ idTipoRegla=" + idTipoRegla + " ]";
    }
}
