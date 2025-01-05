package com.example.examtest.metier;

import com.example.examtest.entities.Consultation;
import com.example.examtest.entities.Medecin;
import com.example.examtest.entities.Patient;

import java.util.List;

public interface ICabinetMetier {
    //Patient Methods
     List<Patient> getAllPatient();
     List<Patient> searchByKeyword(String keyword);
    void savePatient(Patient patient);
    void deletePatient(int id);
    List<Consultation> consultationByPatient(int id_patient);
    //Medecin Methods
    List<Medecin> getAllMedecin();
    void saveMedecin(Medecin medecin);
    void updateMedecin(Medecin medecin);
    void deleteMedecin(int id);
    List<Consultation> consultationByMedecin(int id_medecin);
    //Consultation Methods
    void saveConsultation(Consultation consultation, int id_patient, int id_medecin);
    List<Consultation> getAllConsultation();
    void deleteConsultation(int id_consl);
}
