package com.example.examtest.controller;

import com.example.examtest.entities.Repas;
import com.example.examtest.metier.RepasDao;
import com.example.examtest.metier.RepasDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectRepas implements Initializable {
    RepasDaoImpl repasDao = new RepasDaoImpl();


    @FXML
    private ComboBox<String> selectRepas;

    @FXML
    void onSelectRepas(ActionEvent event) {

    }
List<Repas> repasList = repasDao.getAll();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repasList.forEach(repas -> {
            selectRepas.getItems().add(repas.getId_repas()+" - "+repas.getNom());
        });
    }
}
