/* File: BusinessInterest.java
 * This entity class will hold all the information required for a complete BusinessInterest record
 * Creator: Livhuwani Lucky Rambuda
 * Date created: 03 May 2014
 */

package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DeejayMD
 */
@Entity
public class BusinessInterest implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String RegisteredName;
    
    private String BusniessType;

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getRegisteredName() 
    {
        return RegisteredName;
    }

    public void setRegisteredName(String registeredNme) 
    {
        this.RegisteredName = registeredNme;
    }
    
    public String getBusniessType() 
    {
        return BusniessType;
    }

    public void setBusniessType(String businessType) 
    {
        this.BusniessType = businessType;
    }

    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessInterest)) 
        {
            return false;
        }
        BusinessInterest other = (BusinessInterest) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() 
    {
        return "com.livhuwani.rambuda.policyquotationapp.domain.BusinessInterest[ id=" + id + " ]";
    }
    
}
