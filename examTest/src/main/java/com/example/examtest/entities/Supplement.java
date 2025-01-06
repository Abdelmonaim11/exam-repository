package com.example.examtest.entities;

public class Supplement {
    private int id_supplement;
    private String nom;
    private double prix;
    private int id_repas;

    // Constructeur
    public Supplement(int id_supplement, String nom, double prix,int id_repas) {
        this.id_supplement = id_supplement;
        this.nom = nom;
        this.prix = prix;
        this.id_repas=id_repas;
    }

    // Getters
    public double getPrix() { return prix; }
    public String getNom() { return nom; }

    public int getId_repas() {
        return id_repas;
    }

    public int getId_supplement() {
        return id_supplement;
    }
}
