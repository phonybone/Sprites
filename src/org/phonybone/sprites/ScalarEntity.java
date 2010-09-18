package org.phonybone.sprites;
import java.awt.Graphics;

public abstract class ScalarEntity extends Entity {

    public ScalarEntity(int x, int y) {
	super(x,y);
    }
    public abstract void draw(Graphics g);
    public abstract void collidedWith(Entity other);
}

