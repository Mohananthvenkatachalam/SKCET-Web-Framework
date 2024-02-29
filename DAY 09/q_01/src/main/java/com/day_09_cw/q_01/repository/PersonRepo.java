package com.day_09_cw.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.day_09_cw.q_01.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query("SELECT p from Person p where p.age = :age")
    List<Person> findListByAge(@Param("age") int age);
}
