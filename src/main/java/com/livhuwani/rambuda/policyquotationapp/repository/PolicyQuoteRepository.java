/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.repository;

import com.livhuwani.rambuda.policyquotationapp.domain.PolicyQuote;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author E939964
 */

@Repository
public interface PolicyQuoteRepository extends JpaRepository<PolicyQuote, Serializable>
{
    
}
