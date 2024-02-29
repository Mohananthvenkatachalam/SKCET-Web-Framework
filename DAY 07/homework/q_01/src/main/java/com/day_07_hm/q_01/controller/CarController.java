package com.day_07_hm.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_07_hm.q_01.model.Car;
import com.day_07_hm.q_01.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CarController {

    @Autowired
    public CarService personService;

    @PostMapping("/api/car")
    public ResponseEntity<Car> postMethodName(@RequestBody Car entity) {
        Car p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/api/car")
    public ResponseEntity<List<Car>> getMethodName() {
        List<Car> p = personService.getAllPerson();

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/car/distinct")
    public ResponseEntity<List<Car>> getMethod(@RequestParam("currentOwnerName") String currentOwnerName,
            @RequestParam("address") String address) {
        List<Car> p = personService.getByAgePerson(currentOwnerName, address);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
