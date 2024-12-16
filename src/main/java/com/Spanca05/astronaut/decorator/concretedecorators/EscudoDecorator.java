package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.decorator.PowerupDecorator;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;

public class EscudoDecorator extends PowerupDecorator {

    public EscudoDecorator(Power wrappee) {
        super(wrappee);
    }

    @Override
    public boolean isEmpty(Position position) {
        for (Monster monster : wrappee.getMonsters())
            if (monster.getPosition().equals(position))
                return false;
        return wrappee.isEmpty(position);
    }
}
