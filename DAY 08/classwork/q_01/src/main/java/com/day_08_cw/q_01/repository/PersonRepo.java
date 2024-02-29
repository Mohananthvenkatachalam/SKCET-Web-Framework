package com.day_08_cw.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.day_08_cw.q_01.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(CONCAT(:value, '%'))")
    List<Person> findByNameStartsWith(String value);

    @Query("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',:value))")
    List<Person> findByNameEndsWith(String value);
}
