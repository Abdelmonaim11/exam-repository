package com.example.examtest.metier;

import com.example.examtest.entities.PlatPrincipal;

import java.util.List;

public interface IPlatPrincipalDAO {
    void savePlat(PlatPrincipal platPrincipal);
    void deletePlat(int id);
    List<PlatPrincipal> getAllPlat();
    void updatePlat(PlatPrincipal platPrincipal);
}
