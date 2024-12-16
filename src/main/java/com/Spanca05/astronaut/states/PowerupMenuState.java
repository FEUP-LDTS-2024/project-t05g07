package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.menu.PowerupMenuController;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.menu.PowerupMenuViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PowerupMenuState extends State<PowerupMenu> {
    public PowerupMenuState(PowerupMenu model) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(model);
    }

    @Override
    protected Viewer<PowerupMenu> getViewer() {
        return new PowerupMenuViewer(getModel());
    }

    @Override
    protected Controller<PowerupMenu> getController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        return new PowerupMenuController(getModel());
    }
}

