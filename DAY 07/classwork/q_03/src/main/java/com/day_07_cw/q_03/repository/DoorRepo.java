package com.day_07_cw.q_03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day_07_cw.q_03.model.Door;

@Repository
public interface DoorRepo extends JpaRepository<Door, Integer> {
    List<Door> findByAccessType(String accessType);

    List<Door> findByDoorId(int doorId);
}
