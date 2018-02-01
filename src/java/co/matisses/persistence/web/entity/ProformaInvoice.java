package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PROFORMA_INVOICE")
@NamedQueries({
    @NamedQuery(name = "ProformaInvoice.findAll", query = "SELECT p FROM ProformaInvoice p")})
public class ProformaInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProforma")
    private Integer idProforma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProveedor")
    private String codProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private String anio;
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cbmTotal")
    private Double cbmTotal;
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "valorTotalDescuento")
    private Double valorTotalDescuento;
    @Column(name = "primeraCarga")
    private Boolean primeraCarga;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "tipoProducto")
    private String tipoProducto;
    @Column(name = "terminosPago")
    private String terminosPago;
    @Column(name = "terminosEntrega")
    private String terminosEntrega;
    @JoinColumn(name = "idTipoMoneda", referencedColumnName = "idTipoMoneda")
    @ManyToOne(optional = true)
    private TipoMoneda idTipoMoneda;
    @JoinColumn(name = "idPuertoLlegada", referencedColumnName = "idPuertoMundo")
    @ManyToOne(optional = true)
    private PuertoMundo idPuertoLlegada;
    @JoinColumn(name = "idPuertoSalida", referencedColumnName = "idPuertoMundo")
    @ManyToOne(optional = true)
    private PuertoMundo idPuertoSalida;
    @JoinColumn(name = "idIncoterm", referencedColumnName = "idIncoterm")
    @ManyToOne(optional = true)
    private Incoterm idIncoterm;

    public ProformaInvoice() {
    }

    public ProformaInvoice(Integer idProforma) {
        this.idProforma = idProforma;
    }

    public ProformaInvoice(Integer idProforma, String codProveedor, String anio, Integer consecutivo) {
        this.idProforma = idProforma;
        this.codProveedor = codProveedor;
        this.anio = anio;
        this.consecutivo = consecutivo;
    }

    public ProformaInvoice(Integer idProforma, String codProveedor, String anio, Integer consecutivo, String usuario, Date fecha) {
        this.idProforma = idProforma;
        this.codProveedor = codProveedor;
        this.anio = anio;
        this.consecutivo = consecutivo;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(Integer idProforma) {
        this.idProforma = idProforma;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getCbmTotal() {
        return cbmTotal;
    }

    public void setCbmTotal(Double cbmTotal) {
        this.cbmTotal = cbmTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorTotalDescuento() {
        return valorTotalDescuento;
    }

    public void setValorTotalDescuento(Double valorTotalDescuento) {
        this.valorTotalDescuento = valorTotalDescuento;
    }

    public Boolean getPrimeraCarga() {
        return primeraCarga;
    }

    public void setPrimeraCarga(Boolean primeraCarga) {
        this.primeraCarga = primeraCarga;
    }

    public TipoMoneda getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(TipoMoneda idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getTerminosPago() {
        return terminosPago;
    }

    public void setTerminosPago(String terminosPago) {
        this.terminosPago = terminosPago;
    }

    public String getTerminosEntrega() {
        return terminosEntrega;
    }

    public void setTerminosEntrega(String terminosEntrega) {
        this.terminosEntrega = terminosEntrega;
    }

    public PuertoMundo getIdPuertoLlegada() {
        return idPuertoLlegada;
    }

    public void setIdPuertoLlegada(PuertoMundo idPuertoLlegada) {
        this.idPuertoLlegada = idPuertoLlegada;
    }

    public PuertoMundo getIdPuertoSalida() {
        return idPuertoSalida;
    }

    public void setIdPuertoSalida(PuertoMundo idPuertoSalida) {
        this.idPuertoSalida = idPuertoSalida;
    }

    public Incoterm getIdIncoterm() {
        return idIncoterm;
    }

    public void setIdIncoterm(Incoterm idIncoterm) {
        this.idIncoterm = idIncoterm;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.idProforma);
        hash = 31 * hash + Objects.hashCode(this.codProveedor);
        hash = 31 * hash + Objects.hashCode(this.anio);
        hash = 31 * hash + Objects.hashCode(this.consecutivo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProformaInvoice other = (ProformaInvoice) obj;
        if (!Objects.equals(this.idProforma, other.idProforma)) {
            return false;
        }
        if (!Objects.equals(this.codProveedor, other.codProveedor)) {
            return false;
        }
        if (!Objects.equals(this.anio, other.anio)) {
            return false;
        }
        if (!Objects.equals(this.consecutivo, other.consecutivo)) {
            return false;
        }
        return true;
    }
}
