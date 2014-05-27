/* File: Investment.java
 * This entity class will hold all the information required for a complete Investment record
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
 *@author DeejayMD
 */
@Entity
public class Investment implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String InstitutionName;
    
    private String Number;
    
    private String InvestmentType;

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getInstitutionName() 
    {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) 
    {
        this.InstitutionName = institutionName;
    }
    
    public String getNumber() 
    {
        return Number;
    }

    public void setNumber(String number) 
    {
        this.Number = number;
    }
    
    public String getInvestmentType() 
    {
        return InvestmentType;
    }

    public void setInvestmentType(String investmentType) 
    {
        this.InvestmentType = investmentType;
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
        if (!(object instanceof Investment)) 
        {
            return false;
        }
        Investment other = (Investment) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() 
    {
        return "com.livhuwani.rambuda.policyquotationapp.domain.Investment[ id=" + id + " ]";
    }
    
}
