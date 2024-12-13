package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;

public class Astronaut extends Element {
    private boolean life;
    private boolean shield;
    private int angle;
    private int dir;
    private GUI.ACTION direction;

    public Astronaut(int x, int y) {
        super(x, y);
        this.life = true;
        this.direction = null;
        this.angle =0;
        this.dir=0; // 0 = right, 1 = left
        this.shield = false;
    }

    public boolean hasShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public void setDirection(GUI.ACTION direction) {
        this.direction = direction;
    }

    public int getDir(){
        return this.dir;
    }

    public void setDir(int a){
        this.dir = a;
    }

    public int getAngle(){
        return this.angle;
    }

    public void setAngle(int a){
        this.angle = a;
    }

    public GUI.ACTION getDirection() {
        return direction;
    }

    public void die() {
        if (!shield) this.life = false;
    }

    public void win() {
        this.life = false;
    }

    public boolean isAlive() {
        return life;
    }
}
