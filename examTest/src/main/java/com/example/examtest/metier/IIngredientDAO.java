package com.example.examtest.metier;

import com.example.examtest.entities.Ingredient;

import java.util.List;

public interface IIngredientDAO {
    void saveIngredient(Ingredient ingredient);
    void deleteIngredient(int id);
    List<Ingredient> getAllIngredient();
    void updateIngredient(Ingredient ingredient);
    void addPlatIngredient(int plat, int ing);
}
