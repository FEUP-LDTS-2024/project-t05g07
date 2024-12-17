package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.decorator.PowerupDecorator;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;

public class BonusCoinsDecorator extends PowerupDecorator {

    public BonusCoinsDecorator(Power wrappee) {
        super(wrappee);
    }

    @Override
    public void catchPoint(Position position) {
        Wallet wallet = new Wallet();
        int previous = wallet.getTotal();
        wrappee.catchPoint(position);
        int current = wallet.getTotal();
        int gained = current - previous;
        wallet.addToTotal(gained * 4);
    }
}
