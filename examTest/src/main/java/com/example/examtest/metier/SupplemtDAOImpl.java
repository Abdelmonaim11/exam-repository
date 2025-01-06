package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Supplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplemtDAOImpl implements SupplementDAO{
    @Override
    public void saveSupplemt(Supplement supplement) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO supplement (id_supplement, nom, prix, id_repas) VALUES (?, ?, ?, ?)"
            );
            stm.setInt(1, supplement.getId_supplement());
            stm.setString(2, supplement.getNom());
            stm.setDouble(3, supplement.getPrix());
            stm.setInt(4, supplement.getId_repas());
            stm.executeUpdate();

            System.out.println("Supplement saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletSupplement(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM supplement WHERE id_supplement = ?"
            );
            stm.setInt(1, id);
            stm.executeUpdate();

            System.out.println("Supplement deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSupplement(Supplement supplement) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "UPDATE supplement SET nom = ?, prix = ? WHERE id_supplement = ?"
            );
            stm.setString(1, supplement.getNom());
            stm.setDouble(2, supplement.getPrix());
            stm.setInt(3, supplement.getId_supplement());
            stm.executeUpdate();

            System.out.println("Supplement updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Supplement> getAllSupplement() {
        List<Supplement> supplements = new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM supplement");

            while (rs.next()) {
                Supplement supplement = new Supplement(
                        rs.getInt("id_supplement"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("id_repas")
                );
                supplements.add(supplement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplements;
    }
}
