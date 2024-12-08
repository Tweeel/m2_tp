package com.example.tp.architectures_logicielles.tp_3;

// Classe AbonneObserver
public class AbonneObserver implements Observer {
    private Abonne abonne;

    public AbonneObserver(Abonne abonne) {
        this.abonne = abonne;
    }

    @Override
    public void update(Article article) {
        if (article.getCategorie().equals(abonne.getCentreInteret())) {
            System.out.println("Notification envoyée à " + abonne.getEmail() +
                    " pour l'article: " + article.getTitre());
        }
    }
}