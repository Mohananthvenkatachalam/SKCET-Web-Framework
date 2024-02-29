package com.day_09_cw.q_03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_09_cw.q_03.model.Village;
import com.day_09_cw.q_03.repository.VillageRepo;

@Service
public class VillageService {

    @Autowired
    public VillageRepo personRepo;

    public Village savePerson(Village person) {
        return personRepo.save(person);
    }

    public Village getRecipeById(int villageId) {
        return personRepo.findVillageById(villageId);
    }

    public List<Village> getRecipeByPopulation(int population) {
        return personRepo.findVillageByPopulation(population);
    }

    public List<Village> getRecipiesByName(String villageName) {
        return personRepo.findListByName(villageName);
    }
}
