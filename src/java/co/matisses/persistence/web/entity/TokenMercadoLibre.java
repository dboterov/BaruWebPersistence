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
 * @author dbotero
 */
@Entity
@Table(name = "TOKEN_MERCADOLIBRE")
public class TokenMercadoLibre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idToken")
    private Integer idToken;
    @Basic(optional = false)
    @Column(name = "expiresIn")
    private Integer expiresIn;
    @Basic(optional = false)
    @Column(name = "systime")
    private Long systime;
    @Basic(optional = false)
    @Column(name = "userId")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "accessToken")
    private String accessToken;
    @Basic(optional = false)
    @Column(name = "refreshToken")
    private String refreshToken;
    @Basic(optional = false)
    @Column(name = "scope")
    private String scope;

    public TokenMercadoLibre() {
    }

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getSystime() {
        return systime;
    }

    public void setSystime(Long systime) {
        this.systime = systime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idToken);
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
        final TokenMercadoLibre other = (TokenMercadoLibre) obj;
        if (!Objects.equals(this.idToken, other.idToken)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TokenMercadoLibre{" + "idToken=" + idToken + ", expiresIn=" + expiresIn + ", systime=" + systime + ", userId=" + userId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", scope=" + scope + '}';
    }

}
