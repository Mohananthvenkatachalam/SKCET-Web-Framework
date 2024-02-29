package com.day_09_cw.q_03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.day_09_cw.q_03.model.Village;

@Repository
public interface VillageRepo extends JpaRepository<Village, Integer> {

    @Query("SELECT p from Village p where p.villageName = :villageName")
    List<Village> findListByName(@Param("villageName") String villageName);

    @Query("SELECT p from Village p where p.villageId = :villageId")
    Village findVillageById(@Param("villageId") int villageId);

    @Query("SELECT p from Village p where p.villagePopulation = :population")
    List<Village> findVillageByPopulation(@Param("population") int population);

}
