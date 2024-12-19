package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ImanDecoratorTest {

    @Test
    public void catchPoint() {
        Arena helper = Mockito.mock(Arena.class);
        ImanDecorator id = new ImanDecorator(helper);
        id.catchPoint(new Position(0, 0));
        Mockito.verify(helper, Mockito.times(0)).catchPoint(new Position(-3, -3));
        Mockito.verify(helper, Mockito.times(1)).catchPoint(new Position(-2, -2));
        Mockito.verify(helper, Mockito.times(1)).catchPoint(new Position(0, 0));
        Mockito.verify(helper, Mockito.times(1)).catchPoint(new Position(2, 2));
        Mockito.verify(helper, Mockito.times(0)).catchPoint(new Position(3, 3));
    }
}
