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
    public List<Ingredient> ingredients(@RequestBody Ingredient ingredient) {
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/create")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

//    @GetMapping("/{id}")
//    public ResponsTemplateVO getIngredientWithStock(@PathVariable("id") Long IngredientId) {
//        log.info("Inside getUserWithDepartment of UserController");
//        return userService.getUserWithDepartment(userId);
//    }


    @GetMapping("/{id}")
    public ResponseTemplateVO getIngredientWithStock(@PathVariable("id") Long IngredientId) {
        return ingredientService.getIngredientWithStock(IngredientId);
    }


//    @GetMapping("/{id}")
//    public Ingredient findIngredientById(@PathVariable("id") Long IngredientId) {
//        return ingredientService.findIngredientById(IngredientId);
//    }

//    @GetMapping("/{id}")
//    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
//        log.info("Inside findDepartmentById of DepartmentService");
//        return departmentService.findDepartmentById(departmentId);
//
//    }


}