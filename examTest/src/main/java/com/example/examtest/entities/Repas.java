package com.example.examtest.entities;

import java.util.List;
import java.util.Map;

public class Repas {
    private int id_repas;
    private String nom;
    private PlatPrincipal platPrincipal;
    private Map<Ingredient, Integer> ingredients;
    private List<Supplement> supplements;
    private double total;
    public Repas(PlatPrincipal platPrincipal, Map<Ingredient, Integer> ingredients, List<Supplement> supplements) {
        this.platPrincipal = platPrincipal;
        this.ingredients = ingredients;
        this.supplements = supplements;
        this.total = calculerTotal();
    }

    public int getId_repas() {
        return id_repas;
    }

    public String getNom() {
        return nom;
    }

    public double getTotal() {
        return total;
    }

    public Repas(int id_repas, String nom, PlatPrincipal platPrincipal) {
        this.id_repas = id_repas;
        this.nom = nom;
        this.platPrincipal = platPrincipal;
    }
    public Repas(int id_repas, String nom, int id_plat) {
        this.id_repas = id_repas;
        this.nom = nom;
        this.platPrincipal.setId_plat(id_plat);
    }
    // Méthodes
    public double calculerTotal() {
        double totalIngredients = ingredients.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrix() * entry.getValue())
                .sum();

        double totalSupplements = supplements.stream()
                .mapToDouble(Supplement::getPrix)
                .sum();

        return platPrincipal.getPrix() + totalIngredients + totalSupplements;
    }

    public PlatPrincipal getPlatPrincipal() { return platPrincipal; }
    public Map<Ingredient, Integer> getIngredients() { return ingredients; }
    public List<Supplement> getSupplements() { return supplements; }
}
