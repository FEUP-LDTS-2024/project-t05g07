package com.Spanca05.astronaut.gui;

import com.Spanca05.astronaut.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawAstronaut(Position position, int spriteNumber, int angle);


    void drawWall(Position position);

    void drawPoint(Position position, int spriteNumber);

    void drawMonster(Position position);

    void drawSpike(Position position);

    void drawTrap(Position position);

    void drawCoin(Position position, int coinColor);

    void drawIman(Position position);

    void drawEscudo(Position position);

    void drawStar(Position position, int starColor);

    void drawEndBlock(Position position, int endBlockColor);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}