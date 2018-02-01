package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "PRODUCTO_CCYGA")
@NamedQueries({
    @NamedQuery(name = "ProductoCcyga.findAll", query = "SELECT p FROM ProductoCcyga p")})
public class ProductoCcyga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "estado")
    private String estado;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "refProveedor")
    private String refProveedor;
    @Size(max = 10)
    @Column(name = "documento")
    private String documento;
    @Column(name = "requerimiento")
    private String requerimiento;
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "demo")
    private Boolean demo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.EAGER)
    private List<ProcesoProductoCcyga> procesoProductoCcygaList;

    public ProductoCcyga() {
        procesoProductoCcygaList = new ArrayList<>();
    }

    public ProductoCcyga(Integer idProducto) {
        this.idProducto = idProducto;
        procesoProductoCcygaList = new ArrayList<>();
    }

    public ProductoCcyga(Integer idProducto, String referencia) {
        this.idProducto = idProducto;
        this.referencia = referencia;
        procesoProductoCcygaList = new ArrayList<>();
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRefProveedor() {
        return refProveedor;
    }

    public void setRefProveedor(String refProveedor) {
        this.refProveedor = refProveedor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getDemo() {
        return demo;
    }

    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCcyga)) {
            return false;
        }
        ProductoCcyga other = (ProductoCcyga) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ProductoCcyga[ idProducto=" + idProducto + " ]";
    }

    public List<ProcesoProductoCcyga> getProcesoProductoCcygaList() {
        return procesoProductoCcygaList;
    }

    public void setProcesoProductoCcygaList(List<ProcesoProductoCcyga> procesoProductoCcygaList) {
        this.procesoProductoCcygaList = procesoProductoCcygaList;
    }
}
