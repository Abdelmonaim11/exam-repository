package com.example.examtest.metier;

import com.example.examtest.entities.Repas;

import java.util.List;

public interface RepasDao {
    void saveRepas(Repas repas);
    List<Repas> getAll();
}
