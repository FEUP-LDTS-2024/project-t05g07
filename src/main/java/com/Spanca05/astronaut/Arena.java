package com.Spanca05.astronaut;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class    Arena {
    private int width;
    private int height;
    private Astronaut astronaut;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.astronaut = new Astronaut(2, 2);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }
    private void gameOver() {
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public boolean canAstronautMove(Position position) {
        if ((position.getX() > 0 && position.getX() < this.width - 1) && (position.getY() > 0 && position.getY() < this.height - 1)) {
            return true;
        }
        return false;
    }

    public void moveAstronaut(Position position) {
        if (canAstronautMove(position)) {
            astronaut.setPosition(position);
        }
        retrieveCoins();
    }

    public void retrieveCoins() {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(astronaut.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        astronaut.draw(graphics);
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
    }

    public void processKey(KeyStroke key) {
        moveMonsters();
        switch (key.getKeyType()) {
            case KeyType.ArrowUp:
                moveAstronaut(astronaut.moveUp());
                break;
            case KeyType.ArrowDown:
                moveAstronaut(astronaut.moveDown());
                break;
            case KeyType.ArrowLeft:
                moveAstronaut(astronaut.moveLeft());
                break;
            case KeyType.ArrowRight:
                moveAstronaut(astronaut.moveRight());
                break;
        }
        if(verifyMonsterCollisions()) {
            gameOver();
        }
    }



    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        boolean repeated = false;
        for (int i = 0; i < 20; i++) {
            Coin c = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            for (Coin coin : coins) {
                if (coin == c) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated && c.getPosition() != astronaut.getPosition()) {
                coins.add(c);
            }
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        boolean repeated = false;
        for (int i = 0; i < 20; i++) {
            Monster m = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            for (Monster monster : monsters) {
                if (monster == m) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated && m.getPosition() != astronaut.getPosition()) {
                monsters.add(m);
            }
        }
        return monsters;
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position pos = new Position(monster.move(monster.getPosition()));
            if (canMonsterMove(pos)) {
                monster.setPosition(pos);
            }
        }
    }

    private boolean canMonsterMove(Position position) {
        if ((position.getX() > 0 && position.getX() < this.width - 1) && (position.getY() > 0 && position.getY() < this.height - 1)) {
            return true;
        }
        return false;
    }

    public boolean verifyMonsterCollisions() {
        for(Monster monster : monsters) {
            if(monster.getPosition().equals(astronaut.getPosition()) || astronaut.getPreviousPosition().equals(monster.getPosition())) {
                System.out.println("YOU LOST! GG");
                return true;
            }
        }
        return false;
    }

    public boolean verifyExistingCoins() {
        if(coins.isEmpty()) {
            System.out.println("YOU WON! GG");
            return true;
        }
        return false;
    }
}
