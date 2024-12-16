package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.EndBlock;

public class EndBlockViewer implements ElementViewer<EndBlock> {
    @Override
    public void draw(EndBlock endblock, GUI gui, Position cameraOffSet) {
        gui.drawEndBlock(endblock.getPosition().minus(cameraOffSet));
    }
}
