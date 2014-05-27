/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.services.crud;

import java.util.List;
import com.livhuwani.rambuda.policyquotationapp.domain.Intermediary;
import com.livhuwani.rambuda.policyquotationapp.domain.Person;

/**
 *
 * @author E939964
 */
public interface PersonCrudService
{
    //Create a Customer
    public Person createPerson(Intermediary user);
    
    //Get All Customers
    public List<Person> getAllCustomers(); 
    
    //Get All Customers created by the a specific User 
    public List<Person> getIntermediaryCustomers(Intermediary user);
}
