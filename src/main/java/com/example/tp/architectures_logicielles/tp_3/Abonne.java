package com.example.tp.architectures_logicielles.tp_3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

// Abonné JavaBean
public class Abonne implements Serializable {
    private String nom;
    private String prenom;
    private String email;
    private String centreInteret;
    private PropertyChangeSupport support;

    public Abonne() {
        support = new PropertyChangeSupport(this);
    }

    // Getters et Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        support.firePropertyChange("email", oldEmail, email);
    }

    public String getCentreInteret() {
        return centreInteret;
    }

    public void setCentreInteret(String centreInteret) {
        String oldCentreInteret = this.centreInteret;
        this.centreInteret = centreInteret;
        support.firePropertyChange("centreInteret", oldCentreInteret, centreInteret);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
