package com.day_03_cw.q_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_03_cw.q_01.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

}
