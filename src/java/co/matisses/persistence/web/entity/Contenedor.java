package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author ygil
 */
@Entity
@Table(name = "CONTENEDOR")
@NamedQueries({
    @NamedQuery(name = "Contenedor.findAll", query = "SELECT c FROM Contenedor c")})
public class Contenedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idContenedor")
    private Integer idContenedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "cargaMaxima")
    private String cargaMaxima;
    @Size(max = 500)
    @Column(name = "capacidadCubica")
    private String capacidadCubica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CBMMinimo")
    private Integer CBMMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CBMMaximo")
    private Integer CBMMaximo;
    @Size(max = 500)
    @Column(name = "nombreCorto")
    private String nombreCorto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContenedor")
    private List<ContenedorProveedor> contenedorProveedor;

    public Contenedor() {
    }

    public Contenedor(Integer idContenedor) {
        this.idContenedor = idContenedor;
    }

    public Contenedor(Integer idContenedor, String nombre, String cargaMaxima) {
        this.idContenedor = idContenedor;
        this.nombre = nombre;
        this.cargaMaxima = cargaMaxima;
    }

    public Integer getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(Integer idContenedor) {
        this.idContenedor = idContenedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(String cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public String getCapacidadCubica() {
        return capacidadCubica;
    }

    public void setCapacidadCubica(String capacidadCubica) {
        this.capacidadCubica = capacidadCubica;
    }

    public List<ContenedorProveedor> getContenedorProveedor() {
        return contenedorProveedor;
    }

    public void setContenedorProveedor(List<ContenedorProveedor> contenedorProveedor) {
        this.contenedorProveedor = contenedorProveedor;
    }

    public Integer getCBMMinimo() {
        return CBMMinimo;
    }

    public void setCBMMinimo(Integer CBMMinimo) {
        this.CBMMinimo = CBMMinimo;
    }

    public Integer getCBMMaximo() {
        return CBMMaximo;
    }

    public void setCBMMaximo(Integer CBMMaximo) {
        this.CBMMaximo = CBMMaximo;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContenedor != null ? idContenedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenedor)) {
            return false;
        }
        Contenedor other = (Contenedor) object;
        if ((this.idContenedor == null && other.idContenedor != null) || (this.idContenedor != null && !this.idContenedor.equals(other.idContenedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Contenedor[ idContenedor=" + idContenedor + " ]";
    }
}
