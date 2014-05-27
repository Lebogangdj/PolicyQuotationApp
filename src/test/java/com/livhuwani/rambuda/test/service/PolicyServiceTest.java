/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.test.service;

import com.livhuwani.rambuda.policyquotationapp.app.conf.ConnectionConfig;
import com.livhuwani.rambuda.policyquotationapp.domain.BusinessInterest;
import com.livhuwani.rambuda.policyquotationapp.domain.Intermediary;
import com.livhuwani.rambuda.policyquotationapp.domain.Person;
import com.livhuwani.rambuda.policyquotationapp.domain.Policy;
import com.livhuwani.rambuda.policyquotationapp.domain.PolicyQuote;
import com.livhuwani.rambuda.policyquotationapp.services.crud.IntermediaryCrudService;
import com.livhuwani.rambuda.policyquotationapp.services.crud.PersonCrudService;
import com.livhuwani.rambuda.policyquotationapp.services.crud.PolicyCrudService;
import com.livhuwani.rambuda.policyquotationapp.services.crud.PolicyQuoteCrudService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author DeeJayMD
 */
public class PolicyServiceTest 
{
    public static ApplicationContext ctx;
    private Intermediary validUser;
    private Person customer;
    private Policy policy;
    
    private IntermediaryCrudService userService;
    private PersonCrudService custService;
    private PolicyCrudService policyService;
    private PolicyQuoteCrudService quoteService;
    
    public PolicyServiceTest() 
    {
    }
    
    @Test
    public void CreateUser()
    {
        userService = ctx.getBean(IntermediaryCrudService.class);
        validUser = userService.createIntermediary();
        Assert.notNull(validUser);
    }
    
    @Test (dependsOnMethods = "CreateUser")
    public void CreatePerson()
    {
        custService = ctx.getBean(PersonCrudService.class);
        customer = custService.createPerson(validUser);
        Assert.notNull(customer);
    }
    
    @Test (dependsOnMethods = "CreatePerson")
    public void CreateQuote()
    {
        policyService = ctx.getBean(PolicyCrudService.class);
        quoteService = ctx.getBean(PolicyQuoteCrudService.class);
                
        //Create a Policy type
        BusinessInterest business = new BusinessInterest();
        business.setId(Long.MAX_VALUE+1);
        business.setBusniessType("Private Company");
        business.setRegisteredName("MD Corperations SA (PTY) LtD");
        
        //Create a Policy and add the type
        policy = policyService.createBusinessPolicy(business);
        Assert.notNull(policy);
        
        //Create a Quote and add a policy to the quote
        PolicyQuote quote =  quoteService.createPolicyQuotes(customer, policy);
        Assert.notNull(quote);
    }
    
    @Test(dependsOnMethods = "createQuote")
    public void readQuotes()
    {   
        quoteService = ctx.getBean(PolicyQuoteCrudService.class);
        List<PolicyQuote> quotes = quoteService.getAllPolicyQuotes(customer);
        Assert.notNull(quotes);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception 
    {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception 
    {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception 
    {
    }
}
