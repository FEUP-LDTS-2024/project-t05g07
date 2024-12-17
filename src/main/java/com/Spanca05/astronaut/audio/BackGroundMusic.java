package com.Spanca05.astronaut.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class BackGroundMusic {
    Clip clip;

    public BackGroundMusic(String musicFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL musicURL = getClass().getResource("/sounds/" + musicFile);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicURL);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void playLoop() {
        if(clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stop() {
        if(clip != null && clip.isRunning())
            clip.stop();
    }

    public void setVolume(float value) {
        if(clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            value = Math.max(volume.getMinimum(), Math.min(value, volume.getMaximum()));
            volume.setValue(value);
        }
    }
}
