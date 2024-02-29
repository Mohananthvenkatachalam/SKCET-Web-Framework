package com.day_07_cw.q_03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_07_cw.q_03.model.Door;
import com.day_07_cw.q_03.service.DoorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DoorController {
    @Autowired
    public DoorService personService;

    @PostMapping("/api/door")
    public ResponseEntity<Door> postMethodName(@RequestBody Door entity) {
        Door p = personService.postAPerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/api/door")
    public ResponseEntity<List<Door>> getMethodName() {
        List<Door> p = personService.getAllPerson();

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<List<Door>> getMethod(@PathVariable("doorId") int doorId) {
        List<Door> p = personService.getByDoorId(doorId);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/door/accestype/{accessType}")
    public ResponseEntity<List<Door>> geMethod(@PathVariable("accessType") String accessType) {
        List<Door> p = personService.getByAgePerson(accessType);

        if (p.isEmpty()) {
            return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
