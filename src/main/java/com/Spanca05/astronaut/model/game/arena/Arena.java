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

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

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

    private final Wallet wallet;

    private final int currentLevel;

    private final SoundEffect starSound;
    private final SoundEffect coinSound;
    private final SoundEffect pointSound;

    public Arena(int width, int height, int currentLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.width = width;
        this.height = height;
        this.currentLevel = currentLevel;

        this.wallet = new Wallet();
        this.camera = new Camera(0, 0);
        this.starSound = new SoundEffect("star.wav");
        this.pointSound = new SoundEffect("point.wav");
        this.coinSound = new SoundEffect("coin.wav");
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

    /*public List<Coin> getCoins() {
        return coins;
    }*/

    //public void setCoins(List<Coin> coins) {this.coins = coins; }

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

    @Override
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    //@Override
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
                if(point instanceof Coin) coinSound.play();
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
