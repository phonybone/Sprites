package org.phonybone.sprites;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyHandler extends KeyAdapter {
    /** The number of key presses we've had while waiting for an "any key" press */
    private int pressCount = 1;
	
    /**
     * Notification from AWT that a key has been pressed. Note that
     * a key being pressed is equal to being pushed down but *NOT*
     * released. Thats where keyTyped() comes in.
     *
     * @param e The details of the key that was pressed 
     */
    public void keyPressed(KeyEvent e) {
	System.err.println("KeyPressed event: "+e.toString());
	// if we're waiting for an "any key" typed then we don't 
	// want to do anything with just a "press"
	if (waitingForKeyPress) {
	    waitingForKeyPress=false;
	    System.err.println("any key pressed");
	    return;
	}
			
			
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    leftPressed = true;
	}
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    rightPressed = true;
	}
	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    firePressed = true;
	}
    } 
		
    /**
     * Notification from AWT that a key has been released.
     *
     * @param e The details of the key that was released 
     */
    public void keyReleased(KeyEvent e) {
	// if we're waiting for an "any key" typed then we don't 
	// want to do anything with just a "released"

	System.err.println("KeyReleased event: "+e.toString());

	if (waitingForKeyPress) {
	    waitingForKeyPress=false;
	    System.err.println("any key released");
	    return;
	}
			
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    leftPressed = false;
	}
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    rightPressed = false;
	}
	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    firePressed = false;
	}
    }

    /**
     * Notification from AWT that a key has been typed. Note that
     * typing a key means to both press and then release it.
     *
     * @param e The details of the key that was typed. 
     */
    public void keyTyped(KeyEvent e) {
	// if we're waiting for a "any key" type then
	// check if we've recieved any recently. We may
	// have had a keyType() event from the user releasing
	// the shoot or move keys, hence the use of the "pressCount"
	// counter.
	    
	System.err.println("KeyTyped event: "+e.toString());
	    
	if (waitingForKeyPress) {
	    if (pressCount == 1) {
		// since we've now recieved our key typed
		// event we can mark it as such and start 
		// our new game
		waitingForKeyPress=false;
		System.err.println("any key released");
		startGame();
		pressCount = 0;
	    } else {
		pressCount++;
	    }
	}
			
	switch (e.getKeyChar()) {
	case ' ': 
	    gameRunning=!gameRunning;
	    break;
	case 'q':
	case 'Q':
	case 27:		// escape (in theory)
	    gameOver=true;
	    break;
	}

    }
}

