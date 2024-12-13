package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.decorator.PowerupDecorator;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.Point;

public class BonusCoinsDecorator extends PowerupDecorator {

    public BonusCoinsDecorator(Power wrappee) {
        super(wrappee);
    }

    @Override
    public void catchPoint(Position position) {
        for (Point point : getPoints()) {
            if (position.equals(point.getPosition())) {
                getPoints().remove(point);
                Wallet wallet = new Wallet();
                wallet.addToTotal(amount(point));
                break;
            }
        }
    }

    @Override
    public int amount(Point point) {
        return wrappee.amount(point) * 5;
    }
}
