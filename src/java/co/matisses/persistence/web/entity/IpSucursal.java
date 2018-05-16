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
@Table(name = "IP_SUCURSAL")
@NamedQueries({
    @NamedQuery(name = "IpSucursal.findAll", query = "SELECT i FROM IpSucursal i")})
public class IpSucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "segmento")
    private String segmento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sucursal")
    private String sucursal;

    public IpSucursal() {
    }

    public IpSucursal(String segmento) {
        this.segmento = segmento;
    }

    public IpSucursal(String segmento, String sucursal) {
        this.segmento = segmento;
        this.sucursal = sucursal;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segmento != null ? segmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpSucursal)) {
            return false;
        }
        IpSucursal other = (IpSucursal) object;
        if ((this.segmento == null && other.segmento != null) || (this.segmento != null && !this.segmento.equals(other.segmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.web.entity.IpSucursal[ segmento=" + segmento + " ]";
    }
    
}
