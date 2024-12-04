package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
        }

        return monsters;
    }

    @Override
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
    }

    @Override
    protected List<Point> createPoints() {
        List<Point> points = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') points.add(new Point(x, y));
        }

        return points;
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
