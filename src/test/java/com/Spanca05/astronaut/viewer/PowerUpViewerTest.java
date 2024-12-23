package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import com.Spanca05.astronaut.viewer.game.PowerUpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PowerUpViewerTest {
    private PowerUpViewer powerUpViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Iman iman;
    private Escudo shield;
    private BonusCoins bonus;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        iman= mock(Iman.class);
        shield= mock(Escudo.class);
        bonus = mock(BonusCoins.class);
        powerUpViewer= new PowerUpViewer();
    }

    @Test
    public void testUpdateTrue() {
        powerUpViewer.powerColor =1;
        powerUpViewer.frameCount = 8;
        powerUpViewer.update();
        assertEquals(2, powerUpViewer.powerColor);
    }

    @Test
    public void testUpdateTrueSwitch() {
        powerUpViewer.powerColor =2;
        powerUpViewer.frameCount = 8;
        powerUpViewer.update();
        assertEquals(1, powerUpViewer.powerColor);
    }

    @Test
    public void testUpdateFalse() {
        powerUpViewer.powerColor =1;
        powerUpViewer.frameCount = 0;
        powerUpViewer.update();
        assertEquals(1, powerUpViewer.powerColor);
    }

    @Test
    public void testDrawPowerUpIman() {
        Position powerPositionMock = mock(Position.class);
        when(iman.getPosition()).thenReturn(powerPositionMock);
        when(powerPositionMock.minus(cameraOffSetMock)).thenReturn(powerPositionMock);

        powerUpViewer.draw(iman, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawIman(powerPositionMock, powerUpViewer.powerColor);
    }
    @Test
    public void testDrawPowerUpShield() {
        Position powerPositionMock = mock(Position.class);
        when(shield.getPosition()).thenReturn(powerPositionMock);
        when(powerPositionMock.minus(cameraOffSetMock)).thenReturn(powerPositionMock);

        powerUpViewer.draw(shield, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawSheild(powerPositionMock, powerUpViewer.powerColor);
    }
    @Test
    public void testDrawPowerUpBonus() {
        Position powerPositionMock = mock(Position.class);
        when(bonus.getPosition()).thenReturn(powerPositionMock);
        when(powerPositionMock.minus(cameraOffSetMock)).thenReturn(powerPositionMock);

        powerUpViewer.draw(bonus, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawDoubleCoins(powerPositionMock, powerUpViewer.powerColor);
    }
}
