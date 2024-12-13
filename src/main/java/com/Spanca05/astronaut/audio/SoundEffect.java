package com.Spanca05.astronaut.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class SoundEffect {
    private Clip clip;

    public SoundEffect(String soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL soundURL = getClass().getResource("/sounds/" + soundFile);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {
        if(clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop() {
        if(clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}
