package com.day_07_hm.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_07_hm.q_01.model.Car;
import com.day_07_hm.q_01.repository.CarRepo;

@Service
public class CarService {

    @Autowired
    public CarRepo personRepo;

    public Car postAPerson(Car person) {
        return personRepo.save(person);
    }

    public List<Car> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Car> getByAgePerson(String a, String b) {
        return personRepo.findByCarrNameAndAddress(a, b);
    }
}
