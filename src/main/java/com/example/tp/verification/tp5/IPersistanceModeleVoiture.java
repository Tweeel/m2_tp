package com.example.tp.verification.tp5;

import java.util.List;

public interface IPersistanceModeleVoiture {
    /** 
     * Rechercher une liste de modèles de voiture en base de données à partir de critères 
     * @param critere: CritereRerchercheModeleVoiture -> critere de recherche
     * @return List<ModeleVoiture> liste de résultats correspondant à la recherche 
     */ 
    public List<ModeleVoiture> searchModeleVoiture(CritereRerchercheModeleVoiture critere);
  
    /** 
     * Rechercher un modèle de voiture via son id en base 
     * @param id: Long
     * @return ModeleVoiture résultat correspondant à la recherche 
     * @throws TooMuchResultException lorsque la recherche correspond à plusieurs résultats 
     */ 
    public ModeleVoiture searchModeleVoitureById(Long id) throws TooMuchResultException;
  
    /** 
     * Persister une instance de ModeleVoiture en base de données 
     * @param modele: ModeleVoiture -> modele instance à persister en base
     * @return boolean true si l'insertion s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean addModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
  
    /** 
     * Mettre à jour une instance de ModeleVoiture en base de données 
     * @param modele: ModeleVoiture -> modele instance à modifier en base
     * @return boolean true si la mise à jour s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean updateModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
  
    /** 
     * Supprimer une instance de ModeleVoiture en base de données 
     * @param modele: ModeleVoiture -> modele instance à supprimer en base
     * @return boolean true si la suppression s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean deleteModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
}