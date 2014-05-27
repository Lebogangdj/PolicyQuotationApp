/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author 208224262
 */
@Entity
public class Person implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    @Column(unique = true)
    private String email;
    @Embedded
    private Contact contact;
    @OneToOne
    private Intermediary user;
    private Person(Builder builder) 
    {
        id= builder.id;
        firstname = builder.firstname;
        lastname=builder.lastname;
        age = builder.age;
        email = builder.email;
        contact = builder.contact;
        user = builder.user;
       }

    private Person() 
    {
    }
    
    public static class Builder 
    {
        private Long id;
        private String firstname;
        private String lastname;
        private int age;
        private String email;
        private Contact contact;
        private Intermediary user;

        public Builder(String email) 
        {
            this.email = email;
        }

        public Builder id(Long value) 
        {
            id = value;
            return this;
        }

        public Builder firstname(String value)
        {
            firstname = value;
            return this;
        }

        public Builder lastnaname(String value) 
        {
            lastname = value;
            return this;
        }

        public Builder age(int value)
        {
            age = value;
            return this;
        }

        public Builder contact(Contact value)
        {
            contact = value;
            return this;
        }
        
        public Builder user(Intermediary value)
        {
            user = value;
            return this;
        }
        
        public Builder person(Person person)
        {
            id = person.getId();
            firstname = person.getFirstname();
            lastname = person.getLastname();
            age = person.getAge();
            email = person.getEmail();
            contact = person.getContact();
            user = person.getUser();
            return this;
        }
        
        public Person build()
        {
            return new Person(this);
        }

    }
    
    public int getAge() 
    {
        return age;
    }
    
    public Long getId() 
    {
        return id;
    }

    public String getFirstname() 
    {
        return firstname;
    }

    public Contact getContact() 
    {
        return contact;
    }
    
    public Intermediary getUser() 
    {
        return user;
    }

    public String getLastname() 
    {
        return lastname;
    }

    public String getEmail() 
    {
        return email;
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
        if (!(object instanceof Person)) 
        {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "com.livhuwani.rambuda.policyquotationapp.domain.Person[ id=" + id + " ]";
    }
    
}
