package com.day_09_cw.q_03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.day_09_cw.q_03.model.Village;
import com.day_09_cw.q_03.service.VillageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RecipeController {

    @Autowired
    public VillageService personService;

    @PostMapping("/api/village")
    public ResponseEntity<Village> postMethodName(@RequestBody Village entity) {
        Village p = personService.savePerson(entity);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/village/{villageId}")
    public ResponseEntity<Village> getMethodName(@PathVariable("recipeId") int recipeId) {
        Village p = personService.getRecipeById(recipeId);
        if (p != null) {
            return new ResponseEntity(p, HttpStatus.OK);
        }
        return new ResponseEntity(p, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/recipe/byname/{villageName}")
    public ResponseEntity<Village> getMethod(@PathVariable("villageName") String villageName) {
        List<Village> p = personService.getRecipiesByName(villageName);
        if (p.isEmpty()) {
            return new ResponseEntity(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(p, HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/api/recipe/byname/{villagePopulation}")
    public ResponseEntity<Village> getMethodN(@PathVariable("villagePopulation") int villagePopulation) {
        List<Village> p = personService.getRecipeByPopulation(villagePopulation);
        if (p.isEmpty()) {
            return new ResponseEntity(p, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(p, HttpStatus.OK);
    }

}
