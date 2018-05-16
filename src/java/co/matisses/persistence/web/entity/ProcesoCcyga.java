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
import javax.validation.constraints.NotNull;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PROCESO_CCYGA")
@NamedQueries({
    @NamedQuery(name = "ProcesoCcyga.findAll", query = "SELECT p FROM ProcesoCcyga p")})
public class ProcesoCcyga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProceso")
    private Integer idProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "permiteSimultaneos")
    private Boolean permiteSimultaneos;
    @Column(name = "requiereProducto")
    private Boolean requiereProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso")
    private List<ProcesoProductoCcyga> procesoProductoCcygaList;

    public ProcesoCcyga() {
    }

    public ProcesoCcyga(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public ProcesoCcyga(Integer idProceso, String nombre) {
        this.idProceso = idProceso;
        this.nombre = nombre;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPermiteSimultaneos() {
        return permiteSimultaneos;
    }

    public void setPermiteSimultaneos(Boolean permiteSimultaneos) {
        this.permiteSimultaneos = permiteSimultaneos;
    }

    public Boolean getRequiereProducto() {
        return requiereProducto;
    }

    public void setRequiereProducto(Boolean requiereProducto) {
        this.requiereProducto = requiereProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoCcyga)) {
            return false;
        }
        ProcesoCcyga other = (ProcesoCcyga) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ProcesoCcyga[ idProceso=" + idProceso + " ]";
    }

    public List<ProcesoProductoCcyga> getProcesoProductoCcygaList() {
        return procesoProductoCcygaList;
    }

    public void setProcesoProductoCcygaList(List<ProcesoProductoCcyga> procesoProductoCcygaList) {
        this.procesoProductoCcygaList = procesoProductoCcygaList;
    }

}
