package com.example.examtest.entities;

public class PlatPrincipal {
    private int id_plat;
    private String nom;
    private double prix;

    // Constructeur
    public PlatPrincipal(int id_plat, String nom, double prix) {
        this.id_plat = id_plat;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters et Setters
    public double getPrix() { return prix; }
    public String getNom() { return nom; }

    public void setId_plat(int id_plat) {
        this.id_plat = id_plat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId_plat() {
        return id_plat;
    }
}
