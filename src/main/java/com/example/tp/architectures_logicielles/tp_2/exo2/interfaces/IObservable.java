package com.example.tp.architectures_logicielles.tp_2.exo2.interfaces;

public interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}
