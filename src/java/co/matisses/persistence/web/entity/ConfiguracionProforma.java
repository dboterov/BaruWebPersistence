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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "CONFIGURACION_PROFORMA")
@NamedQueries({
    @NamedQuery(name = "ConfiguracionProforma.findAll", query = "SELECT c FROM ConfiguracionProforma c")})
public class ConfiguracionProforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConfiguracion")
    private Integer idConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigoProveedor")
    private String codigoProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @JoinColumn(name = "idProforma", referencedColumnName = "idProforma")
    @ManyToOne(optional = false)
    private ProformaInvoice idProforma;
    @JoinColumn(name = "idColumna", referencedColumnName = "idColumna")
    @ManyToOne(optional = false)
    private ColumnaProforma idColumna;

    public ConfiguracionProforma() {
    }

    public ConfiguracionProforma(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public ConfiguracionProforma(Integer idConfiguracion, String codigoProveedor, int orden, ColumnaProforma idColumna) {
        this.idConfiguracion = idConfiguracion;
        this.codigoProveedor = codigoProveedor;
        this.orden = orden;
        this.idColumna = idColumna;
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public ColumnaProforma getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(ColumnaProforma idColumna) {
        this.idColumna = idColumna;
    }

    public ProformaInvoice getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(ProformaInvoice idProforma) {
        this.idProforma = idProforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracion != null ? idConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionProforma)) {
            return false;
        }
        ConfiguracionProforma other = (ConfiguracionProforma) object;
        if ((this.idConfiguracion == null && other.idConfiguracion != null) || (this.idConfiguracion != null && !this.idConfiguracion.equals(other.idConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.ConfiguracionProforma[ idConfiguracion=" + idConfiguracion + " ]";
    }
}
 