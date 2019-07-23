/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Krisztian
 */
@Entity
@Table(name = "APPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apps.findAll", query = "SELECT a FROM Apps a")
    , @NamedQuery(name = "Apps.findByAppid", query = "SELECT a FROM Apps a WHERE a.appid = :appid")
    , @NamedQuery(name = "Apps.findByAppname", query = "SELECT a FROM Apps a WHERE a.appname = :appname")
    , @NamedQuery(name = "Apps.findByAppsize", query = "SELECT a FROM Apps a WHERE a.appsize = :appsize")})
public class Apps implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPID")
    private int appid;
    @Size(max = 255)
    @Column(name = "APPNAME")
    private String appname;
    @Column(name = "APPSIZE")
    private BigInteger appsize;
    @ManyToMany(mappedBy = "appsList")
    private List<Persons> personsList;

    public Apps() {
    }

    public Apps(int appid) {
        this.appid = appid;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public BigInteger getAppsize() {
        return appsize;
    }

    public void setAppsize(BigInteger appsize) {
        this.appsize = appsize;
    }

    @XmlTransient
    public List<Persons> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(ArrayList<Persons> personsList) {
        this.personsList = personsList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.appid;
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
        final Apps other = (Apps) obj;
        if (this.appid != other.appid) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "entities.Apps[ appid=" + appid + " ]";
    }
    
}
