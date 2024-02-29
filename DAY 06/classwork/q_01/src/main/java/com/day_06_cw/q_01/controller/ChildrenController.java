package com.day_06_cw.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_06_cw.q_01.model.Children;
import com.day_06_cw.q_01.service.ChildrenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ChildrenController {

    @Autowired
    public ChildrenService childrenService;

    @PostMapping("/api/children")
    public ResponseEntity<String> postMethodName(@RequestBody Children entity) {
        if (childrenService.postChild(entity)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/children/{field}")
    public ResponseEntity<List<Children>> getMethodField(@PathVariable("field") String field) {
        List<Children> ch = childrenService.getBySort(field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize) {
        List<Children> ch = childrenService.getByPaginate(offset, pageSize);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Children> ch = childrenService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }

}
