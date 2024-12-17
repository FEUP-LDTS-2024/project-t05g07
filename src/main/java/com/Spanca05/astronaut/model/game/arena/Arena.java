package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.audio.SoundEffect;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import com.Spanca05.astronaut.model.game.elements.Monster;

import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Arena implements Power {
    private final int width;
    private final int height;

    private Astronaut astronaut;
    private Camera camera;

    private List<Monster> monsters;
    //private List<Coin> coins;
    private List<Wall> walls;
    private EndBlock endblock;
    private List<Point> points;
    private List<Star> stars;

    private Queue<Powerup> caughtPowerups;
    private final Wallet wallet;

    private final int currentLevel;

    private final SoundEffect starSound;
    private final SoundEffect powerUpSound;
    private final SoundEffect coinSound;
    private final SoundEffect pointSound;

    public Arena(int width, int height, int currentLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.width = width;
        this.height = height;
        this.currentLevel = currentLevel;

        this.caughtPowerups = new LinkedList<>();
        this.wallet = new Wallet();
        this.camera = new Camera(0, 0);
        this.starSound = new SoundEffect("star.wav");
        this.pointSound = new SoundEffect("point.wav");
        this.coinSound = new SoundEffect("coin.wav");
        this.powerUpSound = new SoundEffect("powerUp.wav");
        pointSound.setVolume(-15.0f);
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }

    public void setAstronaut(Astronaut astronaut) {
        this.astronaut = astronaut;
        this.camera.setPosition(this.astronaut.getPosition().minus(new Position(9, 9)));
    }

    @Override
    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void addToMonsters(Monster monster) {
        monsters.add(monster);
    }

    public void removeFromMonsters(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position)) {
                monsters.remove(monster);
                break;
            }
    }
    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
        for (Point point : points) {
            if (point instanceof Coin)
                coins.add((Coin) point);
        }
        return coins;
    }

    public List<Powerup> getPowers() {
        List<Powerup> powerups = new ArrayList<>();
        for (Point point : points) {
            if (point instanceof Powerup)
                powerups.add((Powerup) point);
        }
        return powerups;
    }


    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public EndBlock getEndBlock() {
        return endblock;
    }

    public void setEndBlock(EndBlock endblock) {
        this.endblock = endblock;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Star> getStars() {
        return stars;
    }
    public void setStar(List<Star> stars){
        this.stars = stars;
    }

    public Queue<Powerup> getCaughtPowerups() {
        return caughtPowerups;
    }

    public Powerup pollPowerup() {
        return caughtPowerups.poll();
    }

    @Override
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    /*public boolean isCoin(Position position) {
        for(Coin coin : coins)
            if(coin.getPosition().equals(position))
                return true;
        return false;
    }*/

    public boolean isEndBlock(Position position) {
        return endblock.getPosition().equals(position);
    }

    public boolean isPoint(Position position) {
        for (Point point : points)
            if (point.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isStar(Position position) {
        for (Star star : stars) {
            if (star.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public boolean isPowerup(Position position) {
        for (Point powerup : points)
            if (powerup.getPosition().equals(position)
                    && powerup instanceof Powerup)
                return true;
        return false;
    }

    public boolean isImanPowerup(Position position) {
        for (Point powerup : points)
            if (powerup.getPosition().equals(position) && powerup instanceof Iman)
                return true;
        return false;
    }

    public boolean isEscudoPowerup(Position position) {
        for (Point powerup : points)
            if (powerup.getPosition().equals(position) && powerup instanceof Escudo)
                return true;
        return false;
    }

    public boolean isBonusCoinsPowerup(Position position) {
        for (Point powerup : points)
            if (powerup.getPosition().equals(position) && powerup instanceof BonusCoins)
                return true;
        return false;
    }

    @Override
    public void catchPoint(Position position) {
        for (Point point : points) {
            if (position.equals(point.getPosition())) {
                if (point instanceof Coin) coinSound.play();
                if (point instanceof Powerup) {
                    powerUpSound.playInNewThread();
                    caughtPowerups.add((Powerup) point);
                }
                else pointSound.play();
                points.remove(point);
                wallet.addToTotal(amount(point));
                break;
            }
        }
    }

    private int amount(Point point) {
        if (point instanceof Coin) return 10;
        else if (!(point instanceof Powerup)) return 1;
        else return 0;
    }

    /*public void catchCoin(Position position) {
        for(Coin coin : coins) {
            if(position.equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }*/

    public void catchStar(Position position) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (Star star : stars){
            if (position.equals(star.getPosition())){
                starSound.play();
                stars.remove(star);

                break;
            }
        }
    }

    public Position getCameraPosition() {
        return this.camera.getPosition();
    }

    public void setCameraPosition(Position newPosition) {
        this.camera.setPosition(newPosition);
    }

}
