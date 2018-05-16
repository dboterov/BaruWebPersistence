package co.matisses.persistence.web.entity;

import java.io.Serializable;
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
@Table(name = "MUNICIPIOS_CERCANOS")
@NamedQueries({
    @NamedQuery(name = "MunicipiosCercanos.findAll", query = "SELECT m FROM MunicipiosCercanos m")})
public class MunicipiosCercanos implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "codMunicipio")
    private String codMunicipio;
    @Basic(optional = false)
    @Column(name = "codMunicipioPpal")
    private String codMunicipioPpal;

    public MunicipiosCercanos(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public MunicipiosCercanos() {
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getCodMunicipioPpal() {
        return codMunicipioPpal;
    }

    public void setCodMunicipioPpal(String codMunicipioPpal) {
        this.codMunicipioPpal = codMunicipioPpal;
    }
}
