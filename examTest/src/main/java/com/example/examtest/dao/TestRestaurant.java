package com.example.examtest.dao;

import com.example.examtest.entities.*;
import com.example.examtest.metier.*;

public class TestRestaurant {
    public static void main(String[] args) {
        ClientDaoImpl clientDao = new ClientDaoImpl();
        PlatPrincipalDAOImpl platPrincipalDAO = new PlatPrincipalDAOImpl();
        RepasDaoImpl repasDao = new RepasDaoImpl();
        IIngredientDAOImpl ingredientDAO = new IIngredientDAOImpl();
        SupplemtDAOImpl supplemtDAO = new SupplemtDAOImpl();
     Client client = new Client(1,"Adoud","Monaim", "mohammedia", "073431231","monaim.1@gmail.com");
//        clientDao.saveClient(client);
//        java.sql.Date.valueOf("2010-09-24"))
        CommandeDaoImpl commandeDao = new CommandeDaoImpl();
       Commande commande = new Commande(1,java.sql.Date.valueOf("2010-09-24"),client);
//       commandeDao.saveCommande(commande);
        PlatPrincipal platPrincipal = new PlatPrincipal(1,"Tajine", 60);
//        platPrincipalDAO.savePlat(platPrincipal);
        Repas repas = new Repas(1,"repas tajine", platPrincipal);
//        repasDao.saveRepas(repas);
     //   commandeDao.addRepasCommende(commande.getId_commande(), repas.getId_repas());
        Ingredient ingredient = new Ingredient(1,"Pomme", 6.00,repas.getId_repas());
      //  ingredientDAO.saveIngredient(ingredient);
        PlatIngredient platIngredient = new PlatIngredient(ingredient.getId_ingredient(), platPrincipal.getId_plat());
     //   ingredientDAO.addPlatIngredient(ingredient.getId_ingredient(), platIngredient.getId_plat());
        Supplement supplement = new Supplement(1,"roz", 12.50,repas.getId_repas());
        supplemtDAO.saveSupplemt(supplement);
    }
}
