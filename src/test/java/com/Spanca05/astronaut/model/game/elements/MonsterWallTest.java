package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.strategy.HostileStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterWallTest {

    @Test
    public void execute() throws Exception {
        MonsterWall monsterWall = new MonsterWall(0,0);
        HostileStrategy strategy = Mockito.mock(HostileStrategy.class);
        monsterWall.setStrategy(strategy);

        Arena arena = Mockito.mock(Arena.class);

        monsterWall.execute(arena, GUI.ACTION.LEFT, 1000);
        Mockito.verify(strategy, Mockito.times(1)).step(arena, monsterWall, GUI.ACTION.LEFT, 1000);

    }
}
