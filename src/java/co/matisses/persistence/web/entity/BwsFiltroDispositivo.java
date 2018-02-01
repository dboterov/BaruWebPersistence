/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "BWS_FILTRO_DISPOSITIVO")
@NamedQueries({
    @NamedQuery(name = "BwsFiltroDispositivo.findAll", query = "SELECT b FROM BwsFiltroDispositivo b")})
public class BwsFiltroDispositivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "userAgent")
    private String userAgent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 20)
    @Column(name = "redirigeA")
    private String redirigeA;

    public BwsFiltroDispositivo() {
    }

    public BwsFiltroDispositivo(String userAgent) {
        this.userAgent = userAgent;
    }

    public BwsFiltroDispositivo(String userAgent, String tipo) {
        this.userAgent = userAgent;
        this.tipo = tipo;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRedirigeA() {
        return redirigeA;
    }

    public void setRedirigeA(String redirigeA) {
        this.redirigeA = redirigeA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAgent != null ? userAgent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BwsFiltroDispositivo)) {
            return false;
        }
        BwsFiltroDispositivo other = (BwsFiltroDispositivo) object;
        if ((this.userAgent == null && other.userAgent != null) || (this.userAgent != null && !this.userAgent.equals(other.userAgent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.web.persistence.entity.BwsFiltroDispositivo[ userAgent=" + userAgent + " ]";
    }
    
}
