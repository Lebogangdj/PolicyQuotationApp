/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.services.Impl;

import com.livhuwani.rambuda.policyquotationapp.domain.BusinessInterest;
import com.livhuwani.rambuda.policyquotationapp.domain.ChildMaintenance;
import com.livhuwani.rambuda.policyquotationapp.domain.InsuranceDetails;
import com.livhuwani.rambuda.policyquotationapp.domain.Investment;
import com.livhuwani.rambuda.policyquotationapp.domain.Policy;
import com.livhuwani.rambuda.policyquotationapp.domain.PolicyType;
import com.livhuwani.rambuda.policyquotationapp.repository.PolicyRepository;
import com.livhuwani.rambuda.policyquotationapp.services.crud.PolicyCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author E939964
 */

@Service
public class PolicyCrudServiceImpl implements PolicyCrudService
{
    @Autowired
    private PolicyRepository policyRepository;
    
    @Override
    public Policy createBusinessPolicy(BusinessInterest type) 
    {
        Policy policy = new Policy();
        policy.setId(Long.MAX_VALUE+1);
        policy.setDescription("Businss Policy");
        policy.setOwnership("100");
        policy.setPolicyNumber("2154635");
        policy.setPolicyValue(BigDecimal.valueOf(1500000));
        policy.setTouchDate(new Date());
        policy.getPolicyType().setBusinessInterest(type);
        
        Policy savedPolicy = policyRepository.saveAndFlush(policy);
        return savedPolicy;
    }

    @Override
    public List<Policy> getAllBusinessPolicy(PolicyType type) 
    {
        List<Policy> businessInterest = new ArrayList<Policy>();
        List<Policy> allbusinessInterest = policyRepository.findAll();
        
        for (Policy policy : allbusinessInterest) 
        {
            if(policy.getPolicyType().getBusinessInterest() == null ? type.getBusinessInterest() == null : policy.getPolicyType().getBusinessInterest().equals(type.getBusinessInterest()))
            {
                businessInterest.add(policy);
            }
        }
        return businessInterest;
    }
    
    @Override
    public Policy createInsurancePolicy(InsuranceDetails type) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Policy> getAllInsurancePolicy(PolicyType type) 
    {
        List<Policy> insurance = new ArrayList<Policy>();
        List<Policy> allInsurance = policyRepository.findAll();
        
        for (Policy policy : allInsurance) 
        {
            if(policy.getPolicyType().getInsuranceDetails()== null ? type.getInsuranceDetails() == null : policy.getPolicyType().getInsuranceDetails().equals(type.getInsuranceDetails()))
            {
                insurance.add(policy);
            }
        }
        return insurance;
    }
    
    @Override
    public Policy createInvestmentPolicy(Investment type) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Policy> getAllIvestmentPolicy(PolicyType type) 
    { 
        List<Policy> investment = new ArrayList<Policy>();
        List<Policy> allInvestments = policyRepository.findAll();
        
        for (Policy policy : allInvestments) 
        {
            if(policy.getPolicyType().getInvestment()== null ? type.getInvestment() == null : policy.getPolicyType().getInvestment().equals(type.getInvestment()))
            {
                investment.add(policy);
            }
        }
        return investment;
    }
    
    @Override
    public Policy createChildMaintenancePolicy(ChildMaintenance type) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Policy> getAllMaintenancePolicy(PolicyType type) 
    {
        List<Policy> maintenance = new ArrayList<Policy>();
        List<Policy> allChildMaintenances = policyRepository.findAll();
        
        for (Policy policy : allChildMaintenances) 
        {
            if(policy.getPolicyType().getChildMaintenance()== null ? type.getChildMaintenance() == null : policy.getPolicyType().getChildMaintenance().equals(type.getChildMaintenance()))
            {
                maintenance.add(policy);
            }
        }
        return maintenance;
    }
    
}
