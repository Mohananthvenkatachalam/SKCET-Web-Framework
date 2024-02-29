package com.day_09_cw.q_02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_09_cw.q_02.model.Recipe;
import com.day_09_cw.q_02.repository.RecipeRepo;

@Service
public class RecipeService {

    @Autowired
    public RecipeRepo personRepo;

    public Recipe savePerson(Recipe person) {
        return personRepo.save(person);
    }

    public Recipe getRecipeById(int id) {
        return personRepo.findRecipeById(id);
    }

    public List<Recipe> getRecipiesByName(String recipeName) {
        return personRepo.findListByAge(recipeName);
    }
}
