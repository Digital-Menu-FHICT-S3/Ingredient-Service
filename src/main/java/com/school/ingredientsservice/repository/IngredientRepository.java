package com.school.ingredientsservice.repository;

import com.school.ingredientsservice.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByIngredientId(Long ingredientId);
}
