package com.example.tp.architectures_logicielles.tp_3;

import java.util.ArrayList;
import java.util.List;

// Agence de Presse (Subject)
public class AgencePresse {
    private List<Observer> observers;
    private List<Article> articles;

    public AgencePresse() {
        this.observers = new ArrayList<>();
        this.articles = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void publierArticle(Article article) {
        articles.add(article);
        notifyObservers(article);
    }

    private void notifyObservers(Article article) {
        for (Observer observer : observers) {
            observer.update(article);
        }
    }
}