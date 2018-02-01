package co.matisses.persistence.web.entity;

import java.io.Serializable;
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

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "GARANTIAS_WEB")
@NamedQueries({
    @NamedQuery(name = "GarantiasWeb.findAll", query = "SELECT g FROM GarantiasWeb g")})
public class GarantiasWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGarantia")
    private Integer idGarantia;
    @Basic(optional = false)
    @Column(name = "nitCliente")
    private String nitCliente;
    @Basic(optional = false)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "factura")
    private Integer factura;
    @Column(name = "idLlamadaSAP")
    private Integer idLlamadaSAP;
    @Column(name = "empleadoAsignado")
    private Integer empleadoAsignado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "idGarantia")
    private List<ImagenGarantia> imagenes;

    public GarantiasWeb() {
    }

    public GarantiasWeb(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Integer getIdLlamadaSAP() {
        return idLlamadaSAP;
    }

    public void setIdLlamadaSAP(Integer idLlamadaSAP) {
        this.idLlamadaSAP = idLlamadaSAP;
    }

    public Integer getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public void setEmpleadoAsignado(Integer empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }

    public List<ImagenGarantia> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenGarantia> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGarantia != null ? idGarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GarantiasWeb)) {
            return false;
        }
        GarantiasWeb other = (GarantiasWeb) object;
        if ((this.idGarantia == null && other.idGarantia != null) || (this.idGarantia != null && !this.idGarantia.equals(other.idGarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.GarantiasWeb[ idGarantia=" + idGarantia + " ]";
    }
}
