package com.day_04_cw.q_04.controller;

import org.springframework.web.bind.annotation.RestController;

import com.day_04_cw.q_04.model.Patient;
import com.day_04_cw.q_04.service.PatientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    public PatientService patientService;

    @GetMapping("/api/patient")
    public ResponseEntity<List<Patient>> getMethodName() {
        List<Patient> list = patientService.getList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/patient")
    public ResponseEntity<Patient> postMethodName(@RequestBody Patient entity) {
        Patient p = patientService.addPatient(entity);
        if (p != null) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/patient/{id}")
    public ResponseEntity<Patient> getMethodName(@PathVariable int id) {
        if (patientService.getId(id) != null) {
            return new ResponseEntity<>(patientService.getId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
