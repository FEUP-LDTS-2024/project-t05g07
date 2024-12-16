package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.menu.GameFinishedMenuController;
import com.Spanca05.astronaut.controller.menu.LevelCompletedMenuController;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.menu.GameFinishedMenuViewer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameFinishedMenuState  extends State<GameFinishedMenu> {
    public GameFinishedMenuState(GameFinishedMenu model) throws UnsupportedAudioFileException, LineUnavailableException, IOException { super(model); }

    @Override
    protected Viewer<GameFinishedMenu> getViewer() {return new GameFinishedMenuViewer(getModel());}

    @Override
    protected Controller<GameFinishedMenu> getController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {return new GameFinishedMenuController(getModel());}

}
