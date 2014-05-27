/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livhuwani.rambuda.policyquotationapp.repository;

import com.livhuwani.rambuda.policyquotationapp.domain.ChildMaintenance;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author DeeJayMD
 */

@Repository
public interface ChildMaintenanceRepository extends JpaRepository<ChildMaintenance, Serializable>
{
    
}
