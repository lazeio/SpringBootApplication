package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	
	public Page<Patient> findByNomContains(String mc,Pageable pageable); 

}