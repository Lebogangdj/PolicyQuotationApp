/* File: InsuranceDetails.java
 * This entity class will hold all the information required for a complete InsuranceDetails record
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
public class InsuranceDetails implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String CompanyName;
    
    private String InsuranceType; //1. Annuity, 2. LifeInsurance 3. RetirementFund 

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getCompanyName() 
    {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) 
    {
        this.CompanyName = CompanyName;
    }
    
    public String getInsuranceType() 
    {
        return InsuranceType;
    }
    
    public void setInsuranceType(String insuranceType) 
    {
        this.InsuranceType = insuranceType;
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
        if (!(object instanceof InsuranceDetails)) 
        {
            return false;
        }
        InsuranceDetails other = (InsuranceDetails) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() 
    {
        return "com.livhuwani.rambuda.policyquotationapp.domain.InsuranceDetails[ id=" + id + " ]";
    }
    
}
