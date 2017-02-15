package fishtank;

import java.awt.Color;

/**
 * A bubble.
 */
public class Bubble {
  
  /** My colour. Ah, the vagaries of British vs. US spelling. */
  protected Color colour;
  /** How this bubble appears on the screen. */
  protected String appearance;

  /** Use for random movement left and right. */
  protected double randMove;

  /** This bubble's first coordinate. */
  protected int xcoor;
  /** This bubble's second coordinate. */
  protected int ycoor;


  /**
   * Constructs a new bubble at the specified cursor location (x, y).
   */
  public Bubble() {
    // Get a nice-looking grey for the bubble
    colour = Color.gray.darker().darker().darker();
    // start off with . as the appearance
    appearance = ".";
  }

  /**
   * Set this item's location.
   * 
   * @param xloc
   *          the first coordinate.
   * @param yloc
   *          the second coordinate.
   */
  public void setLocation(int xloc, int yloc) {
    xcoor = xloc;
    ycoor = yloc;
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation, moving
   * straight up.
   */
  public void floatUp(double randomDouble) {
    if (randomDouble < 0.33) { 
      ycoor--;  // Move upwards.
      
    } else if (randomDouble < 0.66) { 
      // Move upwards.
      ycoor--;
      xcoor += 1;// right
    } else {
      // Move upwards.
      ycoor--;
      xcoor -= 1; // left
    }
    // Figure out whether to grow, if at all.
    // Occasionally change a . to a o or a o to a O
    if (randomDouble < 0.05) {
      // If the appearance is a ., change it to an o
      if (appearance.equals(".")) {
        appearance = "o";
      // If the appearance is an o, change it to a O
      } else {
        appearance = "O";
      }
    }
  }
}
