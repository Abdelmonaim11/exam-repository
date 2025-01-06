package com.example.examtest.entities;

import java.util.List;

public class Client {
    private int id_client;
    private String nom, prenom,adresse, tel, email;
    private List<Commande> clientCommande;


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Commande> getClientCommande() {
        return clientCommande;
    }

    public void setClientCommande(List<Commande> clientCommande) {
        this.clientCommande = clientCommande;
    }

    public Client(int id_client, String nom, String prenom, String adresse, String tel, String email) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public Client() {
    }
}
