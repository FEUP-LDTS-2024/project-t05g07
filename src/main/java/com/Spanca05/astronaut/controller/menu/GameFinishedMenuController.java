package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.audio.SoundEffect;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.LoaderArenaBuilder;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.MenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameFinishedMenuController extends Controller<GameFinishedMenu> {
    private final SoundEffect clickSound;

    public GameFinishedMenuController(GameFinishedMenu gameFinishedMenu) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(gameFinishedMenu);

        clickSound = new SoundEffect("click.wav");
        clickSound.setVolume(0.0f);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(action == GUI.ACTION.SELECT) {
            clickSound.play();
            if(getModel().isSelectedExit()); {
                getModel().stopMusic();
                game.setState(new MenuState(new Menu()));
            }
        }
    }
}
