package com.day_09_cw.q_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.day_09_cw.q_02.model.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

    @Query("SELECT p from Recipe p where p.recipeName = :recipeName")
    List<Recipe> findListByAge(@Param("recipeName") String RecipeName);

    @Query("SELECT p from Recipe p where p.recipeId = :recipeId")
    Recipe findRecipeById(@Param("recipeId") int recipeId);
}
