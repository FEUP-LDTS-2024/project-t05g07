package com.Spanca05.astronaut.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

import static java.lang.Thread.sleep;

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

    public void playInNewThread() {
        new Thread(() -> {
            try {
                clip.setFramePosition(0);
                clip.start();

                Thread.sleep((long) (clip.getMicrosecondLength() / 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        if(clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void setVolume(float value) {
        if(clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            value = Math.max(volume.getMinimum(), Math.min(value, volume.getMaximum()));
            volume.setValue(value);
        }
    }

}
