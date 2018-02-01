package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TRANSPORTISTA_ORDEN")
@NamedQueries({
    @NamedQuery(name = "TransportistaOrden.findAll", query = "SELECT t FROM TransportistaOrden t")})
public class TransportistaOrden implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "idOrdenPrestashop")
    private Integer idOrdenPrestashop;
    @Basic(optional = false)
    @Column(name = "idTransportista")
    private Integer idTransportista;
    @Basic(optional = false)
    @Column(name = "valor")
    private Integer valor;

    public TransportistaOrden() {
    }

    public Integer getIdOrdenPrestashop() {
        return idOrdenPrestashop;
    }

    public void setIdOrdenPrestashop(Integer idOrdenPrestashop) {
        this.idOrdenPrestashop = idOrdenPrestashop;
    }

    public Integer getIdTransportista() {
        return idTransportista;
    }

    public void setIdTransportista(Integer idTransportista) {
        this.idTransportista = idTransportista;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idOrdenPrestashop);
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
        final TransportistaOrden other = (TransportistaOrden) obj;
        if (!Objects.equals(this.idOrdenPrestashop, other.idOrdenPrestashop)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransportistaOrden{" + "idOrdenPrestashop=" + idOrdenPrestashop + ", idTransportista=" + idTransportista + ", valor=" + valor + '}';
    }
}
