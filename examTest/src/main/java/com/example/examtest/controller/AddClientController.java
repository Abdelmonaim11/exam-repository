package com.example.examtest.controller;

import com.example.examtest.entities.Client;
import com.example.examtest.metier.ClientDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddClientController {
    ClientDaoImpl clientDao = new ClientDaoImpl();

    @FXML
    private TextField adresseClient;

    @FXML
    private TextField emailClient;

    @FXML
    private TextField idClient;

    @FXML
    private TextField nomClient;

    @FXML
    private TextField prenomClient;

    @FXML
    private TextField telClient;

    @FXML
    void addClient(ActionEvent event) {
        Client client = new Client(Integer.parseInt(idClient.getText()),nomClient.getText(), prenomClient.getText(), adresseClient.getText(), telClient.getText(), emailClient.getText());
        clientDao.saveClient(client);
    }

    @FXML
    void cancelUpdatePatient(ActionEvent event) {

    }

}
