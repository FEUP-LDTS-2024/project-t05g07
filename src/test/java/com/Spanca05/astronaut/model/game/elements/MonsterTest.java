package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.strategy.HostileStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterTest {

    @Test
    public void execute() throws Exception {
        Monster monster = new Monster(0,0);
        HostileStrategy strategy = Mockito.mock(HostileStrategy.class);
        monster.setStrategy(strategy);

        Arena arena = Mockito.mock(Arena.class);

        monster.execute(arena, GUI.ACTION.LEFT, 1000);
        Mockito.verify(strategy).step(arena, monster, GUI.ACTION.LEFT, 1000);

    }
}
