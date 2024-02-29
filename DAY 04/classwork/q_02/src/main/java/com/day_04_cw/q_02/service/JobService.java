package com.day_04_cw.q_02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_04_cw.q_02.model.Job;
import com.day_04_cw.q_02.repository.JobRepo;

@Service
public class JobService {
    @Autowired
    public JobRepo jobRepo;

    public boolean saveJob(Job j) {
        try {
            jobRepo.save(j);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Job> returnJob() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(int id) {
        return jobRepo.findById(id);
    }
}
