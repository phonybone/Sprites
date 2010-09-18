package org.phonybone.sprites;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that doubles are used for positions. This may seem strange
 * given that pixels locations are integers. However, using double means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */
public abstract class Entity {
    /** The current x location of this entity */ 
    protected double x;
    /** The current y location of this entity */
    protected double y;
    /** The current speed of this entity horizontally (pixels/sec) */
    protected double dx;
    /** The current speed of this entity vertically (pixels/sec) */
    protected double dy;
	
    /**
     * Construct a entity based on a sprite image and a location.
     * 
     * @param ref The reference to the image to be displayed for this entity
     * @param x The initial x location of this entity
     * @param y The initial y location of this entity
     */
    public Entity(int x,int y) {
	this.x = x;
	this.y = y;
    }
	
    /**
     * Request that this entity move itself based on a certain ammount
     * of time passing.
     * 
     * @param delta The ammount of time that has passed in milliseconds
     */
    public abstract void move(long delta);
	
    /**
     * Set the horizontal speed of this entity
     * 
     * @param dx The horizontal speed of this entity (pixels/sec)
     */
    public void setHorizontalMovement(double dx) {
	this.dx = dx;
    }

    /**
     * Set the vertical speed of this entity
     * 
     * @param dx The vertical speed of this entity (pixels/sec)
     */
    public void setVerticalMovement(double dy) {
	this.dy = dy;
    }
	
    /**
     * Get the horizontal speed of this entity
     * 
     * @return The horizontal speed of this entity (pixels/sec)
     */
    public double getHorizontalMovement() {
	return dx;
    }

    /**
     * Get the vertical speed of this entity
     * 
     * @return The vertical speed of this entity (pixels/sec)
     */
    public double getVerticalMovement() {
	return dy;
    }
	
    /**
     * Draw this entity to the graphics context provided
     * 
     * @param g The graphics context on which to draw
     */
    public abstract void draw(Graphics g);

    /**
     * Do the logic associated with this entity. This method
     * will be called periodically based on game events
     */
    public void doLogic() {
    }
	
    /**
     * Get the x location of this entity
     * 
     * @return The x location of this entity
     */
    public int getX() {
	return (int) x;
    }

    /**
     * Get the y location of this entity
     * 
     * @return The y location of this entity
     */
    public int getY() {
	return (int) y;
    }

    public abstract int getWidth();
    public abstract int getHeight();

    /**
     * Check if this entity collised with another.
     * 
     * @param other The other entity to check collision against
     * @return True if the entities collide with each other
     */
    public abstract boolean collidesWith(Entity other);
	
    /**
     * Notification that this entity collided with another.
     * 
     * @param other The entity with which this entity collided.
     */
    public abstract void collidedWith(Entity other);
}
