package com.school.ingredientsservice.service;

import com.school.ingredientsservice.VO.ResponseTemplateVO;
import com.school.ingredientsservice.VO.Stock;
import com.school.ingredientsservice.entity.Ingredient;
import com.school.ingredientsservice.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private static List<Ingredient> list = new ArrayList<>();

    static {
        list.add(new Ingredient(1L, "Moo", 20));
        list.add(new Ingredient(2L, "Tessa", 12));

    }

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Ingredient> getAllIngredientsInOrder() {
        return ingredientRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredientById(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }

    public void addIngredient(){

    }

    public Ingredient findIngredientById(Long ingredientId) {
        return ingredientRepository.findByIngredientId(ingredientId);
    }

    //update the stock
    public void updateIngredient(Ingredient ingredient, Long ingredientId) {

       getAllIngredients().stream().map(i -> {
           if(i.getIngredientId()==ingredientId)
           {
               i.setAmount(ingredient.getAmount());
           }
           return i;
       });
    }

//    //update the stock
//    public Ingredient updateIngredient(Ingredient ingredient, Long ingredientId) {
//        findIngredientById(ingredientId);
//
//        ingredient.setAmount(ingredient.getAmount());
//        final Ingredient updateIngredient = ingredientRepository.save(ingredient);
//        return updateIngredient;
//    }
}
