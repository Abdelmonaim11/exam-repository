package com.example.examtest.metier;



import com.example.examtest.dao.SingletonConnection;
import com.example.examtest.entities.Consultation;
import com.example.examtest.entities.Medecin;
import com.example.examtest.entities.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ICabinetImpl implements ICabinetMetier{
    @Override
    public List<Patient> getAllPatient() {
        List<Patient> patientList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from patient");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Patient patient = new Patient(
                        res.getInt("id_patient"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("cin"),
                        res.getString("telephone"),
                        res.getString("email"),
                        res.getDate("date_naissance")

                );

                patientList.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patientList;
    }

    @Override
    public List<Patient> searchByKeyword(String keyword) {
        List<Patient> patientList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from patient where nom like ?");
            stm.setString(1,"%"+keyword+"%");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Patient patient = new Patient(
                        res.getInt("id_patient"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("cin"),
                        res.getString("telephon"),
                        res.getString("email"),
                        res.getDate("date_naissance")
                );
                patientList.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patientList;
    }

    @Override
    public void savePatient(Patient patient) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO patient(id_patient, nom, prenom, cin, telephone, email, date_naissance) VALUES (?,?,?,?,?,?,?)"
            );
            stm.setInt(1, patient.getId_patient());
            stm.setString(2, patient.getNom());
            stm.setString(3, patient.getPrenom());
            stm.setString(4, patient.getCin());
            stm.setString(5, patient.getTelephone());
            stm.setString(6, patient.getEmail());
            stm.setDate(7, new Date(patient.getDate_naissance().getTime()));
            stm.executeUpdate();

            System.out.println("Patient saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from patient where id_patient = ?");
            stm.setInt(1,id);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> consultationByPatient(int id_patient) {
        List<Consultation> consultationsById = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from consultation c inner join patient p on c.id_patient = p.id_patient");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Consultation consultation = new Consultation(
                        res.getInt("id_consultation"),
                        res.getDate("date_consultation")

                );
                consultationsById.add(consultation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return consultationsById;
    }

    @Override
    public List<Medecin> getAllMedecin() {
        List<Medecin> medecinList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from medecin");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Medecin medecin = new Medecin(
                        res.getInt("id_medecin"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getString("tel")

                );

                medecinList.add(medecin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medecinList;
    }

    @Override
    public void saveMedecin(Medecin medecin) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("insert into medecin(id_medecin,nom,prenom,email,tel) values (?,?,?,?,?)");
            stm.setInt(1,medecin.getId_medecin());
            stm.setString(2,medecin.getNom());
            stm.setString(3,medecin.getPrenom());
            stm.setString(4,medecin.getEmail());
            stm.setString(5, medecin.getTel());
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedecin(Medecin medecin) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE medecin SET nom = ?,prenom = ?,email=?, tel=? WHERE id_medecin = ?");
            stm.setString(1,medecin.getNom());
            stm.setString(2,medecin.getPrenom());
            stm.setString(3, medecin.getEmail());
            stm.setString(4, medecin.getTel());
            stm.setInt(5,medecin.getId_medecin());
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedecin(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from medecin where id_medecin = ?");
            stm.setInt(1,id);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> consultationByMedecin(int id_medecin) {
        List<Consultation> consultationsById = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from consultation c inner join medecin m on c.id_medecin = m.id_medecin");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Consultation consultation = new Consultation(
                        res.getInt("id_consultation"),
                        res.getDate("date_consultation")

                );
                consultationsById.add(consultation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return consultationsById;
    }

    @Override
    public void saveConsultation(Consultation consultation, int id_patient, int id_medecin) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("insert into consultation(id_consultation,date_consultation,id_patient,id_medecin) values (?,?,?,?)");
            stm.setInt(1,consultation.getId_consultation());
            stm.setDate(2,new Date(consultation.getDate_consultation().getTime()));
            stm.setInt(3,id_patient);
            stm.setInt(4,id_medecin);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> getAllConsultation() {
        List<Consultation> consultationList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from consultation");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                Consultation consultation = new Consultation(
                        res.getInt("id_consultation"),
                        res.getDate("date_consultation")

                );
                consultation.setId_medecin(res.getInt("id_medecin"));
                consultation.setId_patient(res.getInt("id_patient"));

                consultationList.add(consultation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return consultationList;
    }

    @Override
    public void deleteConsultation(int id_consl) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from consultation where id_consultation = ?");
            stm.setInt(1,id_consl);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
