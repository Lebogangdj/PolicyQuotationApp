/* File: ChildMaintenance.java
 * This entity class will hold all the information required for a complete ChildMaintenance record
 * Creator: Livhuwani Lucky Rambuda
 * Date created: 03 May 2014
 */
package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DeejayMD
 */
@Entity
public class ChildMaintenance implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int AnnualIncreasePercentage;
    
    private BigDecimal CashValue;
    
    private int Term;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getAnnualIncreasePercentage()
    {
        return AnnualIncreasePercentage;
    }

    public void setAnnualIncreasePercentage(int AnnualIncreasePercentage)
    {
        this.AnnualIncreasePercentage = AnnualIncreasePercentage;
    }

    public BigDecimal getCashValue()
    {
        return CashValue;
    }

    public void setCashValue(BigDecimal CashValue) 
    {
        this.CashValue = CashValue;
    }

    public int getTerm() 
    {
        return Term;
    }

    public void setTerm(int Term) 
    {
        this.Term = Term;
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
        if (!(object instanceof ChildMaintenance)) 
        {
            return false;
        }
        ChildMaintenance other = (ChildMaintenance) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() 
    {
        return "com.livhuwani.rambuda.policyquotationapp.domain.ChildMaintenance[ id=" + id + " ]";
    }
    
}
