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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "TURNO_CAJA")
public class TurnoCaja implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurnoCaja")
    private Integer idTurnoCaja;
    @Basic(optional = false)
    @Column(name = "terminal")
    private String terminal;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cierre;

    public TurnoCaja() {
    }

    public TurnoCaja(Integer idTurnoCaja) {
        this.idTurnoCaja = idTurnoCaja;
    }

    public TurnoCaja(Integer idTurnoCaja, String terminal, String usuario, Date fecha) {
        this.idTurnoCaja = idTurnoCaja;
        this.terminal = terminal;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdTurnoCaja() {
        return idTurnoCaja;
    }

    public void setIdTurnoCaja(Integer idTurnoCaja) {
        this.idTurnoCaja = idTurnoCaja;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
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

    public Date getCierre() {
        return cierre;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idTurnoCaja);
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
        final TurnoCaja other = (TurnoCaja) obj;
        if (!Objects.equals(this.idTurnoCaja, other.idTurnoCaja)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TurnoCaja{" + "idTurnoCaja=" + idTurnoCaja + ", terminal=" + terminal + ", usuario=" + usuario + ", fecha=" + fecha + '}';
    }

}
