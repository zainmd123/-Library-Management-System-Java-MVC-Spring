package com.verinon.lbm.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verinon.lbm.pojos.SmartBookSystem;

public interface SmartBookSystemRepository extends JpaRepository<SmartBookSystem, Integer>
{
    
}
