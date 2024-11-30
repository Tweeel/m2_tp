package com.example.tp.architectures_logicielles.tp_2.exo1.models;

public class Fichier extends Composant {

    public Fichier(String nom, Boolean isWritable, Boolean isReadable, Repertoire parent) {
        super(nom, isWritable, isReadable, parent);
    }

    @Override
    public void delete() {
        super.delete();
    }
}
