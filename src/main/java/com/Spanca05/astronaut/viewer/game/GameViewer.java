package com.Spanca05.astronaut.viewer.game;

import java.util.List;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

public class GameViewer extends Viewer<Arena> {
    private final WalletViewer walletViewer;

    public GameViewer(Arena arena) {
        super(arena);
        this.walletViewer = new WalletViewer(arena.getWallet());
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getEndBlock(), new EndBlockViewer());
        drawElements(gui, getModel().getPoints(), new PointViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        //drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElement(gui, getModel().getAstronaut(), new AstronautViewer());
        drawElements(gui, getModel().getStars(),new StarViewer());

        walletViewer.drawElements(gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer, getModel().getCameraPosition());
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        drawElement(gui, element, viewer, getModel().getCameraPosition());
    }

    // This one is called by the above draws.
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer, Position cameraOffSet) {
        viewer.draw(element, gui, cameraOffSet);
    }
}