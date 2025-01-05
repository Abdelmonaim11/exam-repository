package com.example.examtest.controller;

import com.example.examtest.entities.Medecin;
import com.example.examtest.metier.ICabinetImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateMedecinController {
    private ICabinetImpl iCabinet = new ICabinetImpl();
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private Medecin medecin;

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
        idMedecin.setText(String.valueOf(medecin.getId_medecin()));
        nomMedecin.setText(medecin.getNom());
        prenomMedecin.setText(medecin.getPrenom());
        emailMedecin.setText(medecin.getEmail());
        telMedecin.setText(medecin.getTel());
        idMedecin.setDisable(true);
    }

    @FXML
    private TextField emailMedecin;

    @FXML
    private TextField idMedecin;

    @FXML
    private TextField nomMedecin;

    @FXML
    private TextField prenomMedecin;

    @FXML
    private TextField telMedecin;

    @FXML
    void cancelUpdateMedecin(ActionEvent event) {

                nomMedecin.setText("");
                prenomMedecin.setText("");
                emailMedecin.setText("");
                telMedecin.setText("");
    }

    @FXML
    void updateMedecin(ActionEvent event) {
        Medecin medecinUpdated = new Medecin(
          Integer.parseInt(idMedecin.getText()),
          nomMedecin.getText(),
          prenomMedecin.getText(),
          emailMedecin.getText(),
          telMedecin.getText()
        );
        iCabinet.updateMedecin(medecinUpdated);
        mainController.refresh();
    }
}
