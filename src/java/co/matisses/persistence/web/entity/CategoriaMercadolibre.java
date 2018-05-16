package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "CATEGORIA_MERCADOLIBRE")
@NamedQueries({
    @NamedQuery(name = "CategoriaMercadolibre.findAll", query = "SELECT c FROM CategoriaMercadolibre c")})
public class CategoriaMercadolibre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private String idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "idCategoriaPadre")
    private String idCategoriaPadre;
    @Column(name = "subgrupoSAP")
    private String subgrupoSAP;

    public CategoriaMercadolibre() {
    }

    public CategoriaMercadolibre(String idCategoria, String nombre, String idCategoriaPadre, String subgrupoSAP) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.idCategoriaPadre = idCategoriaPadre;
        this.subgrupoSAP = subgrupoSAP;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCategoriaPadre() {
        return idCategoriaPadre;
    }

    public void setIdCategoriaPadre(String idCategoriaPadre) {
        this.idCategoriaPadre = idCategoriaPadre;
    }

    public String getSubgrupoSAP() {
        return subgrupoSAP;
    }

    public void setSubgrupoSAP(String subgrupoSAP) {
        this.subgrupoSAP = subgrupoSAP;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idCategoria);
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
        final CategoriaMercadolibre other = (CategoriaMercadolibre) obj;
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaMercadolibre{" + "idCategoria=" + idCategoria + ", nombre=" + nombre + ", idCategoriaPadre=" + idCategoriaPadre + ", subgrupoSAP=" + subgrupoSAP + '}';
    }

}
