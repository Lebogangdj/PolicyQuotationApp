package com.livhuwani.rambuda.test.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.livhuwani.rambuda.policyquotationapp.app.conf.ConnectionConfig;
import com.livhuwani.rambuda.policyquotationapp.domain.Contact;
import com.livhuwani.rambuda.policyquotationapp.domain.Intermediary;
import com.livhuwani.rambuda.policyquotationapp.domain.Person;
import com.livhuwani.rambuda.policyquotationapp.repository.IntermediaryRepository;
import com.livhuwani.rambuda.policyquotationapp.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 208224262
 */
public class PersonRepoTest 
{
    public static ApplicationContext ctx;
    private Long id;

    private PersonRepository repo;
    private IntermediaryRepository intermediaryRepo;
    
    public PersonRepoTest() 
    {
    }

    @Test
    public void createUser()
    {
        intermediaryRepo = ctx.getBean(IntermediaryRepository.class);
        Intermediary user = new Intermediary();
        
        intermediaryRepo.save(user);
        id = user.getId();
        Assert.assertNotNull(id); //Check if the user record was saved
        
    }
    
    @Test(dependsOnMethods = "createUser")
    public void createPerson() 
    {
        repo = ctx.getBean(PersonRepository.class);
        Intermediary user = intermediaryRepo.findOne(id);
        //Create contact Details
        Contact contact = new Contact();
        contact.setCell("0763808106");
        contact.setLandline("0219473536");
        contact.setAddress("1 Symphony Way, 203B New Residence, CPUT Bellville Campus, Bellville, 7530");
        
        //Create the person
        Person p = new Person.Builder("208224262@cput.ac.za")
                .firstname("Livhuwani")
                .lastnaname("Rambuda")
                .age(24)
                .contact(contact) //Add the contact details
                .user(user)
                .build();
        repo.save(p);
        id = p.getId();
        Assert.assertNotNull(p); //Check if the person record was saved
     }
    
    @Test(dependsOnMethods = "createPerson")
    public void readPerson()
    {
        repo = ctx.getBean(PersonRepository.class);
        Person person = repo.findOne(id);
        Assert.assertEquals(person.getFirstname(), "Livhuwani");
    }
    
    @Test(dependsOnMethods = "readPerson")
    private void updatePerson()
    {
        repo = ctx.getBean(PersonRepository.class);
        Person person = repo.findOne(id);
        Person updatedPerson = new Person.Builder("208224262@cput.ac.za")
                .person(person)
                .firstname("Lucky")
                .build();
        
        repo.save(updatedPerson);
         
        Person newPerson = repo.findOne(id);
        Assert.assertEquals(newPerson.getFirstname(), "Lucky"); 
    }
    
    @Test(dependsOnMethods = "updatePerson")
    private void deletePerson()
    {
        repo = ctx.getBean(PersonRepository.class);
        Person person = repo.findOne(id);
        repo.delete(person);
        
        Person deletedPerson = repo.findOne(id);
        Assert.assertNull(deletedPerson);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);	
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
