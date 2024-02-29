package com.day_06_cw.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.day_06_cw.q_01.model.Children;
import com.day_06_cw.q_01.repository.ChildrenRepo;

@Service
public class ChildrenService {
    @Autowired
    public ChildrenRepo childrenRepo;

    public boolean postChild(Children children) {
        try {
            childrenRepo.save(children);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Children> getByPaginate(int offset, int pageSize) {
        Page<Children> childrenPage = childrenRepo.findAll(PageRequest.of(offset, pageSize));
        return childrenPage.getContent();
    }

    public List<Children> getBySort(String field) {
        return childrenRepo.findAll(Sort.by(field));
    }

    public List<Children> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Children> pg = childrenRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
}
