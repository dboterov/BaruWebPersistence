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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TRANSACCION_PLACETOPAY")
@NamedQueries({
    @NamedQuery(name = "TransaccionPlacetopay.findAll", query = "SELECT t FROM TransaccionPlacetopay t")})
public class TransaccionPlacetopay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago")
    private Integer idPago;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "seed")
    private String seed;
    @Basic(optional = false)
    @Column(name = "nonce")
    private String nonce;
    @Basic(optional = false)
    @Column(name = "tranKey")
    private String tranKey;
    @Basic(optional = false)
    @Column(name = "nroDocumento")
    private String nroDocumento;
    @Basic(optional = false)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "refPago")
    private String refPago;
    @Basic(optional = false)
    @Column(name = "descPago")
    private String descPago;
    @Basic(optional = false)
    @Column(name = "moneda")
    private String moneda;
    @Basic(optional = false)
    @Column(name = "totalPago")
    private Integer totalPago;
    @Basic(optional = false)
    @Column(name = "tipoImpuesto")
    private String tipoImpuesto;
    @Basic(optional = false)
    @Column(name = "totalImpuesto")
    private Integer totalImpuesto;
    @Basic(optional = false)
    @Column(name = "expira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expira;
    @Basic(optional = false)
    @Column(name = "urlRetorno")
    private String urlRetorno;
    @Basic(optional = false)
    @Column(name = "userAgent")
    private String userAgent;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Column(name = "status")
    private String status;
    @Column(name = "reason")
    private String reason;
    @Column(name = "message")
    private String message;
    @Column(name = "responseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseDate;
    @Column(name = "requestId")
    private String requestId;
    @Column(name = "processUrl")
    private String processUrl;
    @Column(name = "docEntryFactura")
    private Long docEntryFactura;
    @Column(name = "docNumFactura")
    private String docNumFactura;
    @Column(name = "codigoLista")
    private String codigoLista;
    @Column(name = "idSesion")
    private String idSesion;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Column(name = "paymentMessage")
    private String paymentMessage;
    @Column(name = "paymentReference")
    private String paymentReference;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "paymentMethodName")
    private String paymentMethodName;
    @Column(name = "paymentIssuerName")
    private String paymentIssuerName;
    @Column(name = "paymentFranchise")
    private String paymentFranchise;
    @Column(name = "paymentReceipt")
    private String paymentReceipt;
    @Column(name = "paymentAuthorization")
    private String paymentAuthorization;
    @Column(name = "paymentLastDigits")
    private String paymentLastDigits;
    @Column(name = "paymentDate")
    private String paymentDate;
    @Column(name = "paymentInternalReference")
    private String paymentInternalReference;
    @Column(name = "tipoCompra")
    private String tipoCompra;
    @Column(name = "mensajeComprador")
    private String mensajeComprador;

    public TransaccionPlacetopay() {
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTranKey() {
        return tranKey;
    }

    public void setTranKey(String tranKey) {
        this.tranKey = tranKey;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRefPago() {
        return refPago;
    }

    public void setRefPago(String refPago) {
        this.refPago = refPago;
    }

    public String getDescPago() {
        return descPago;
    }

    public void setDescPago(String descPago) {
        this.descPago = descPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Integer totalPago) {
        this.totalPago = totalPago;
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Integer getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(Integer totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public Date getExpira() {
        return expira;
    }

    public void setExpira(Date expira) {
        this.expira = expira;
    }

    public String getUrlRetorno() {
        return urlRetorno;
    }

    public void setUrlRetorno(String urlRetorno) {
        this.urlRetorno = urlRetorno;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProcessUrl() {
        return processUrl;
    }

    public void setProcessUrl(String processUrl) {
        this.processUrl = processUrl;
    }

    public Long getDocEntryFactura() {
        return docEntryFactura;
    }

    public void setDocEntryFactura(Long docEntryFactura) {
        this.docEntryFactura = docEntryFactura;
    }

    public String getDocNumFactura() {
        return docNumFactura;
    }

    public void setDocNumFactura(String docNumFactura) {
        this.docNumFactura = docNumFactura;
    }

    public String getCodigoLista() {
        return codigoLista;
    }

    public void setCodigoLista(String codigoLista) {
        this.codigoLista = codigoLista;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public void setPaymentMessage(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getPaymentIssuerName() {
        return paymentIssuerName;
    }

    public void setPaymentIssuerName(String paymentIssuerName) {
        this.paymentIssuerName = paymentIssuerName;
    }

    public String getPaymentFranchise() {
        return paymentFranchise;
    }

    public void setPaymentFranchise(String paymentFranchise) {
        this.paymentFranchise = paymentFranchise;
    }

    public String getPaymentReceipt() {
        return paymentReceipt;
    }

    public void setPaymentReceipt(String paymentReceipt) {
        this.paymentReceipt = paymentReceipt;
    }

    public String getPaymentAuthorization() {
        return paymentAuthorization;
    }

    public void setPaymentAuthorization(String paymentAuthorization) {
        this.paymentAuthorization = paymentAuthorization;
    }

    public String getPaymentLastDigits() {
        return paymentLastDigits;
    }

    public void setPaymentLastDigits(String paymentLastDigits) {
        this.paymentLastDigits = paymentLastDigits;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentInternalReference() {
        return paymentInternalReference;
    }

    public void setPaymentInternalReference(String paymentInternalReference) {
        this.paymentInternalReference = paymentInternalReference;
    }

    public String getMensajeComprador() {
        return mensajeComprador;
    }

    public void setMensajeComprador(String mensajeComprador) {
        this.mensajeComprador = mensajeComprador;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idPago);
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
        final TransaccionPlacetopay other = (TransaccionPlacetopay) obj;
        return Objects.equals(this.idPago, other.idPago);
    }

    @Override
    public String toString() {
        return "TransaccionPlacetopay{" + "idPago=" + idPago + ", login=" + login + ", seed=" + seed + ", nonce=" + nonce + ", tranKey=" + tranKey + ", nroDocumento=" + nroDocumento + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", direccion=" + direccion + ", ciudad=" + ciudad + ", pais=" + pais + ", refPago=" + refPago + ", descPago=" + descPago + ", moneda=" + moneda + ", totalPago=" + totalPago + ", tipoImpuesto=" + tipoImpuesto + ", totalImpuesto=" + totalImpuesto + ", expira=" + expira + ", urlRetorno=" + urlRetorno + ", userAgent=" + userAgent + ", ip=" + ip + ", status=" + status + ", reason=" + reason + ", message=" + message + ", responseDate=" + responseDate + ", requestId=" + requestId + ", processUrl=" + processUrl + ", docEntryFactura=" + docEntryFactura + ", docNumFactura=" + docNumFactura + ", codigoLista=" + codigoLista + ", idSesion=" + idSesion + ", paymentStatus=" + paymentStatus + ", paymentMessage=" + paymentMessage + ", paymentReference=" + paymentReference + ", paymentMethod=" + paymentMethod + ", paymentMethodName=" + paymentMethodName + ", paymentIssuerName=" + paymentIssuerName + ", paymentFranchise=" + paymentFranchise + ", paymentReceipt=" + paymentReceipt + ", paymentAuthorization=" + paymentAuthorization + ", paymentLastDigits=" + paymentLastDigits + ", paymentDate=" + paymentDate + ", paymentInternalReference=" + paymentInternalReference + ", tipoCompra=" + tipoCompra + ", mensajeComprador=" + mensajeComprador + '}';
    }
}
