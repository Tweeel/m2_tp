package com.example.tp.architectures_logicielles.tp_2.exo1.models;

public class Composant {
    String nom;
    Boolean isWritable;
    Boolean isReadable;
    Repertoire parent;

    public Composant(String nom, Boolean isWritable, Boolean isReadable, Repertoire parent) {
        this.nom = nom;
        this.isWritable = isWritable;
        this.isReadable = isReadable;
        this.parent = parent;
    }

    public String setName(String nom) {
        return this.nom = nom;
    }

    public Composant getParent() {
        return parent;
    }

    public void delete() {
        parent.composants.remove(this);
    }
}
