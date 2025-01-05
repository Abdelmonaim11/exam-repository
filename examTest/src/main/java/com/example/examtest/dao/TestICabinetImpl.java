package com.example.examtest.dao;

import com.example.examtest.entities.Consultation;
import com.example.examtest.entities.Medecin;
import com.example.examtest.entities.Patient;
import com.example.examtest.metier.ICabinetImpl;

import java.util.List;


public class TestICabinetImpl {
    public static void main(String[] args) {
        ICabinetImpl iCabinet = new ICabinetImpl();
//         iCabinet.saveMedecin(new Medecin(1, "Ahdoud", "Monaim", "monaim11@gmail.com", "0723987453"));
//        Patient patient1 = new Patient(1,"Ettahiri", "PF235452", "Ali", "0731423234", "ali.ett1@gmail.com", java.sql.Date.valueOf("2014-02-15"));
//        iCabinet.savePatient(patient1);
//        Patient patient = new Patient(2,"Ghazoui", "PA3535511", "Amine", "0634456461342", "amine11@gmail.com", java.sql.Date.valueOf("2010-09-24"));
//        iCabinet.savePatient(patient);
        List<Patient> patientList = iCabinet.getAllPatient();
        patientList.forEach(p->{
            System.out.println(p.getNom());
        });
        List<Consultation> consultations = iCabinet.getAllConsultation();
        for (Consultation c : consultations) {
            System.out.println(c.getId_consultation());
            System.out.println(c.getDate_consultation());
            System.out.println(c.getId_patient());
            System.out.println(c.getId_medecin());
        }
    }
}
