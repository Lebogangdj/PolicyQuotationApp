/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.services.crud;

import java.util.List;
import com.livhuwani.rambuda.policyquotationapp.domain.Person;
import com.livhuwani.rambuda.policyquotationapp.domain.Policy;
import com.livhuwani.rambuda.policyquotationapp.domain.PolicyQuote;

/**
 *
 * @author DeejayMD
 */
public interface PolicyQuoteCrudService
{
    public PolicyQuote createPolicyQuotes(Person person, Policy policy);
    
    public List<PolicyQuote> getAllPolicyQuotes(Person person);
}
