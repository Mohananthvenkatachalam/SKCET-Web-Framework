package com.day_06_cw.q_02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.day_06_cw.q_02.model.Student;
import com.day_06_cw.q_02.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    public StudentRepo childrenRepo;

    public Student postChild(Student children) {
        return childrenRepo.save(children);
    }

    public List<Student> getByPaginate(int offset, int pageSize) {
        Page<Student> childrenPage = childrenRepo.findAll(PageRequest.of(offset, pageSize));
        return childrenPage.getContent();
    }

    public List<Student> getBySort(String field) {
        return childrenRepo.findAll(Sort.by(field));
    }

    public List<Student> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Student> pg = childrenRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
}
