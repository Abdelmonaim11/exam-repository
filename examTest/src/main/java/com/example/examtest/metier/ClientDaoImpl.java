package com.example.examtest.metier;

import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements IClientDAO{
    @Override
    public void saveClient(Client client) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO client(id_client, nom, prenom, adresse, tel, email) VALUES (?,?,?,?,?,?)"
            );
            stm.setInt(1, client.getId_client());
            stm.setString(2, client.getNom());
            stm.setString(3, client.getPrenom());
            stm.setString(4, client.getAdresse());
            stm.setString(5, client.getTel());
            stm.setString(6, client.getEmail());
            stm.executeUpdate();

            System.out.println("Patient saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clientList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from client");

            ResultSet res = stm.executeQuery();
            while (res.next()){
                Client client = new Client(
                        res.getInt("id_client"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("adresse"),
                        res.getString("tel"),
                        res.getString("email")
                );
                clientList.add(client);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public void deleteClient(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from patient where id_client = ?");
            stm.setInt(1,id);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client client) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE client SET nom = ?,prenom = ?,adresse=?, tel=?, email=?  WHERE id_client = ?");
            stm.setString(1,client.getNom());
            stm.setString(2,client.getPrenom());
            stm.setString(3, client.getAdresse());
            stm.setString(4,client.getTel());
            stm.setString(5,client.getEmail());
            stm.setInt(6,client.getId_client());
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
