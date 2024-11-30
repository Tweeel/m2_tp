package com.example.tp.verification.tp1;

import java.util.HashMap;
import java.util.Map;

public class PorteMonnaie {
    HashMap<String,Integer> contenu;

    public HashMap<String,Integer> getContenu(){
        return contenu;
    }

    public PorteMonnaie(){
        contenu = new HashMap<String,Integer>();
    }

    public void ajouterSomme(SommeArgent sa){
        contenu.merge(sa.getUnite(), sa.getQuantite(), Integer::sum);
    }

    public String toString(){
        String retour = "";
        for(Map.Entry<String,Integer> entry : contenu.entrySet()){
            retour = retour.concat(entry.getKey()).concat(" = ").concat(entry.getValue().toString());
        }
        return retour;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PorteMonnaie) {
            return ((PorteMonnaie) o).getContenu().equals(getContenu());
        } else {
            return false;
        }
    }
}