package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "COTIZACION_WEB")
@NamedQueries({
    @NamedQuery(name = "CotizacionWeb.findAll", query = "SELECT c FROM CotizacionWeb c")})
public class CotizacionWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCotizacion")
    private Long idCotizacion;
    @Basic(optional = false)
    @Column(name = "idVendedor")
    private int idVendedor;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = true)
    @Column(name = "enviarEmail")
    private String enviarEmail;
    @Column(name = "numeroDocSAP")
    private String numeroDocSAP;
    @Column(name = "comentarios_proceso")
    private String comentariosProceso;
    @Column(name = "DocEntry")
    private Integer docEntry;
    @Column(name = "progresoCreacion")
    private Integer progresoCreacion;
    @Column(name = "nroDocPrestashop")
    private Integer nroDocPrestashop;
    @Basic(optional = true)
    @Column(name = "nroFacturaSAP")
    private int nroFacturaSAP;
    @Column(name = "imprimir")
    private Boolean imprimir;
    @Column(name = "demostracion")
    private Boolean demostracion;
    @Column(name = "tiendaRecogida")
    private String tiendaRecogida;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "nitCliente")
    private String nitCliente;
    @JoinColumn(name = "idDemostracion", referencedColumnName = "idDemostracion")
    @OneToOne(optional = true)
    private Demostracion idDemostracion;
    @Transient
    private boolean pagoPendiente = false;
    @Transient
    private boolean permitirFactura = false;

    public CotizacionWeb() {
        this.enviarEmail = "0";
        this.nroFacturaSAP = 0;
    }

    public CotizacionWeb(Long idCotizacion) {
        this.idCotizacion = idCotizacion;
        this.enviarEmail = "0";
        this.nroFacturaSAP = 0;
    }

    public CotizacionWeb(Long idCotizacion, int idVendedor, Date fecha, String sucursal, String estado) {
        this.idCotizacion = idCotizacion;
        this.idVendedor = idVendedor;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.estado = estado;
        this.enviarEmail = "0";
        this.nroFacturaSAP = 0;
    }

    public Long getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Long idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getTiendaRecogida() {
        return tiendaRecogida;
    }

    public void setTiendaRecogida(String tiendaRecogida) {
        this.tiendaRecogida = tiendaRecogida;
    }

    public String getComentariosProceso() {
        return comentariosProceso;
    }

    public void setComentariosProceso(String comentariosProceso) {
        this.comentariosProceso = comentariosProceso;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroDocSAP() {
        return numeroDocSAP;
    }

    public void setNumeroDocSAP(String numeroDocSAP) {
        this.numeroDocSAP = numeroDocSAP;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(String enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

    public boolean isPagoPendiente() {
        return pagoPendiente;
    }

    public void setPagoPendiente(boolean pagoPendiente) {
        this.pagoPendiente = pagoPendiente;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getProgresoCreacion() {
        return progresoCreacion;
    }

    public void setProgresoCreacion(Integer progresoCreacion) {
        this.progresoCreacion = progresoCreacion;
    }

    public Integer getNroDocPrestashop() {
        return nroDocPrestashop;
    }

    public void setNroDocPrestashop(Integer nroDocPrestashop) {
        this.nroDocPrestashop = nroDocPrestashop;
    }

    public int getNroFacturaSAP() {
        return nroFacturaSAP;
    }

    public void setNroFacturaSAP(int nroFacturaSAP) {
        this.nroFacturaSAP = nroFacturaSAP;
    }

    public Boolean getImprimir() {
        return imprimir;
    }

    public void setImprimir(Boolean imprimir) {
        this.imprimir = imprimir;
    }

    public Boolean getDemostracion() {
        return demostracion;
    }

    public void setDemostracion(Boolean demostracion) {
        this.demostracion = demostracion;
    }

    public boolean isPermitirFactura() {
        return permitirFactura;
    }

    public void setPermitirFactura(boolean permitirFactura) {
        this.permitirFactura = permitirFactura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Demostracion getIdDemostracion() {
        return idDemostracion;
    }

    public void setIdDemostracion(Demostracion idDemostracion) {
        this.idDemostracion = idDemostracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionWeb)) {
            return false;
        }
        CotizacionWeb other = (CotizacionWeb) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CotizacionWeb[ idCotizacion[" + idCotizacion + " ] idVendedor[" + idVendedor
                + "] fecha[" + fecha + "] sucursal[" + sucursal + "] estado[" + estado
                + "] enviarEmail[" + enviarEmail + "] numeroDocSAP[" + numeroDocSAP
                + "] docEntry[" + docEntry + "] nitCliente[" + nitCliente + "] ]";
    }
}
