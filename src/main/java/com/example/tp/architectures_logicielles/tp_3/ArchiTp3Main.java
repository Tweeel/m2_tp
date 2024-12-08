package com.example.tp.architectures_logicielles.tp_3;

// Example d'utilisation
public class ArchiTp3Main {
    public static void main(String[] args) {
        // Création de l'agence
        AgencePresse agence = new AgencePresse();

        // Création d'abonnés
        Abonne abonne1 = new Abonne();
        abonne1.setNom("Dupont");
        abonne1.setPrenom("Jean");
        abonne1.setEmail("jean.dupont@email.com");
        abonne1.setCentreInteret("sport");

        Abonne abonne2 = new Abonne();
        abonne2.setNom("Martin");
        abonne2.setPrenom("Marie");
        abonne2.setEmail("marie.martin@email.com");
        abonne2.setCentreInteret("politique");

        // Création des observers
        AbonneObserver observer1 = new AbonneObserver(abonne1);
        AbonneObserver observer2 = new AbonneObserver(abonne2);

        // Ajout des observers à l'agence
        agence.addObserver(observer1);
        agence.addObserver(observer2);

        // Publication d'articles
        Article articleSport = new Article(
                "Finale de la Coupe du Monde",
                "Contenu de l'article sport...",
                "sport"
        );

        Article articlePolitique = new Article(
                "Élections présidentielles",
                "Contenu de l'article politique...",
                "politique"
        );

        agence.publierArticle(articleSport);
        agence.publierArticle(articlePolitique);
    }
}