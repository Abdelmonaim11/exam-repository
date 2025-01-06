package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Client;
import com.example.examtest.entities.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IIngredientDAOImpl implements IIngredientDAO{

    @Override
    public void saveIngredient(Ingredient ingredient) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO ingredient (id_ingredient, nom, prix,id_repas) VALUES (?, ?, ?,?)"
            );
            stm.setInt(1, ingredient.getId_ingredient());
            stm.setString(2, ingredient.getNom());
            stm.setDouble(3, ingredient.getPrix());
            stm.setInt(4, ingredient.getId_repas());
            stm.executeUpdate();

            System.out.println("Ingredient saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    @Override
    public void deleteIngredient(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM ingredient WHERE id_ingredient = ?"
            );
            stm.setInt(1, id);
            stm.executeUpdate();

            System.out.println("Ingredient deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ingredient> getAllIngredient() {
        List<Ingredient> ingredientList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from ingredient");

            ResultSet res = stm.executeQuery();
            while (res.next()){
                Ingredient ingredient = new Ingredient(
                        res.getInt("id_ingredient"),
                        res.getString("nom"),
                        res.getDouble("prix"),
                        res.getInt("id_repas")

                );
                ingredientList.add(ingredient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ingredientList;
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "UPDATE ingredient SET nom = ?, poids = ? WHERE id = ?"
            );
            stm.setString(1, ingredient.getNom());
            stm.setDouble(2, ingredient.getPrix());
            stm.setInt(3, ingredient.getId_ingredient());
            stm.executeUpdate();

            System.out.println("Ingredient updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPlatIngredient(int plat, int ing) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO ingredientplat (id_ingredient, id_plat) VALUES (?, ?)"
            );
            stm.setInt(1, ing);

            stm.setInt(2, plat);
            stm.executeUpdate();

            System.out.println("platIngredient saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
