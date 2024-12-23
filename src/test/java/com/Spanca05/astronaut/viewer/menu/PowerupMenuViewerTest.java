package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.viewer.WalletViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PowerupMenuViewerTest {

    private PowerupMenuViewer powerupMenuViewer;
    private GUI guiMock;
    private PowerupMenu powerupMenuMock;
    private WalletViewer walletViewerMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        powerupMenuMock = mock(PowerupMenu.class);
        walletViewerMock = mock(WalletViewer.class);

        powerupMenuViewer = new PowerupMenuViewer(powerupMenuMock);
        powerupMenuViewer.walletViewer = walletViewerMock;

        when(powerupMenuMock.getShieldPrice()).thenReturn(10);
        when(powerupMenuMock.getBonusPrice()).thenReturn(20);
        when(powerupMenuMock.getImanPrice()).thenReturn(30);
        when(powerupMenuMock.isSelected(0)).thenReturn(true);
        when(powerupMenuMock.isSelected(1)).thenReturn(false);
        when(powerupMenuMock.isSelected(2)).thenReturn(true);
        when(powerupMenuMock.isSelected(3)).thenReturn(false);
    }

    @Test
    public void testDrawElements() throws IOException {
        powerupMenuViewer.drawElements(guiMock);

        verify(guiMock).drawSecondMenu(new Position(0, 0));
        verify(guiMock).drawPricetag(new Position(1, 4));
        verify(guiMock).drawPricetag(new Position(1, 6));
        verify(guiMock).drawPricetag(new Position(1, 8));
        verify(guiMock).drawPrice(new Position(1, 0), 10);
        verify(guiMock).drawPrice(new Position(1, 32), 20);
        verify(guiMock).drawPrice(new Position(1, 64), 30);
        verify(guiMock).drawPower1(new Position(5, 4), true);
        verify(guiMock).drawPower2(new Position(5, 6), false);
        verify(guiMock).drawPower3(new Position(5, 8), true);
        verify(guiMock).drawReturn(new Position(5, 10), false);

        verify(walletViewerMock, times(1)).drawElements(guiMock);
    }
}
