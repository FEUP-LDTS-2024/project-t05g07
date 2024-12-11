package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        long sTime = System.currentTimeMillis();
        gui.clear();
        System.out.println(System.currentTimeMillis() - sTime);
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}