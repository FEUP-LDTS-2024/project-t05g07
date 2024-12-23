package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.model.game.elements.Coin;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.viewer.game.CoinViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class CoinViewerTest {

    private CoinViewer coinViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Coin coinMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        coinMock = mock(Coin.class);

        coinViewer = new CoinViewer();
    }

    @Test
    public void testUpdateTrue() {
        coinViewer.frameCount = 11;
        coinViewer.update();
        assertEquals(2, coinViewer.coinColor);
    }

    @Test
    public void testUpdateTrueColor() {
        coinViewer.frameCount = 11;
        coinViewer.coinColor=2;
        coinViewer.update();
        assertEquals(1, coinViewer.coinColor);
    }

    @Test
    public void testUpdateSwitchesFalse() {
        coinViewer.frameCount =0 ;
        coinViewer.update();
        assertEquals(1, coinViewer.coinColor);
    }

    @Test
    public void testDrawCoin() {
        Position coinPositionMock = mock(Position.class);
        when(coinMock.getPosition()).thenReturn(coinPositionMock);
        when(coinPositionMock.minus(cameraOffSetMock)).thenReturn(coinPositionMock);

        coinViewer.draw(coinMock, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawCoin(coinPositionMock, coinViewer.coinColor);
    }
}

