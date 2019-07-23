/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "PERSONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persons.findAll", query = "SELECT p FROM Persons p")
    , @NamedQuery(name = "Persons.findByPersonid", query = "SELECT p FROM Persons p WHERE p.personid = :personid")
    , @NamedQuery(name = "Persons.findByPassword", query = "SELECT p FROM Persons p WHERE p.password = :password")
    , @NamedQuery(name = "Persons.findByPersonname", query = "SELECT p FROM Persons p WHERE p.personname = :personname")
    , @NamedQuery(name = "Persons.findByGender", query = "SELECT p FROM Persons p WHERE p.gender = :gender")
    , @NamedQuery(name = "Persons.findByFamilyrole", query = "SELECT p FROM Persons p WHERE p.familyrole = :familyrole")})
public class Persons implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONID")
    private BigDecimal personid;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "PERSONNAME")
    private String personname;
    @Size(max = 255)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 255)
    @Column(name = "FAMILYROLE")
    private String familyrole;
    @JoinTable(name = "PERSONAPPRELATION", joinColumns = {
        @JoinColumn(name = "PERSONID", referencedColumnName = "PERSONID")}, inverseJoinColumns = {
        @JoinColumn(name = "APPID", referencedColumnName = "APPID")})
    @ManyToMany
    private List<Apps> appsList;

    public Persons() {
    }

    public Persons(BigDecimal personid) {
        this.personid = personid;
    }

    public BigDecimal getPersonid() {
        return personid;
    }

    public void setPersonid(BigDecimal personid) {
        this.personid = personid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFamilyrole() {
        return familyrole;
    }

    public void setFamilyrole(String familyrole) {
        this.familyrole = familyrole;
    }

    @XmlTransient
    public List<Apps> getAppsList() {
        return appsList;
    }

    public void setAppsList(ArrayList<Apps> appsList) {
        this.appsList = appsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personid != null ? personid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.personid == null && other.personid != null) || (this.personid != null && !this.personid.equals(other.personid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persons[ personid=" + personid + " ]";
    }
    
}
