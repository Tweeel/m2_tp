package com.example.tp.architectures_logicielles.tp_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Liste d'abonnés JavaBean
public class ListeAbonnes implements Serializable {
    private List<Abonne> abonnes;

    public ListeAbonnes() {
        this.abonnes = new ArrayList<>();
    }

    public void ajoutAbonne(Abonne abonne) {
        this.abonnes.add(abonne);
    }

    public void supprimeAbonne(Abonne abonne) {
        this.abonnes.remove(abonne);
    }

    public List<Abonne> getAbonnes() {
        return abonnes;
    }
}