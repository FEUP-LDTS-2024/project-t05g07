package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.GameFinishedMenuState;
import com.Spanca05.astronaut.states.LevelCompletedMenuState;
import com.Spanca05.astronaut.states.LevelFailedMenuState;
import com.Spanca05.astronaut.states.MenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ArenaController extends GameController {
    private final AstronautController astronautController;
    private final MonsterController monsterController;
    private final CameraController cameraController;

    public ArenaController(Arena arena) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(arena);
        this.astronautController = new AstronautController(arena);
        this.monsterController = new MonsterController(arena);
        this.cameraController = new CameraController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action) {
            case QUIT -> game.setState(new MenuState(new Menu(game)));
            case UP, DOWN, RIGHT, LEFT -> {
                if (getModel().getAstronaut().getDirection() == null)
                    getModel().getAstronaut().setDirection(action);
            }
            case null, default -> {
            }
        }

        if (!getModel().getAstronaut().isAlive())
            if(getModel().getAstronaut().isLevelPassed())
                if(getModel().getCurrentLevel() == 8) game.setState(new GameFinishedMenuState(new GameFinishedMenu()));
                else game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(getModel().getCurrentLevel())));
            else game.setState(new LevelFailedMenuState(new LevelFailedMenu(getModel().getCurrentLevel())));

        monsterController.step(game, null, time);
        cameraController.step(game, null, time);
        astronautController.step(game, null, time);
    }
}
