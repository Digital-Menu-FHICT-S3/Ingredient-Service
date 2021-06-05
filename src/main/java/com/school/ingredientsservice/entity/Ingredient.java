package com.school.ingredientsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;
    private int amount;
    private String name;

    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Ingredient(String name) {
        this.name = name;
    }
}
