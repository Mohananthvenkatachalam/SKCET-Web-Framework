package com.day_04_cw.q_02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_04_cw.q_02.model.Job;
import com.day_04_cw.q_02.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class JobController {

    @Autowired
    public JobService jobService;

    @PostMapping("/api/job")
    public ResponseEntity<String> postMethodName(@RequestBody Job entity) {
        if (jobService.saveJob(entity) == false) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/job")
    public ResponseEntity<List<Job>> getMethodName() {
        List<Job> jb = jobService.returnJob();
        if (jb.isEmpty()) {
            return new ResponseEntity<>(jb, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jb, HttpStatus.OK);
    }

    @GetMapping("/api/job/{jobId}")
    public ResponseEntity<Job> MethodName(@PathVariable int jobId) {
        Optional<Job> op = jobService.getJobById(jobId);
        if (op.isPresent()) {
            return new ResponseEntity<>(op.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(op.get(), HttpStatus.NOT_FOUND);
    }

}
