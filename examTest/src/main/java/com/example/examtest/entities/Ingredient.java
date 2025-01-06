package com.example.examtest.entities;

public class Ingredient {
    private int id_ingredient;
    private String nom;
    private double prix;
    private int id_repas;

    public int getId_repas() {
        return id_repas;
    }

    public Ingredient(int id, String nom, double prix, int id_repas) {
        this.id_ingredient = id;
        this.nom = nom;
        this.prix = prix;
        this.id_repas = id_repas;
    }


    public double getPrix() { return prix; }


    public String getNom() {
        return nom;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }
}

