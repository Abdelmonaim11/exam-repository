package com.example.examtest.metier;

import com.example.examtest.entities.Commande;

public interface ICommandeDAO {
    void saveCommande(Commande commande);
    void deleteCommande(int id);
    void addRepasCommende(int idC, int idR);
}
