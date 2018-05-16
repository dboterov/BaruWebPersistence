package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "DETALLE_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "DetalleProforma.findAll", query = "SELECT d FROM DetalleProforma d")})
public class DetalleProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleProforma")
    private Integer idDetalleProforma;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "lineNum")
    private Integer lineNum;
    @Column(name = "nuevo")
    private Boolean nuevo;
    @JoinColumn(name = "idConfiguracion", referencedColumnName = "idConfiguracion")
    @ManyToOne(optional = false)
    private ConfiguracionProforma idConfiguracion;
    @Transient
    private boolean datosModificados = false;

    public DetalleProforma() {
    }

    public DetalleProforma(Integer idDetalleProforma) {
        this.idDetalleProforma = idDetalleProforma;
    }

    public DetalleProforma(Integer idDetalleProforma, String valor) {
        this.idDetalleProforma = idDetalleProforma;
        this.valor = valor;
    }

    public Integer getIdDetalleProforma() {
        return idDetalleProforma;
    }

    public void setIdDetalleProforma(Integer idDetalleProforma) {
        this.idDetalleProforma = idDetalleProforma;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ConfiguracionProforma getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(ConfiguracionProforma idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isDatosModificados() {
        return datosModificados;
    }

    public void setDatosModificados(boolean datosModificados) {
        this.datosModificados = datosModificados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProforma != null ? idDetalleProforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProforma)) {
            return false;
        }
        DetalleProforma other = (DetalleProforma) object;
        if ((this.idDetalleProforma == null && other.idDetalleProforma != null) || (this.idDetalleProforma != null && !this.idDetalleProforma.equals(other.idDetalleProforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DetalleProforma[ idDetalleProforma=" + idDetalleProforma + " ]";
    }
}
