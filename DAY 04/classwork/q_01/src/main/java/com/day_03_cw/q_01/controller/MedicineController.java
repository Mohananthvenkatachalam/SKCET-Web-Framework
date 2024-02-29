package com.day_03_cw.q_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_03_cw.q_01.model.Medicine;
import com.day_03_cw.q_01.service.MedicineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MedicineController {

    @Autowired
    public MedicineService medicineService;

    @PostMapping("/api/medicine")
    public ResponseEntity<String> postMethodName(@RequestBody Medicine entity) {
        if (medicineService.saveMedicine(entity) == false) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/medicines")
    public ResponseEntity<List<Medicine>> getMethodName() {
        List<Medicine> med = medicineService.listOfMedicines();
        if (med.isEmpty()) {
            return new ResponseEntity<>(med, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(med, HttpStatus.OK);
    }

    @GetMapping("/api/medicine/{medicineId}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable int medicineId) {

        Optional<Medicine> findmed = medicineService.findMedicineById(medicineId);

        if (findmed.isPresent()) {
            Medicine medicine = findmed.get();
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
