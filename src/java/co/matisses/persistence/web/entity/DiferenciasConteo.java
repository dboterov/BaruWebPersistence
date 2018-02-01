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
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "DIFERENCIAS_CONTEO")
public class DiferenciasConteo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiferenciaConteo")
    private Long idDiferenciaConteo;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "esperado")
    private long esperado;
    @Basic(optional = false)
    @Column(name = "encontrado")
    private long encontrado;
    @Basic(optional = true)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = true)
    @Column(name = "resuelta")
    private Boolean resuelta;
    @Transient
    private String tipo;
    @JoinColumn(name = "idConteo", referencedColumnName = "idConteo")
    @ManyToOne(optional = false)
    private ConteoTienda idConteo;

    public DiferenciasConteo() {
    }

    public DiferenciasConteo(Long idDiferenciaConteo) {
        this.idDiferenciaConteo = idDiferenciaConteo;
    }

    public DiferenciasConteo(Long idDiferenciaConteo, String referencia, long esperado, long encontrado, String comentarios, Boolean resuelta, ConteoTienda idConteo) {
        this.idDiferenciaConteo = idDiferenciaConteo;
        this.referencia = referencia;
        this.esperado = esperado;
        this.encontrado = encontrado;
        this.comentarios = comentarios;
        this.resuelta = resuelta;
        this.idConteo = idConteo;
    }

    public DiferenciasConteo(Long idDiferenciaConteo, String referencia, long esperado, long encontrado, String comentarios, Boolean resuelta, String tipo, ConteoTienda idConteo) {
        this.idDiferenciaConteo = idDiferenciaConteo;
        this.referencia = referencia;
        this.esperado = esperado;
        this.encontrado = encontrado;
        this.comentarios = comentarios;
        this.resuelta = resuelta;
        this.tipo = tipo;
        this.idConteo = idConteo;
    }

    public Long getIdDiferenciaConteo() {
        return idDiferenciaConteo;
    }

    public void setIdDiferenciaConteo(Long idDiferenciaConteo) {
        this.idDiferenciaConteo = idDiferenciaConteo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getEsperado() {
        return esperado;
    }

    public void setEsperado(long esperado) {
        this.esperado = esperado;
    }

    public long getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(long encontrado) {
        this.encontrado = encontrado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Boolean getResuelta() {
        return resuelta;
    }

    public void setResuelta(Boolean resuelta) {
        this.resuelta = resuelta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ConteoTienda getIdConteo() {
        return idConteo;
    }

    public void setIdConteo(ConteoTienda idConteo) {
        this.idConteo = idConteo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiferenciaConteo != null ? idDiferenciaConteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idDiferenciaConteo fields are not set
        if (!(object instanceof DiferenciasConteo)) {
            return false;
        }
        DiferenciasConteo other = (DiferenciasConteo) object;
        if ((this.idDiferenciaConteo == null && other.idDiferenciaConteo != null) || (this.idDiferenciaConteo != null && !this.idDiferenciaConteo.equals(other.idDiferenciaConteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.DiferenciasConteo[ idDiferenciaConteo=" + idDiferenciaConteo + " ]";
    }
}
