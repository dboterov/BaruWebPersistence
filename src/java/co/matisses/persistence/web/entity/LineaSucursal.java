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
 * @author jguisao
 */
@Entity
@Table(name = "LINEA_SUCURSAL")
public class LineaSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLinea")
    private Integer idLinea;
    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;
    @Column(name = "linea")
    private String linea;
    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;

    public LineaSucursal() {
    }

    public LineaSucursal(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public LineaSucursal(Integer idLinea, String origen, String destino, String linea, Boolean activo) {
        this.idLinea = idLinea;
        this.origen = origen;
        this.destino = destino;
        this.linea = linea;
        this.activo = activo;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinea != null ? idLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaSucursal)) {
            return false;
        }
        LineaSucursal other = (LineaSucursal) object;
        if ((this.idLinea == null && other.idLinea != null) || (this.idLinea != null && !this.idLinea.equals(other.idLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.LineaSucursal[ idLinea=" + idLinea + " ]";
    }
}