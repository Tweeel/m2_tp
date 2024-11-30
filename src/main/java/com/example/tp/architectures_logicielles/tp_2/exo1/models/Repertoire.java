package com.example.tp.architectures_logicielles.tp_2.exo1.models;

import java.util.Collections;
import java.util.List;

public class Repertoire extends Composant {

    List<Composant> composants = Collections.emptyList();

    public Repertoire(String nom, Boolean isWritable, Boolean isReadable, Repertoire parent) {
        super(nom, isWritable, isReadable, parent);
    }

    public List<Composant> lister() {
        return composants;
    }

    public Repertoire cd(String nom) {
        return composants.stream()
                .filter(composant -> composant.nom.equals(nom))
                .map(composant -> (Repertoire) composant)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete() {
        if (parent != null) {
            composants.forEach(Composant::delete);
            super.delete();
        }
    }
}
