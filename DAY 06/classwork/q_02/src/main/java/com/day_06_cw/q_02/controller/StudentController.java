package com.day_06_cw.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_06_cw.q_02.model.Student;
import com.day_06_cw.q_02.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

    @Autowired
    public StudentService childrenService;

    @PostMapping("/api/student")
    public ResponseEntity<Student> postMethodName(@RequestBody Student entity) {
        Student st = childrenService.postChild(entity);
        if (st != null) {
            return new ResponseEntity<>(st, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/student/sort")
    public ResponseEntity<List<Student>> getMethodField(@PathVariable("field") String field) {
        List<Student> ch = childrenService.getBySort(field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<Student>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize) {
        List<Student> ch = childrenService.getByPaginate(offset, pageSize);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Student>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Student> ch = childrenService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

}
