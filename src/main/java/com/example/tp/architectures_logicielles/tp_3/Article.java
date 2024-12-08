package com.example.tp.architectures_logicielles.tp_3;

// Article
public class Article {
    private String titre;
    private String contenu;
    private String categorie;

    public Article(String titre, String contenu, String categorie) {
        this.titre = titre;
        this.contenu = contenu;
        this.categorie = categorie;
    }

    // Getters
    public String getTitre() { return titre; }
    public String getContenu() { return contenu; }
    public String getCategorie() { return categorie; }
}