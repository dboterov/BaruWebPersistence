package co.matisses.persistence.web.entity;

import java.io.Serializable;
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
@Table(name = "IMAGEN_GARANTIA")
@NamedQueries({
    @NamedQuery(name = "ImagenGarantia.findAll", query = "SELECT i FROM ImagenGarantia i")})
public class ImagenGarantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImagenGarantia")
    private Integer idImagenGarantia;
    @Basic(optional = false)
    @Column(name = "nombreArchivo")
    private String nombreArchivo;
    @Basic(optional = false)
    @Column(name = "idGarantia")
    private Integer idGarantia;

    public ImagenGarantia() {
    }

    public ImagenGarantia(Integer idImagenGarantia) {
        this.idImagenGarantia = idImagenGarantia;
    }

    public ImagenGarantia(Integer idImagenGarantia, String nombreArchivo) {
        this.idImagenGarantia = idImagenGarantia;
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getIdImagenGarantia() {
        return idImagenGarantia;
    }

    public void setIdImagenGarantia(Integer idImagenGarantia) {
        this.idImagenGarantia = idImagenGarantia;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenGarantia != null ? idImagenGarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenGarantia)) {
            return false;
        }
        ImagenGarantia other = (ImagenGarantia) object;
        if ((this.idImagenGarantia == null && other.idImagenGarantia != null) || (this.idImagenGarantia != null && !this.idImagenGarantia.equals(other.idImagenGarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.ImagenGarantia[ idImagenGarantia=" + idImagenGarantia + " ]";
    }

}
