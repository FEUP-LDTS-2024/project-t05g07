package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.audio.SoundEffect;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.LoaderArenaBuilder;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.PowerupMenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuController extends Controller<Menu> {
    private final SoundEffect clickSound;

    public MenuController(Menu menu) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(menu);
        clickSound = new SoundEffect("click.wav");
        clickSound.setVolume(0.0f);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                clickSound.play();
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedPowerups()) game.setState(new PowerupMenuState(new PowerupMenu()));
                if (getModel().isSelectedStart()) {
                    getModel().stopMusic();
                    game.setState(new GameState(new LoaderArenaBuilder(getModel().getCurrentLevel()).createArena()));
                }
        }
    }
}
