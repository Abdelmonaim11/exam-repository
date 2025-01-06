package com.example.examtest.metier;

import com.example.examtest.entities.Client;

import java.util.List;

public interface IClientDAO {
    void saveClient(Client client);
    List<Client> getAllClient();
    void deleteClient(int id);
    void updateClient(Client client);
}
