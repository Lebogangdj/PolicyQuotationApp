/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.services.Impl;

import com.livhuwani.rambuda.policyquotationapp.domain.Intermediary;
import com.livhuwani.rambuda.policyquotationapp.repository.IntermediaryRepository;
import com.livhuwani.rambuda.policyquotationapp.services.crud.IntermediaryCrudService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author E939964
 */
@Service
public class IntermediaryCrudServiceImpl implements IntermediaryCrudService
{
    @Autowired
    private IntermediaryRepository intermediaryRepository;
    
    @Override
    public Intermediary createIntermediary() 
    {
        Intermediary newUser = new Intermediary();
        newUser.setId(Long.MAX_VALUE+1);
        newUser.setIntermediaryCode("208224262");
        
        Intermediary savedUser = intermediaryRepository.save(newUser);
        return savedUser;
    }

    @Override
    public List<Intermediary> getIntermediaries() 
    {
        List<Intermediary> users = new ArrayList<Intermediary>();
        List<Intermediary> allUsers = intermediaryRepository.findAll();
        
        for (Intermediary user : allUsers) 
        {
            users.add(user);
        }
        return users;
    }
    
    @Override
    public Intermediary updateIntermediary(Long id) 
    {
        Intermediary updUser = intermediaryRepository.getOne(id);
        
        if(updUser != null)
        {
            updUser.setIntermediaryCode("201407118");
            intermediaryRepository.saveAndFlush(updUser);
        }
         
        return updUser;
    }

    @Override
    public void deleteIntermediary(Long id) 
    {
        List<Intermediary> validUser = new ArrayList<Intermediary>();
        List<Intermediary> allUsers = intermediaryRepository.findAll();
         
        for (Intermediary user : allUsers) 
        {
            if(Objects.equals(user.getId(), id))
            {
                validUser.add(user);
            }
        }
        intermediaryRepository.deleteInBatch(validUser);
    }
}
