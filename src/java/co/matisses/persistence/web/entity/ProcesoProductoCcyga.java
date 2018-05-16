package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PROCESO_PRODUCTO_CCYGA")
@NamedQueries({
    @NamedQuery(name = "ProcesoProductoCcyga.findAll", query = "SELECT p FROM ProcesoProductoCcyga p")})
public class ProcesoProductoCcyga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProcesoProducto")
    private Integer idProcesoProducto;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = true)
    private ProductoCcyga idProducto;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false)
    private ProcesoCcyga idProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesoProducto", fetch = FetchType.EAGER)
    private List<LaborCcyga> laborCcygaList;

    public ProcesoProductoCcyga() {
    }

    public ProcesoProductoCcyga(Integer idProcesoProducto) {
        this.idProcesoProducto = idProcesoProducto;
    }

    public Integer getIdProcesoProducto() {
        return idProcesoProducto;
    }

    public void setIdProcesoProducto(Integer idProcesoProducto) {
        this.idProcesoProducto = idProcesoProducto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ProductoCcyga getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductoCcyga idProducto) {
        this.idProducto = idProducto;
    }

    public ProcesoCcyga getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(ProcesoCcyga idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesoProducto != null ? idProcesoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoProductoCcyga)) {
            return false;
        }
        ProcesoProductoCcyga other = (ProcesoProductoCcyga) object;
        if ((this.idProcesoProducto == null && other.idProcesoProducto != null) || (this.idProcesoProducto != null && !this.idProcesoProducto.equals(other.idProcesoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ProcesoProductoCcyga[ idProcesoProducto=" + idProcesoProducto + " ]";
    }

    public List<LaborCcyga> getLaborCcygaList() {
        return laborCcygaList;
    }

    public void setLaborCcygaList(List<LaborCcyga> laborCcygaList) {
        this.laborCcygaList = laborCcygaList;
    }

}
