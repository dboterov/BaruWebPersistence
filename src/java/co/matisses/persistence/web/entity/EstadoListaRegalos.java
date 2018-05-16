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
@Table(name = "ESTADO_LISTA_REGALOS")
@NamedQueries({
    @NamedQuery(name = "EstadoListaRegalos.findAll", query = "SELECT e FROM EstadoListaRegalos e")})
public class EstadoListaRegalos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstado")
    private Long idEstado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public EstadoListaRegalos() {
    }

    public EstadoListaRegalos(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idEstado);
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
        final EstadoListaRegalos other = (EstadoListaRegalos) obj;
        return Objects.equals(this.idEstado, other.idEstado);
    }

    @Override
    public String toString() {
        return "EstadoListaRegalos{" + "idEstado=" + idEstado + ", nombre=" + nombre + '}';
    }

}
