package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Commande;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CommandeDaoImpl implements ICommandeDAO{
    @Override
    public void saveCommande(Commande commande) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO commande(id_commande, date, total, id_client) VALUES (?,?,?,?)"
            );
            stm.setInt(1, commande.getId_commande());
            stm.setDate(2, (Date) commande.getDate());
            stm.setDouble(3, commande.getTotal());
            stm.setInt(4, commande.getClient().getId_client());

            stm.executeUpdate();

            System.out.println("Patient saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCommande(int id) {

    }

    @Override
    public void addRepasCommende(int idC, int idR) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO repascommande(id_commande, id_repas) VALUES (?,?)"
            );
            stm.setInt(1, idC);

            stm.setInt(2, idR);

            stm.executeUpdate();

            System.out.println("Repas Commande saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
