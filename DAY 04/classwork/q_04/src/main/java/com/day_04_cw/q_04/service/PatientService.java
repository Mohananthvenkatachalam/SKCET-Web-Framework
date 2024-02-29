package com.day_04_cw.q_04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_04_cw.q_04.model.Patient;
import com.day_04_cw.q_04.repository.PatientRepo;

@Service
public class PatientService {
    @Autowired
    public PatientRepo patientRepo;

    public Patient addPatient(Patient p) {
        return patientRepo.save(p);
    }

    public List<Patient> getList() {
        return patientRepo.findAll();
    }

    public Patient getId(int id) {
        try {
            Patient p = patientRepo.findById(id).orElse(null);
            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
