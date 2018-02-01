package co.matisses.persistence.web.entity;

import java.io.Serializable;
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

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "PAGO_VENTA_POS")
@NamedQueries({
    @NamedQuery(name = "PagoVentaPOS.findAll", query = "SELECT p FROM PagoVentaPOS p")})
public class PagoVentaPOS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago")
    private Long idPago;
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Long idVenta;
    @Basic(optional = false)
    @Column(name = "valor")
    private Integer valor;
    @Basic(optional = false)
    @Column(name = "voucher")
    private String voucher;
    @Basic(optional = false)
    @Column(name = "franquicia")
    private String franquicia;
    @Basic(optional = false)
    @Column(name = "digitos")
    private String digitos;

    public PagoVentaPOS() {
    }

    public PagoVentaPOS(Long idPago, Long idVenta, Integer valor, String voucher, String franquicia, String digitos) {
        this.idPago = idPago;
        this.idVenta = idVenta;
        this.valor = valor;
        this.voucher = voucher;
        this.franquicia = franquicia;
        this.digitos = digitos;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getDigitos() {
        return digitos;
    }

    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }

    @Override
    public String toString() {
        return "PagoVentaPOS{" + "idPago=" + idPago + ", idVenta=" + idVenta + ", valor=" + valor + ", voucher=" + voucher + ", franquicia=" + franquicia + ", digitos=" + digitos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idPago);
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
        final PagoVentaPOS other = (PagoVentaPOS) obj;
        if (!Objects.equals(this.idPago, other.idPago)) {
            return false;
        }
        return true;
    }

}
