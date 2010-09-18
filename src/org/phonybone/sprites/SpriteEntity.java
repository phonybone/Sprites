package org.phonybone.sprites;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class SpriteEntity extends Entity {

    /** The sprite that represents this entity */
    protected Sprite sprite;
    /** The rectangle used for this entity during collisions  resolution */
    private Rectangle me = new Rectangle();
    /** The rectangle used for other entities during collision resolution */
    private Rectangle him = new Rectangle();

    public SpriteEntity(String ref, int x, int y) {
	super(x,y);
	this.sprite = SpriteStore.get().getSprite(ref);
    }
    
    public void draw(Graphics g) {
	sprite.draw(g,(int) x,(int) y);
    }
    public abstract void collidedWith(Entity other);

    public int getWidth() {
	return sprite.getWidth();
    }

    public int getHeight() {
	return sprite.getHeight();
    }

    public void move(long delta) {
	// update the location of the entity based on move speeds
	x += (delta * dx) / 1000;
	y += (delta * dy) / 1000;
    }

    public boolean collidesWith(Entity other) {
	me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
	him.setBounds((int) other.x,(int) other.y,other.getWidth(),other.getHeight());

	return me.intersects(him);
    }

}

