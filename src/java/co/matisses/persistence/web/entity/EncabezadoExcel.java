package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "ENCABEZADO_EXCEL")
@NamedQueries({
    @NamedQuery(name = "EncabezadoExcel.findAll", query = "SELECT e FROM EncabezadoExcel e")})
public class EncabezadoExcel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEncabezadoExcel")
    private Integer idEncabezadoExcel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "objecto")
    private String objecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "columnaInicial")
    private Integer columnaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "columnaFinal")
    private Integer columnaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "filaInicial")
    private Integer filaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "filaFinal")
    private Integer filaFinal;
    @Column(name = "valor")
    private String valor;
    @Basic(optional = true)
    @Column(name = "alineadoDerecha")
    private Boolean alineadoDerecha;
    @Basic(optional = true)
    @Column(name = "alineadoIzquierda")
    private Boolean alineadoIzquierda;
    @Basic(optional = true)
    @Column(name = "alineadoCentro")
    private Boolean alineadoCentro;

    public EncabezadoExcel() {
    }

    public EncabezadoExcel(Integer idEncabezadoExcel) {
        this.idEncabezadoExcel = idEncabezadoExcel;
    }

    public EncabezadoExcel(Integer idEncabezadoExcel, String objecto, Integer columnaInicial, Integer columnaFinal, Integer filaInicial, Integer filaFinal,
            String valor, Boolean alineadoDerecha, Boolean alineadoIzquierda, Boolean alineadoCentro) {
        this.idEncabezadoExcel = idEncabezadoExcel;
        this.objecto = objecto;
        this.columnaInicial = columnaInicial;
        this.columnaFinal = columnaFinal;
        this.filaInicial = filaInicial;
        this.filaFinal = filaFinal;
        this.valor = valor;
        this.alineadoDerecha = alineadoDerecha;
        this.alineadoIzquierda = alineadoIzquierda;
        this.alineadoCentro = alineadoCentro;
    }

    public Integer getIdEncabezadoExcel() {
        return idEncabezadoExcel;
    }

    public void setIdEncabezadoExcel(Integer idEncabezadoExcel) {
        this.idEncabezadoExcel = idEncabezadoExcel;
    }

    public String getObjecto() {
        return objecto;
    }

    public void setObjecto(String objecto) {
        this.objecto = objecto;
    }

    public Integer getColumnaInicial() {
        return columnaInicial;
    }

    public void setColumnaInicial(Integer columnaInicial) {
        this.columnaInicial = columnaInicial;
    }

    public Integer getColumnaFinal() {
        return columnaFinal;
    }

    public void setColumnaFinal(Integer columnaFinal) {
        this.columnaFinal = columnaFinal;
    }

    public Integer getFilaInicial() {
        return filaInicial;
    }

    public void setFilaInicial(Integer filaInicial) {
        this.filaInicial = filaInicial;
    }

    public Integer getFilaFinal() {
        return filaFinal;
    }

    public void setFilaFinal(Integer filaFinal) {
        this.filaFinal = filaFinal;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getAlineadoDerecha() {
        return alineadoDerecha;
    }

    public void setAlineadoDerecha(Boolean alineadoDerecha) {
        this.alineadoDerecha = alineadoDerecha;
    }

    public Boolean getAlineadoIzquierda() {
        return alineadoIzquierda;
    }

    public void setAlineadoIzquiera(Boolean alineadoIzquierda) {
        this.alineadoIzquierda = alineadoIzquierda;
    }

    public Boolean getAlineadoCentro() {
        return alineadoCentro;
    }

    public void setAlineadoCentro(Boolean alineadoCentro) {
        this.alineadoCentro = alineadoCentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncabezadoExcel != null ? idEncabezadoExcel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncabezadoExcel)) {
            return false;
        }
        EncabezadoExcel other = (EncabezadoExcel) object;
        if ((this.idEncabezadoExcel == null && other.idEncabezadoExcel != null) || (this.idEncabezadoExcel != null && !this.idEncabezadoExcel.equals(other.idEncabezadoExcel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.EncabezadoExcel[ idEncabezadoExcel=" + idEncabezadoExcel + " ]";
    }

}
