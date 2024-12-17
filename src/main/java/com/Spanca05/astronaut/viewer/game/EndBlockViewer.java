package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.EndBlock;

public class EndBlockViewer implements ElementViewer<EndBlock> {
    int frameCount = 0;
    int endBlockColor = 1;

    public void update() {
        frameCount++;
        if (frameCount > 15) {
            endBlockColor = endBlockColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }
    @Override
    public void draw(EndBlock endblock, GUI gui, Position cameraOffSet) {
        gui.drawEndBlock(endblock.getPosition().minus(cameraOffSet),endBlockColor);
    }
}
