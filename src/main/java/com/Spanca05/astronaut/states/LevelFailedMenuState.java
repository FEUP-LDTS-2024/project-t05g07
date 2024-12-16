package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.menu.LevelFailedMenuController;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.menu.LevelFailedMenuViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LevelFailedMenuState extends State<LevelFailedMenu> {
    public LevelFailedMenuState(LevelFailedMenu model) throws UnsupportedAudioFileException, LineUnavailableException, IOException { super(model); }

    @Override
    protected Viewer<LevelFailedMenu> getViewer() {return new LevelFailedMenuViewer(getModel());}

    @Override
    protected Controller<LevelFailedMenu> getController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {return new LevelFailedMenuController(getModel());}
}
