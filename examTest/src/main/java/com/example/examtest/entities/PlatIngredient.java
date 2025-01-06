package com.example.examtest.entities;

public class PlatIngredient {
    private int id_ingredient;
    private int id_plat;

    public PlatIngredient(int id_ingredient, int id_plat) {
        this.id_ingredient = id_ingredient;
        this.id_plat = id_plat;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getId_plat() {
        return id_plat;
    }

    public void setId_plat(int id_plat) {
        this.id_plat = id_plat;
    }
}
