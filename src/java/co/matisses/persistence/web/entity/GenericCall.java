package co.matisses.persistence.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbotero
 */
@Entity
@Table(name = "GENERIC_CALL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericCall.findAll", query = "SELECT g FROM GenericCall g")})
public class GenericCall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_generic_call")
    private Long idGenericCall;
    @Basic(optional = false)
    @Column(name = "class_name")
    private String className;
    @Basic(optional = false)
    @Column(name = "method_name")
    private String methodName;
    @Basic(optional = false)
    @Column(name = "id_object")
    private String idObject;
    @Basic(optional = false)
    @Column(name = "id_operation")
    private String idOperation;
    @Lob
    @Column(name = "parameters")
    private String parameters;
    @Basic(optional = false)
    @Column(name = "return_type")
    private String returnType;
    @Basic(optional = false)
    @Column(name = "xml_data_type")
    private String xmlDataType;

    public GenericCall() {
    }

    public GenericCall(Long idGenericCall) {
        this.idGenericCall = idGenericCall;
    }

    public GenericCall(Long idGenericCall, String className, String methodName) {
        this.idGenericCall = idGenericCall;
        this.className = className;
        this.methodName = methodName;
    }

    public Long getIdGenericCall() {
        return idGenericCall;
    }

    public void setIdGenericCall(Long idGenericCall) {
        this.idGenericCall = idGenericCall;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getIdObject() {
        return idObject;
    }

    public void setIdObject(String idObject) {
        this.idObject = idObject;
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getXmlDataType() {
        return xmlDataType;
    }

    public void setXmlDataType(String xmlDataType) {
        this.xmlDataType = xmlDataType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenericCall != null ? idGenericCall.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericCall)) {
            return false;
        }
        GenericCall other = (GenericCall) object;
        if ((this.idGenericCall == null && other.idGenericCall != null) || (this.idGenericCall != null && !this.idGenericCall.equals(other.idGenericCall))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.webintegrator.entity.GenericCall[ idGenericCall=" + idGenericCall + " ]";
    }

}
