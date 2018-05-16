package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "TIPO_MONEDA")
@NamedQueries({
    @NamedQuery(name = "TipoMoneda.findAll", query = "SELECT t FROM TipoMoneda t")})
public class TipoMoneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoMoneda")
    private Integer idTipoMoneda;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "simbolo")
    private String simbolo;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "moneda")
    private String moneda;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;

    public TipoMoneda() {
    }

    public TipoMoneda(Integer idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public TipoMoneda(Integer idTipoMoneda, String simbolo, String moneda, Boolean activo) {
        this.idTipoMoneda = idTipoMoneda;
        this.simbolo = simbolo;
        this.moneda = moneda;
        this.activo = activo;
    }

    public Integer getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(Integer idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMoneda != null ? idTipoMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMoneda)) {
            return false;
        }
        TipoMoneda other = (TipoMoneda) object;
        if ((this.idTipoMoneda == null && other.idTipoMoneda != null) || (this.idTipoMoneda != null && !this.idTipoMoneda.equals(other.idTipoMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.TipoMoneda[ idTipoMoneda=" + idTipoMoneda + " ]";
    }

}
