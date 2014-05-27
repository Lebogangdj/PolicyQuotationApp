/* File: PolicyQuote.java
 * This entity class will hold all the information required for a complete policy quotation record
 * Creator: Livhuwani Lucky Rambuda
 * Date created: 03 May 2014
 */

package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author DeejayMD
 */
@Entity
public class PolicyQuote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date quoteDate;
    
    private BigDecimal quoteAmount;
    
    private Boolean quoteStatus;
    
    @OneToOne
    private Person party;
    
    @OneToMany
    private Policy policy;
    
    public Date getQuoteDate() 
    {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) 
    {
        this.quoteDate = quoteDate;
    }

    public Boolean getQuoteStatus() 
    {
        return quoteStatus;
    }

    public void setQuoteStatus(Boolean quoteStatus) 
    {
        this.quoteStatus = quoteStatus;
    }

    public BigDecimal getQuoteAmount() 
    {
        return quoteAmount;
    }

    public void setQuoteAmount(BigDecimal quoteAmount) 
    {
        this.quoteAmount = quoteAmount;
    }
    
    public Person getPerson() 
    {
        return party;
    }

    public void setPerson(Person customer) 
    {
        this.party = customer;
    }
    
    public Policy getPolicy() 
    {
        return policy;
    }

    public void setPolicy(Policy policy) 
    {
        this.policy = policy;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
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
        if (!(object instanceof PolicyQuote)) 
        {
            return false;
        }
        PolicyQuote other = (PolicyQuote) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.livhuwani.rambuda.policyquotationapp.domain.PolicyQuote[ id=" + id + " ]";
    }
    
}
