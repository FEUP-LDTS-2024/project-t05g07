package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Coin;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusCoinsDecoratorTest {

    @Test
    public void catchPoint() throws Exception {
        Arena helper = Mockito.spy(new Arena(10,10, 1));

        List<Point> points = new ArrayList<>();
        Point p1 = new Point(0,0);
        points.add(p1);

        helper.setPoints(points);

        Wallet wallet = new Wallet();
        int previousTotal = wallet.getTotal();

        BonusCoinsDecorator id = new BonusCoinsDecorator(helper);
        id.catchPoint(p1.getPosition());

        Mockito.verify(helper, Mockito.times(1)).catchPoint(p1.getPosition());
        assertEquals(previousTotal + 5, wallet.getTotal());
    }

    @Test
    public void catchCoin() throws Exception {
        Arena helper = Mockito.spy(new Arena(10,10, 1));

        List<Point> points = new ArrayList<>();
        Coin c1 = new Coin(0,0);
        points.add(c1);

        helper.setPoints(points);

        Wallet wallet = new Wallet();
        int previousTotal = wallet.getTotal();

        BonusCoinsDecorator id = new BonusCoinsDecorator(helper);
        id.catchPoint(c1.getPosition());

        Mockito.verify(helper, Mockito.times(1)).catchPoint(c1.getPosition());
        assertEquals(previousTotal + 50, wallet.getTotal());
    }

    @Test
    public void catchPowerup() throws Exception {
        Arena helper = Mockito.spy(new Arena(10,10, 1));

        List<Point> points = new ArrayList<>();
        Powerup p1 = new Iman(0,0);
        Powerup p2 = new Escudo(1,1);
        Powerup p3 = new BonusCoins(2,2);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        helper.setPoints(points);

        Wallet wallet = new Wallet();
        int previousTotal = wallet.getTotal();

        BonusCoinsDecorator id = new BonusCoinsDecorator(helper);
        id.catchPoint(p1.getPosition());
        id.catchPoint(p2.getPosition());
        id.catchPoint(p3.getPosition());

        Mockito.verify(helper, Mockito.times(1)).catchPoint(p1.getPosition());
        assertEquals(previousTotal, wallet.getTotal());
    }
}
