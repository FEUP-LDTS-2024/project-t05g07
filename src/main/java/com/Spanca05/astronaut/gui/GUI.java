package com.Spanca05.astronaut.gui;

import com.Spanca05.astronaut.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawAstronaut(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawSpike(Position position);

    void drawTrap(Position position);

    void drawCoin(Position position);

    void drawIman(Position position);

    void drawEscudo(Position position);

    void drawPoint(Position position);

    void drawStar(Position position);

    void drawEndBlock(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}