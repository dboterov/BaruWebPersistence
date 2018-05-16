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
@Table(name = "PUERTO_MUNDO")
public class PuertoMundo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPuertoMundo")
    private Integer idPuertoMundo;
    @Basic(optional = false)
    @Column(name = "nombrePuerto")
    private String nombrePuerto;
    @JoinColumn(name = "idPais", referencedColumnName = "idPais")
    @ManyToOne(optional = false)
    private Paises idPais;

    public PuertoMundo() {
    }

    public PuertoMundo(Integer idPuertoMundo) {
        this.idPuertoMundo = idPuertoMundo;
    }

    public PuertoMundo(Integer idPuertoMundo, String nombrePuerto, Paises idPais) {
        this.idPuertoMundo = idPuertoMundo;
        this.nombrePuerto = nombrePuerto;
        this.idPais = idPais;
    }

    public Integer getIdPuertoMundo() {
        return idPuertoMundo;
    }

    public void setIdPuertoMundo(Integer idPuertoMundo) {
        this.idPuertoMundo = idPuertoMundo;
    }

    public String getNombrePuerto() {
        return nombrePuerto;
    }

    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuertoMundo != null ? idPuertoMundo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuertoMundo)) {
            return false;
        }
        PuertoMundo other = (PuertoMundo) object;
        if ((this.idPuertoMundo == null && other.idPuertoMundo != null) || (this.idPuertoMundo != null && !this.idPuertoMundo.equals(other.idPuertoMundo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.PuertoMundo[ idPuertoMundo=" + idPuertoMundo + " ]";
    }
}
