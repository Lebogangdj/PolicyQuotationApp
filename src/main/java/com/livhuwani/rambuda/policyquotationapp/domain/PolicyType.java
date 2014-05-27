/* File: PolicyType.java
 * This entity class will hold all the information required for a complete policy PolicyType record
 * Creator: Livhuwani Lucky Rambuda
 * Date created: 03 May 2014
 */

package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author DeejayMD
 */

@Embeddable
public class PolicyType implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private BusinessInterest BusinessInterest;
    
    private ChildMaintenance ChildMaintenance;
    
    private InsuranceDetails InsuranceDetails;
    
    private Investment Investment;

    public BusinessInterest getBusinessInterest() 
    {
        return BusinessInterest;
    }

    public void setBusinessInterest(BusinessInterest BusinessInterest) 
    {
        this.BusinessInterest = BusinessInterest;
    }

    public ChildMaintenance getChildMaintenance() 
    {
        return ChildMaintenance;
    }

    public void setChildMaintenance(ChildMaintenance ChildMaintenance) 
    {
        this.ChildMaintenance = ChildMaintenance;
    }

    public InsuranceDetails getInsuranceDetails() 
    {
        return InsuranceDetails;
    }

    public void setInsuranceDetails(InsuranceDetails InsuranceDetails) 
    {
        this.InsuranceDetails = InsuranceDetails;
    }

    public Investment getInvestment() 
    {
        return Investment;
    }

    public void setInvestment(Investment Investment) 
    {
        this.Investment = Investment;
    }
}
