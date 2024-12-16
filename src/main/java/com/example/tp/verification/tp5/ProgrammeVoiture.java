package com.example.tp.verification.tp5;

import java.util.List;

public class ProgrammeVoiture{
    // Objet persistance qui sera lié par le principe d'injection de dépendances 
    private IPersistanceModeleVoiture persistance; 
  
    // TODO: Méthodes à tester
    /** 
     * Rechercher une liste de modèles en fonction de la marque 
     * @param marque: String
     * @return List<ModeleVoiture> tous les modèles en base appartenant à cette marque 
     */ 
    public List<ModeleVoiture> rechercherVoitureParMarque(String marque){
        CritereRerchercheModeleVoiture critere = new CritereRerchercheModeleVoiture();
        critere.setMarqueModele(marque); 
        return persistance.searchModeleVoiture(critere); 
    } 
  
    /** 
     * Rechercher un modèle de voiture via son id en base 
     * @param id: Long
     * @return ModeleVoiture résultat correspondant à la recherche 
     */ 
    public ModeleVoiture rechercherVoitureParId(Long id){ 
        try { 
            return persistance.searchModeleVoitureById(id); 
        } catch (TooMuchResultException e){ 
            System.out.println("Trop de résultats avec le même id, revoyez la structure de votre table !");
            return null; 
        } 
    } 
  
    /** 
     * Enregistrer un modèle valorisé à partir d'un formulaire de création/modification 
     * Doit mettre à jour en base le modèle ou l'ajouter dans le cas ou il n'existe pas 
     * @param modele: ModeleVoiture
     */ 
    public boolean enregisterModeleVoiture(ModeleVoiture modele){
        try{
            if (null != modele.getId()){
                return persistance.updateModeleVoiture(modele);
            } else {
                return persistance.addModeleVoiture(modele);
            }
        } catch (ErreurPersistance e){
            System.out.println ("Erreur : " + e.getMessage());
            return false;
        } 
    } 
  
    /** Getters et setters */ 
    public IPersistanceModeleVoiture getPersistance() { 
        return persistance; 
    } 
  
    public void setPersistance(IPersistanceModeleVoiture persistance) { 
        this.persistance = persistance; 
    } 
}