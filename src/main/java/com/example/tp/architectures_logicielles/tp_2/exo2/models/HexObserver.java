package com.example.tp.architectures_logicielles.tp_2.exo2.models;

import com.example.tp.architectures_logicielles.tp_2.exo2.interfaces.IObserver;

public class HexObserver implements IObserver {
    private Input input;

    public HexObserver(Input input) {
        this.input = input;
    }

    @Override
    public void update() {
        System.out.println("Hex: " + Integer.toHexString(Integer.parseInt(input.getValue())));
    }
}
