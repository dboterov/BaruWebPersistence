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
@Table(name = "COMPONENTES_CUSTODIA")
public class ComponenteCustodia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComponenteCustodia")
    private Integer idComponenteCustodia;
    @Basic(optional = false)
    @Column(name = "nombreComponente")
    private String nombreComponente;
    @Column(name = "principal")
    private Boolean principal;
    @JoinColumn(name = "idCustodia", referencedColumnName = "idCustodia")
    @ManyToOne(optional = true)
    private Custodia idCustodia;

    public ComponenteCustodia() {
    }

    public ComponenteCustodia(Integer idComponenteCustodia) {
        this.idComponenteCustodia = idComponenteCustodia;
    }

    public ComponenteCustodia(Integer idComponenteCustodia, String nombreComponente, Boolean principal, Custodia idCustodia) {
        this.idComponenteCustodia = idComponenteCustodia;
        this.nombreComponente = nombreComponente;
        this.principal = principal;
        this.idCustodia = idCustodia;
    }

    public Integer getIdComponenteCustodia() {
        return idComponenteCustodia;
    }

    public void setIdComponenteCustodia(Integer idComponenteCustodia) {
        this.idComponenteCustodia = idComponenteCustodia;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Custodia getIdCustodia() {
        return idCustodia;
    }

    public void setIdCustodia(Custodia idCustodia) {
        this.idCustodia = idCustodia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponenteCustodia != null ? idComponenteCustodia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponenteCustodia)) {
            return false;
        }
        ComponenteCustodia other = (ComponenteCustodia) object;
        if ((this.idComponenteCustodia == null && other.idComponenteCustodia != null) || (this.idComponenteCustodia != null && !this.idComponenteCustodia.equals(other.idComponenteCustodia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ComponenteCustodia[ id=" + idComponenteCustodia + " ]";
    }
}
