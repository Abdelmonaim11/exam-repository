package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Ingredient;
import com.example.examtest.entities.Repas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepasDaoImpl implements RepasDao{
    @Override
    public void saveRepas(Repas repas) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO repas(id_repas, nom, id_plat) VALUES (?,?,?)"
            );
            stm.setInt(1, repas.getId_repas());
            stm.setString(2, repas.getNom());
            stm.setInt(3, repas.getPlatPrincipal().getId_plat());


            stm.executeUpdate();

            System.out.println("Repas saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Repas> getAll() {
        List<Repas> pepasList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from repas");

            ResultSet res = stm.executeQuery();
            while (res.next()){
                Repas repas = new Repas(
                        res.getInt("id_repas"),
                        res.getString("nom"),
                        res.getInt("id_plat")
                );
                pepasList.add(repas);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pepasList;
    }


}
