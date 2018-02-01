package co.matisses.persistence.web.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_TERMINAL_POS")
public class BwsTerminalPOS implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Column(name = "cuentaEfectivo")
    private String cuentaEfectivo;
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "activa")
    private Boolean activa;

    public BwsTerminalPOS() {
    }

    public BwsTerminalPOS(String ip) {
        this.ip = ip;
    }

    public BwsTerminalPOS(String ip, Boolean activa) {
        this.ip = ip;
        this.activa = activa;
    }

    public String getCuentaEfectivo() {
        return cuentaEfectivo;
    }

    public void setCuentaEfectivo(String cuentaEfectivo) {
        this.cuentaEfectivo = cuentaEfectivo;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ip);
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
        final BwsTerminalPOS other = (BwsTerminalPOS) obj;
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BwsTerminalPOS{" + "ip=" + ip + ", activa=" + activa + ", cuentaEfectivo=" + cuentaEfectivo + '}';
    }

}
