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
@Table(name = "DESTINATARIO_PLANTILLA_EMAIL")
@NamedQueries({
    @NamedQuery(name = "DestinatarioPlantillaEmail.findAll", query = "SELECT b FROM DestinatarioPlantillaEmail b")})
public class DestinatarioPlantillaEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "nombre_plantilla")
    private String nombrePlantilla;
    @Basic(optional = false)
    @Column(name = "para")
    private String para;
    @Column(name = "copia")
    private String copia;
    @Column(name = "copia_oculta")
    private String copiaOculta;

    public DestinatarioPlantillaEmail() {
    }

    public String getNombrePlantilla() {
        return nombrePlantilla;
    }

    public void setNombrePlantilla(String nombrePlantilla) {
        this.nombrePlantilla = nombrePlantilla;
    }

    public String getCopia() {
        return copia;
    }

    public void setCopia(String copia) {
        this.copia = copia;
    }

    public String getCopiaOculta() {
        return copiaOculta;
    }

    public void setCopiaOculta(String copiaOculta) {
        this.copiaOculta = copiaOculta;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombrePlantilla);
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
        final DestinatarioPlantillaEmail other = (DestinatarioPlantillaEmail) obj;
        if (!Objects.equals(this.nombrePlantilla, other.nombrePlantilla)) {
            return false;
        }
        return true;
    }

}
