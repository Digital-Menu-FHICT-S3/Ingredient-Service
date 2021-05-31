package com.school.ingredientsservice.controller;

import com.school.ingredientsservice.VO.ResponseTemplateVO;
import com.school.ingredientsservice.entity.Ingredient;
import com.school.ingredientsservice.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/allInOrder")
    public List<Ingredient> getAllIngredientsInOrder() {
        return ingredientService.getAllIngredientsInOrder();
    }

    @PostMapping("/create")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngredientById(@PathVariable("id") Long ingredientId) {
        ingredientService.deleteIngredientById(ingredientId);
    }

    @GetMapping("test")
    public String Test() {
        return "testing works";
    }

}
