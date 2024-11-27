package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    public Monster(Position position) {
        super(position);
    }

    public Monster(int x, int y) {
        this(new Position(x, y));
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#669900"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "M");
    }

    public Position move(Position pos) {
        return randomMove(pos);
    }

    public Position randomMove(Position position) {
        int max = 1;
        int min = -1;
        Random random = new Random();
        if (random.nextBoolean()) {
            return new Position(position.getX() + (random.nextBoolean() ? min : max), position.getY());
        }
        return new Position(position.getX(), position.getY() + (random.nextBoolean() ? min : max));
    }
}
