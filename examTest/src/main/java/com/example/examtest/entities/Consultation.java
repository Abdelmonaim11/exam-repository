package com.example.examtest.entities;

import java.util.Date;

public class Consultation {
    private int id_consultation;
    private Date date_consultation;
private int id_patient;
private int id_medecin;

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public Consultation(int id_consultation, Date date_consultation) {
        this.id_consultation = id_consultation;
        this.date_consultation = date_consultation;
    }

    public Consultation() {
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }
}
