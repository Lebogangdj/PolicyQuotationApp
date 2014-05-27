/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.services.Impl;

import com.livhuwani.rambuda.policyquotationapp.domain.Contact;
import com.livhuwani.rambuda.policyquotationapp.domain.Intermediary;
import com.livhuwani.rambuda.policyquotationapp.domain.Person;
import com.livhuwani.rambuda.policyquotationapp.repository.PersonRepository;
import com.livhuwani.rambuda.policyquotationapp.services.crud.PersonCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author E939964
 */

@Service
public class PersonCrudServiceImpl implements PersonCrudService
{
    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public Person createPerson(Intermediary user) 
    {
        Contact contact = new Contact();
        contact.setCell("0791374866");
        contact.setLandline("0219473536");
        contact.setAddress("1 Symphony Way, 203B New Residence, CPUT Bellville Campus, Bellville, 7530");
        
        Person newCust = new Person.Builder("209071187@ufh.ac.za")
                .firstname("Rudzani")
                .lastnaname("Nengovhela")
                .age(23)
                .contact(contact) //Add the contact details
                .user(user)
                .build();
        
        Person savedCust = personRepository.save(newCust);
        return savedCust;
    }

    @Override
    public List<Person> getAllCustomers() 
    {
       List<Person> customers = new ArrayList<>();
       List<Person> allCustomers = personRepository.findAll();
       
       for (Person person : allCustomers) 
       {
           customers.add(person);
       }
        return customers;
    }
    
    @Override
    public List<Person> getIntermediaryCustomers(Intermediary user)
    {
        List<Person> customers = new ArrayList<>();
        List<Person> allCustomers = personRepository.findAll();
        
        for (Person person : allCustomers) 
        {
            if(person.getUser() == user)
            {
                customers.add(person);
            }
        }
        return customers;
    }
}
