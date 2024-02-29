package com.day_07_hm.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.day_07_hm.q_01.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    @Query("select b from Car b where b.currentOwnerName = ?1 and b.address = ?2")
    List<Car> findByCarrNameAndAddress(String a, String b);
}
