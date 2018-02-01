package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PAGOS_RECIBIDOS")
@NamedQueries({
    @NamedQuery(name = "PagosRecibidos.findAll", query = "SELECT p FROM PagosRecibidos p")})
public class PagosRecibidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago")
    private Integer idPago;
    private static final long serialVersionUID = 1L;
    @Column(name = "msgError")
    private String msgError;
    @Basic(optional = false)
    @Column(name = "voucher")
    private String voucher;
    @Basic(optional = false)
    @Column(name = "nroTarjeta")
    private String nroTarjeta;
    @Column(name = "tarjeta")
    private String tarjeta;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "franquicia")
    private String franquicia;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "tipoTarjeta")
    private String tipoTarjeta;
    @Column(name = "nroBono")
    private String nroBono;
    @Column(name = "nroFacturaSAP")
    private Integer nroFacturaSAP;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "nroReciboSAP")
    private Integer nroReciboSAP;
    @Column(name = "bancoCheque")
    private String bancoCheque;
    @Column(name = "nroCheque")
    private Integer nroCheque;
    @Column(name = "tipoPago")
    private String tipoPago;

    public PagosRecibidos() {
    }

    public PagosRecibidos(Integer idPago) {
        this.idPago = idPago;
    }

    public PagosRecibidos(Integer idPago, int nroFacturaSAP, String voucher, String nroTarjeta) {
        this.idPago = idPago;
        this.nroFacturaSAP = nroFacturaSAP;
        this.voucher = voucher;
        this.nroTarjeta = nroTarjeta;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNroBono() {
        return nroBono;
    }

    public void setNroBono(String nroBono) {
        this.nroBono = nroBono;
    }

    public Integer getNroFacturaSAP() {
        return nroFacturaSAP;
    }

    public void setNroFacturaSAP(Integer nroFacturaSAP) {
        this.nroFacturaSAP = nroFacturaSAP;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNroReciboSAP() {
        return nroReciboSAP;
    }

    public void setNroReciboSAP(Integer nroReciboSAP) {
        this.nroReciboSAP = nroReciboSAP;
    }

    public String getBancoCheque() {
        return bancoCheque;
    }

    public void setBancoCheque(String bancoCheque) {
        this.bancoCheque = bancoCheque;
    }

    public Integer getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(Integer nroCheque) {
        this.nroCheque = nroCheque;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosRecibidos)) {
            return false;
        }
        PagosRecibidos other = (PagosRecibidos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.baruweb.entity.PagosRecibidos[ idPago=" + idPago + " ]";
    }
}
