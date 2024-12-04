package com.Spanca05.astronaut.model.game.elements;

public class ImanPower implements Power {
    @Override
    public void becomeStronger(Astronaut astronaut) {
        System.out.println("Iman Strategy BecomeStronger");
    }
}
