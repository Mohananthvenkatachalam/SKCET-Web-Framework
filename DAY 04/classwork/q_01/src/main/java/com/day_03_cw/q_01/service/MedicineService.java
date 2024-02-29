package com.day_03_cw.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_03_cw.q_01.model.Medicine;
import com.day_03_cw.q_01.repository.MedicineRepo;

@Service
public class MedicineService {

    @Autowired
    public MedicineRepo medicineRepo;

    public boolean saveMedicine(Medicine medicine) {
        try {
            medicineRepo.save(medicine);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Medicine> listOfMedicines() {
        return medicineRepo.findAll();
    }

    public Optional<Medicine> findMedicineById(int id) {
        return medicineRepo.findById(id);
    }
}
