package fishtank;

import java.awt.Color;
import java.util.ArrayList;


/**
 * A fish.
 */
public class Fish {

  /** My colour. Ah, the vagaries of British vs. US spelling. */
  protected Color colour;
  /** How this fish appears on the screen. */
  protected String appearance;

  /** Indicates whether this fish is moving right. */
  protected boolean goingRight;

  /** This fish's x coordinate. */
  protected int xcoor;
  /** This fish's y coordinate. */
  protected int ycoor;
  /** This numbers the bubble objects created by the fishes. Starts at 
   * 15 in case of additional Objects in the frame. the Object number 
   * of bubble will cycle thought this list  */
  protected static ArrayList<Integer> bubNumber = new ArrayList<Integer>();
  

  /**
   * Constructs a new fish.
   */
  public Fish() {
    colour = Color.red.darker();
    appearance = "><>";
    goingRight = true;
  }
  
  /**
   * Constructs a new fish with text on it.
   */
  public Fish(String fishword) {
    colour = Color.cyan.darker();
    appearance = "><" + fishword + ">";
    goingRight = true;
  }

  /**
   * Set this item's location.
   * 
   * @param first
   *          the x coordinate.
   * @param second
   *          the y coordinate.
   */
  public void setLocation(int second, int first) {
    xcoor = first;
    ycoor = second;
  }

  /**
   * Causes this fish to blow a bubble.
   */
  public void blowBubble() {
    
    //fill up the Arraylist when it get initialized
    if (bubNumber.isEmpty()) {
      for (int i = 30; i <= 59; i++) {
        bubNumber.add(i);
      }
    }
    Bubble bub = new Bubble();
    bub.setLocation(xcoor, ycoor);
    FishTank.myLittleFishies[bubNumber.get(0)] = bub;
    bubNumber.remove(0);
  }

  /**
   * Build and initialize this fish's forward and backward appearances.
   */
  private String reverseAppearance() {
    String reverse = "";
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case '>':
          reverse += '<';
          break;
        case '<':
          reverse += '>';
          break;
        default:
          reverse += appearance.charAt(i);
          break;
      }
    }
    return reverse;
  }

  /**
   * Turns this fish around, causing it to reverse direction.
   */
  public void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {

    // Move one spot to the right or left.
    if (goingRight) {
      xcoor += 1;
    } else {
      xcoor -= 1;
    }

    // Figure out whether I blow a bubble.
    double rand = Math.random();
    if (rand < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    if (rand < 0.1) {
      turnAround();
    }

    // Figure out whether to move up or down, or neither.
    if (rand < 0.1) {
      ycoor += 1;
    } else if (rand < 0.2) {
      ycoor -= 1;
    }
  }
}
