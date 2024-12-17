package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.audio.SoundEffect;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.states.MenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PowerupMenuController extends Controller<PowerupMenu> {
    private final SoundEffect clickSound;

    public PowerupMenuController(PowerupMenu powerupMenu) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(powerupMenu);

        clickSound = new SoundEffect("click.wav");
        clickSound.setVolume(0.0f);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action) {
            case QUIT:
                game.setState(new MenuState(new Menu()));
                break;
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                clickSound.play();
                if (getModel().isSelectedEscudo()) getModel().extendEscudoDuration();
                if (getModel().isSelectedBonusCoins()) getModel().extendBonusCoinsDuration();
                if (getModel().isSelectedIman()) getModel().extendImanDuration();
                if (getModel().isSelectedGoBack()) game.setState(new MenuState(new Menu()));
        }
    }
}
