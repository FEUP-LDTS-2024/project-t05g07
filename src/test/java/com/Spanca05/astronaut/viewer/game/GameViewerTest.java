package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.viewer.WalletViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {

    private GameViewer gameViewer;
    private GUI guiMock;
    private Arena arenaMock;
    private PointViewer pointViewerMock;
    private AstronautViewer astronautViewerMock;
    private EndBlockViewer endBlockViewerMock;
    private StarViewer starViewerMock;
    private CoinViewer coinViewerMock;
    private PowerUpViewer powerUpViewerMock;
    private WalletViewer walletViewerMock;

    private Position cameraPositionMock;
    private Astronaut astronautMock;
    private EndBlock endBlockMock;
    private List<Point> pointsMock;
    private List<Coin> coinsMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        arenaMock = mock(Arena.class);
        cameraPositionMock = mock(Position.class);
        astronautMock = mock(Astronaut.class);
        endBlockMock = mock(EndBlock.class);
        pointsMock = Collections.singletonList(mock(Point.class));
        coinsMock = Collections.singletonList(mock(Coin.class));

        pointViewerMock = mock(PointViewer.class);
        astronautViewerMock = mock(AstronautViewer.class);
        endBlockViewerMock = mock(EndBlockViewer.class);
        starViewerMock = mock(StarViewer.class);
        coinViewerMock = mock(CoinViewer.class);
        powerUpViewerMock = mock(PowerUpViewer.class);
        walletViewerMock = mock(WalletViewer.class);

        when(arenaMock.getCameraPosition()).thenReturn(cameraPositionMock);
        when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        when(arenaMock.getEndBlock()).thenReturn(endBlockMock);
        when(arenaMock.getPoints()).thenReturn(pointsMock);
        when(arenaMock.getCoins()).thenReturn(coinsMock);

        gameViewer = new GameViewer(arenaMock);
        gameViewer.pv = pointViewerMock;
        gameViewer.nautav = astronautViewerMock;
        gameViewer.endv = endBlockViewerMock;
        gameViewer.starv = starViewerMock;
        gameViewer.coinv = coinViewerMock;
        gameViewer.powerv = powerUpViewerMock;
        gameViewer.walletViewer = walletViewerMock;
    }

    @Test
    public void testDrawElements() throws IOException {
        gameViewer.drawElements(guiMock);

        verify(pointViewerMock, times(1)).update();
        verify(astronautViewerMock, times(1)).update();
        verify(endBlockViewerMock, times(1)).update();
        verify(starViewerMock, times(1)).update();
        verify(coinViewerMock, times(1)).update();
        verify(powerUpViewerMock, times(1)).update();

        verify(astronautViewerMock, times(1)).draw(astronautMock, guiMock, cameraPositionMock);
        verify(endBlockViewerMock, times(1)).draw(endBlockMock, guiMock, cameraPositionMock);
        verify(pointViewerMock, times(1)).draw(pointsMock.get(0), guiMock, cameraPositionMock);
        verify(coinViewerMock, times(1)).draw(coinsMock.get(0), guiMock, cameraPositionMock);

        verify(walletViewerMock, times(1)).drawElements(guiMock);
    }
}