package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.PlatPrincipal;
import com.example.examtest.entities.Supplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlatPrincipalDAOImpl implements IPlatPrincipalDAO{
    @Override
    public void savePlat(PlatPrincipal platPrincipal) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO platprincipal (id_plat, nom, prix) VALUES (?, ?, ?)"
            );
            stm.setInt(1, platPrincipal.getId_plat());
            stm.setString(2, platPrincipal.getNom());
            stm.setDouble(3, platPrincipal.getPrix());
            stm.executeUpdate();

            System.out.println("Plat principal saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlat(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM platprincipal WHERE id_plat = ?"
            );
            stm.setInt(1, id);
            stm.executeUpdate();

            System.out.println("Plat principal deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PlatPrincipal> getAllPlat() {
        List<PlatPrincipal> platPrincipals = new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM platprincipal");

            while (rs.next()) {
                PlatPrincipal platPrincipal = new PlatPrincipal(
                        rs.getInt("id_plat"),
                        rs.getString("nom"),
                        rs.getDouble("prix")
                );
                platPrincipals.add(platPrincipal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return platPrincipals;
    }

    @Override
    public void updatePlat(PlatPrincipal platPrincipal) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "UPDATE platprincipal SET nom = ?, prix = ? WHERE id_plat = ?"
            );
            stm.setString(1, platPrincipal.getNom());
            stm.setDouble(2, platPrincipal.getPrix());
            stm.setInt(3, platPrincipal.getId_plat());
            stm.executeUpdate();

            System.out.println("Plat principal updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
