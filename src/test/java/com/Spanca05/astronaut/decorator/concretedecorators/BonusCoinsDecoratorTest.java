package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Point;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusCoinsDecoratorTest {

    /*@Test
    public void catchPoint() {
        Power helper = Mockito.mock(Arena.class);
        BonusCoinsDecorator id = new BonusCoinsDecorator(helper);

        assertEquals(id.getPoints(), helper.getPoints());

        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);

        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p4);

        Mockito.when(helper.getPoints()).thenReturn(points);

        List<Point> expected = new ArrayList<>(points);

        id.catchPoint(p1.getPosition());
        expected.remove(p1);
        assertEquals(id.getPoints(), expected);

        id.catchPoint(p2.getPosition());
        expected.remove(p2);
        assertEquals(id.getPoints(), helper.getPoints());

        id.catchPoint(p3.getPosition());
        expected.remove(p3);
        assertEquals(id.getPoints(), helper.getPoints());
    }*/

    /*@Test
    public void amount() {
        Arena helper = Mockito.mock(Arena.class);
        BonusCoinsDecorator id = new BonusCoinsDecorator(helper);
        Point p1 = new Point(0,0);
        id.amount(p1);
        Mockito.verify(helper, Mockito.times(1)).amount(p1);
        assertEquals(helper.amount(p1) * 5, id.amount(p1));
    }*/
}
