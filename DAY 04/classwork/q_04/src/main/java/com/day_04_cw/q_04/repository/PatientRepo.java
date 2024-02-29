package com.day_04_cw.q_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_04_cw.q_04.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
