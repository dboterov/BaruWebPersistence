package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "CUSTODIAS")
public class Custodia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCustodia")
    private Integer idCustodia;
    @Basic(optional = false)
    @Column(name = "nombreCustodia")
    private String nombreCustodia;
    @Column(name = "requiereContrasena")
    private Boolean requiereContrasena;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "tipoCantidad")
    private Boolean tipoCantidad;
    @Column(name = "requiereActa")
    private Boolean requiereActa;
    @Column(name = "tipoCelular")
    private Character tipoCelular;

    public Custodia() {
    }

    public Custodia(Integer idCustodia) {
        this.idCustodia = idCustodia;
    }

    public Custodia(Integer idCustodia, String nombreCustodia, Boolean requiereContrasena, String imagen, Boolean tipoCantidad, Boolean requiereActa, Character tipoCelular) {
        this.idCustodia = idCustodia;
        this.nombreCustodia = nombreCustodia;
        this.requiereContrasena = requiereContrasena;
        this.imagen = imagen;
        this.tipoCantidad = tipoCantidad;
        this.requiereActa = requiereActa;
        this.tipoCelular = tipoCelular;
    }

    public Integer getIdCustodia() {
        return idCustodia;
    }

    public void setIdCustodia(Integer idCustodia) {
        this.idCustodia = idCustodia;
    }

    public String getNombreCustodia() {
        return nombreCustodia;
    }

    public void setNombreCustodia(String nombreCustodia) {
        this.nombreCustodia = nombreCustodia;
    }

    public Boolean getRequiereContrasena() {
        return requiereContrasena;
    }

    public void setRequiereContrasena(Boolean requiereContrasena) {
        this.requiereContrasena = requiereContrasena;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(Boolean tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    public Boolean getRequiereActa() {
        return requiereActa;
    }

    public void setRequiereActa(Boolean requiereActa) {
        this.requiereActa = requiereActa;
    }

    public Character getTipoCelular() {
        return tipoCelular;
    }

    public void setTipoCelular(Character tipoCelular) {
        this.tipoCelular = tipoCelular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustodia != null ? idCustodia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Custodia)) {
            return false;
        }
        Custodia other = (Custodia) object;
        if ((this.idCustodia == null && other.idCustodia != null) || (this.idCustodia != null && !this.idCustodia.equals(other.idCustodia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.Custodia[ idCustodia=" + idCustodia + " ]";
    }
}
