package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.strategy.HostileStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallTest {

    @Test
    public void execute() throws Exception {
        Wall wall = new Wall(0,0);
        HostileStrategy strategy = Mockito.mock(HostileStrategy.class);

        Arena arena = Mockito.mock(Arena.class);

        wall.execute(arena, GUI.ACTION.LEFT, 1000);
        Mockito.verify(strategy, Mockito.times(0)).step(arena, wall, GUI.ACTION.LEFT, 1000);
    }
}
