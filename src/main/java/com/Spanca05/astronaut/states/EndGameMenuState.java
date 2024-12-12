package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.menu.EndGameMenuController;
import com.Spanca05.astronaut.model.menu.EndGameMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.menu.EndGameMenuViewer;

public class EndGameMenuState extends State<EndGameMenu> {
    public EndGameMenuState(EndGameMenu model) { super(model); }

    @Override
    protected Viewer<EndGameMenu> getViewer() {return new EndGameMenuViewer(getModel());}

    @Override
    protected Controller<EndGameMenu> getController() {return new EndGameMenuController(getModel());}
}
