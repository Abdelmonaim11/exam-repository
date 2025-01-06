package com.example.examtest.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Commande {
    private int id_commande;
    private Date date;
    private Client client;
    private List<Repas> repas;
    private double total;
    public Commande(Client client, List<Repas> repas) {
        this.client = client;
        this.repas = repas;
        this.date = new Date();
        this.total = calculerTotal();
    }

    // Méthodes
    public double calculerTotal() {
        return repas.stream().mapToDouble(Repas::calculerTotal).sum();
    }
    public String genererTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("Bienvenue ").append(client.getNom()).append("\n");
        ticket.append("-------------------TICKET-------------------\n");
        ticket.append("Nom: ").append(client.getNom()).append("\n\n");
        ticket.append("nombre de repas: ").append(repas.size()).append("\n");

        int repasIndex = 1;
        for (Repas r : repas) {
            ticket.append("Repas N°:").append(repasIndex++).append(" ").append(r.getPlatPrincipal().getNom()).append("\n");
            ticket.append("Ingrédients:\n");
            for (Map.Entry<Ingredient, Integer> entry : r.getIngredients().entrySet()) {
                ticket.append(entry.getKey().getNom()).append(": ").append(entry.getValue()).append(" gramme\n");
            }
            ticket.append("Suppléments:\n");
            for (Supplement s : r.getSupplements()) {
                ticket.append(s.getNom()).append(" ").append(s.getPrix()).append("\n");
            }
            ticket.append("******\n");
        }

        ticket.append("-------Total:").append(total).append("\n");
        return ticket.toString();
    }

    public int getId_commande() {
        return id_commande;
    }

    public Commande(int id_commande, Date date, Client client) {
        this.id_commande = id_commande;
        this.date = date;
        this.client = client;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
