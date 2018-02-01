package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "CATEGORIA_LISTA_REGALOS")
@NamedQueries({
    @NamedQuery(name = "CategoriaListaRegalos.findAll", query = "SELECT c FROM CategoriaListaRegalos c")})
public class CategoriaListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Long idCategoria;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valorMinimo")
    private Integer valorMinimo;

    public CategoriaListaRegalos() {
    }

    public CategoriaListaRegalos(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaListaRegalos(Long idCategoria, String nombre, Integer valorMinimo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.valorMinimo = valorMinimo;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Integer valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idCategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaListaRegalos other = (CategoriaListaRegalos) obj;
        return Objects.equals(this.idCategoria, other.idCategoria);
    }

    @Override
    public String toString() {
        return "CategoriaListaRegalos{" + "idCategoria=" + idCategoria + ", nombre=" + nombre + ", valorMinimo=" + valorMinimo + '}';
    }

}
