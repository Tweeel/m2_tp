package com.example.tp.architectures_logicielles.tp_2.exo2.models;

import com.example.tp.architectures_logicielles.tp_2.exo2.interfaces.IObservable;
import com.example.tp.architectures_logicielles.tp_2.exo2.interfaces.IObserver;

import java.util.List;
import java.util.ListIterator;

public class Input implements IObservable {
    private String value;
    private List<IObserver> observers;

    public Input() {
        this.value = "";
    }

    public void setValue(String value) {
        this.value = value;
        notifyObservers();
    }

    public String getValue() {
        return value;
    }

    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

}
