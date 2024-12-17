package com.Spanca05.astronaut.gui;

import com.Spanca05.astronaut.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawAstronaut(Position position, int spriteNumber, int angle);

    void drawWall(Position position);

    void drawPoint(Position position, int spriteNumber);

    void drawSpike(Position position);

    void drawTrap(Position position);

    void drawCoin(Position position, int coinColor);

    void drawIman(Position position, int powerColor);

    void drawStar(Position position, int starColor);

    void drawMenu(Position position);

    void drawSecondMenu(Position position);

    void drawPower1(Position position, boolean isSelected);

    void drawPower2(Position position, boolean isSelected);

    void drawPower3(Position position, boolean isSelected);

    void drawReturn(Position position, boolean isSelected);

    void drawBonusCoins(Position position);

    void drawCompleteButton1(Position position, boolean isSelected);

    void drawCompleteButton2(Position position, boolean isSelected);

    void drawFailedButton1(Position position, boolean isSelected);

    void drawFailedButton2(Position position, boolean isSelected);

    void drawCompleteButton3(Position position, boolean isSelected);

    void draw2Button1(Position position, boolean isSelected);

    void draw2Button2(Position position, boolean isSelected);

    void draw2Button3(Position position, boolean isSelected);

    void drawButton1(Position position, boolean isSelected);

    void drawButton2(Position position, boolean isSelected);

    void drawButton3(Position position, boolean isSelected);

    void drawEndBlock(Position position, int endBlockColor);

    void drawSheild(Position position, int powerColor);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}