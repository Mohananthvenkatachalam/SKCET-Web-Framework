package com.day_09_cw.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_09_cw.q_02.model.Recipe;
import com.day_09_cw.q_02.service.RecipeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RecipeController {

    @Autowired
    public RecipeService personService;

    @PostMapping("/api/recipe")
    public ResponseEntity<Recipe> postMethodName(@RequestBody Recipe entity) {
        Recipe p = personService.savePerson(entity);

        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/recipe/{recipeId}")
    public ResponseEntity<Recipe> getMethodName(@PathVariable("recipeId") int recipeId) {
        Recipe p = personService.getRecipeById(recipeId);
        if (p != null) {
            return new ResponseEntity(p, HttpStatus.OK);
        }
        return new ResponseEntity(p, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/recipe/byname")
    public ResponseEntity<Recipe> getMethod(@RequestParam("recipeName") String RecipeName) {
        List<Recipe> p = personService.getRecipiesByName(RecipeName);
        if (p.isEmpty()) {
            return new ResponseEntity(p, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(p, HttpStatus.OK);
    }

}
