package org.phonybone.sprites;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.ArrayIndexOutOfBoundsException;

public class IndexedSprite {
    private Image[] images;
    private int nImages;

    public IndexedSprite(int nImages) {
	this.images=new Image[nImages];
	this.nImages=0;
    }

    public int getWidth() {
	return images[0].getWidth(null);
    }

    public int getHeight() {
	return images[0].getHeight(null);
    }

    public void draw(Graphics g, int x, int y, int i) {
	g.drawImage(images[i],x,y,null);
    }

    public boolean addImage(Image image) {
	boolean yay=true;
	try {
	    this.images[this.nImages]=image;
	    this.nImages++;
	} catch (ArrayIndexOutOfBoundsException e) {
	    yay=false;
	}
	return yay;
    }
}