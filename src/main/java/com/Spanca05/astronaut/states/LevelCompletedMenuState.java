package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.menu.LevelCompletedMenuController;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.menu.LevelCompletedMenuViewer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LevelCompletedMenuState extends State<LevelCompletedMenu> {
    public LevelCompletedMenuState(LevelCompletedMenu model) throws UnsupportedAudioFileException, LineUnavailableException, IOException { super(model); }

    @Override
    protected Viewer<LevelCompletedMenu> getViewer() {return new LevelCompletedMenuViewer(getModel());}

    @Override
    protected Controller<LevelCompletedMenu> getController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {return new LevelCompletedMenuController(getModel());}

}
