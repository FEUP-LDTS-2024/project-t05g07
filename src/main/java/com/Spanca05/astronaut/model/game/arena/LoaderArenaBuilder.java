package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.model.game.elements.MonsterWall;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.strategy.SpikeStrategy;
import com.Spanca05.astronaut.strategy.TrapStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
                else if (line.charAt(x) == 'T') {
                    MonsterWall monsterWall = new MonsterWall(x, y);
                    monsterWall.setStrategy(new TrapStrategy());
                    monsterWall.setType("trap");
                    walls.add(monsterWall);
                }
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'W') {
                    Monster monster = new Monster(x, y);
                    monster.setStrategy(new SpikeStrategy());
                    monster.setType("spike");
                    monsters.add(monster);
                }
        }

        return monsters;
    }

    /*@Override
    protected List<Coin> createCoins() {
        List<Point> points = createPoints();
        List<Coin> coins = new ArrayList<>();
        double coinNum = points.size() * 0.1;
        Collections.shuffle(points);

        for(int i = 0; i < coinNum; i++) {
            coins.add(new Coin(points.get(i).getPosition().getX(), points.get(i).getPosition().getY()));
        }

        for(int i = 0; i < coinNum; i++) {
            points.removeFirst();
        }

        return coins;
    }*/
  
    @Override
    protected List<Star> createStar() {
        List<Star> stars = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S') stars.add(new Star(x, y));
        }
        return stars;
    }

    @Override
    protected List<Point> createPoints() {
        List<Point> points = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') {
                    int random = new Random().nextInt(100);
                    if (random == 0) points.add(oneRandomPowerup(x, y));
                    else if (random <= 10) points.add(new Coin(x, y));
                    else points.add(new Point(x, y));
                }
        }
        return points;
    }

    private Powerup oneRandomPowerup(int x, int y) {
        int n = (int) (Math.random() * 2);
        return switch (n) {
            case 0 -> new Iman(x, y);
            default -> new Escudo(x, y);
        };
    }

    @Override
    protected EndBlock createEndBlock() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'E') return new EndBlock(x, y);
        }
        return null;
    }

    @Override
    protected Astronaut createAstronaut() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Astronaut(x, y);
        }
        return null;
    }
}
