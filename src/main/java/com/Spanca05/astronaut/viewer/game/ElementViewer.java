package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui, Position cameraOffSet);
}
