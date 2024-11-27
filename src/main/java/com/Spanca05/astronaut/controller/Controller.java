package com.Spanca05.astronaut.controller;

//import com.Spanca05.astronaut.Game;
//import com.Spanca05.astronaut.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    //public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
