package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "VALOR_ACTIVO_FILTRO")
public class ValorActivoFiltro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idValorActivoFiltro")
    private Long idValorActivoFiltro;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Column(name = "infoAdicional")
    private String infoAdicional;
    @Column(name = "tipoPadre")
    private String tipoPadre;
    @Column(name = "codigoPadre")
    private String codigoPadre;

    public ValorActivoFiltro() {
    }

    public ValorActivoFiltro(Long idValorActivoFiltro) {
        this.idValorActivoFiltro = idValorActivoFiltro;
    }

    public Long getIdValorActivoFiltro() {
        return idValorActivoFiltro;
    }

    public void setIdValorActivoFiltro(Long idValorActivoFiltro) {
        this.idValorActivoFiltro = idValorActivoFiltro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getCodigoPadre() {
        return codigoPadre;
    }

    public void setCodigoPadre(String codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getTipoPadre() {
        return tipoPadre;
    }

    public void setTipoPadre(String tipoPadre) {
        this.tipoPadre = tipoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idValorActivoFiltro);
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
        final ValorActivoFiltro other = (ValorActivoFiltro) obj;
        return Objects.equals(this.idValorActivoFiltro, other.idValorActivoFiltro);
    }

    @Override
    public String toString() {
        return "ValorActivoFiltro{" + "idValorActivoFiltro=" + idValorActivoFiltro + ", tipo=" + tipo + ", valor=" + valor + ", infoAdicional=" + infoAdicional + ", tipoPadre=" + tipoPadre + ", codigoPadre=" + codigoPadre + '}';
    }

}
