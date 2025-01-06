package com.example.examtest.metier;

import com.example.examtest.entities.Supplement;

import java.util.List;

public interface SupplementDAO {
    void saveSupplemt(Supplement supplement);
    void deletSupplement(int id);
    void updateSupplement(Supplement supplement);
    List<Supplement> getAllSupplement();
}
