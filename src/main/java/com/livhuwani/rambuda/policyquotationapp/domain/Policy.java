/* File: Policy.java
 * This entity class will hold all the information required for a complete policy record
 * Creator: Livhuwani Lucky Rambuda
 * Date created: 03 May 2014
 */

package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author DeejayMD
 */
@Entity
public class Policy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    
    private String policyNumber;
    
    private String ownership;
    
    private BigDecimal policyValue;
    
    @Embedded
    private PolicyType PolicyType; //1. BusinessInterest, 2. Investment, 3. Insurance or 4. ContingentLiabilities
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date touchDate;
    
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String Description) 
    {
        this.description = Description;
    }
    
    public String getPolicyNumber() 
    {
        return policyNumber;
    }

    public void setPolicyNumber(String PolicyNumber) 
    {
        this.policyNumber = PolicyNumber;
    }
    
    public String getOwnership() 
    {
        return ownership;
    }

    public void setOwnership(String Ownership) 
    {
        this.ownership = Ownership;
    }
    
    public BigDecimal getPolicyValue() 
    {
        return policyValue;
    }

    public void setPolicyValue(BigDecimal PolicyValue) 
    {
        this.policyValue = PolicyValue;
    }
    
    public PolicyType getPolicyType() 
    {
        return PolicyType;
    }

    public void setPolicyType(PolicyType type) 
    {
        this.PolicyType = type;
    }
    
    public Date getTouchDate() 
    {
        return touchDate;
    }

    public void setTouchDate(Date touchDate) 
    {
        this.touchDate = touchDate;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Policy)) 
        {
            return false;
        }
        Policy other = (Policy) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.livhuwani.rambuda.policyquotationapp.domain.Policy[ id=" + id + " ]";
    }
    
}
