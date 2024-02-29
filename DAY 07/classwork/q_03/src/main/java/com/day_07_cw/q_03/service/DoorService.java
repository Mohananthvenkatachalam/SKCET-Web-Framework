package com.day_07_cw.q_03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_07_cw.q_03.model.Door;
import com.day_07_cw.q_03.repository.DoorRepo;

@Service
public class DoorService {

    @Autowired
    public DoorRepo personRepo;

    public Door postAPerson(Door person) {
        return personRepo.save(person);
    }

    public List<Door> getAllPerson() {
        return personRepo.findAll();
    }

    public List<Door> getByAgePerson(String courseName) {
        return personRepo.findByAccessType(courseName);
    }

    public List<Door> getByDoorId(int id) {
        return personRepo.findByDoorId(id);
    }
}
