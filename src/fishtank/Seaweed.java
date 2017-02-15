package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Seaweed.
 */
public class Seaweed {

  /** My colour. Ah, the vagaries of British vs. US spelling. */
  private Color colour;
  /** The number of weed segments. */
  private int weedLenght;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /** This bubble's first coordinate. */
  private int myCurrRow;
  /** This bubble's second coordinate. */
  private int myCurrCol;

  /**
   * Constructs a new seaweed item at the specified cursor location (x,y),length
   * segments tall.
   *
   * @param lenght
   *          the number of segments this seaweed is tall.
   */
  public Seaweed(int lenght) {
    this.weedLenght = lenght;
    colour = Color.green.darker();
  }

  /**
   * Draws this fish tank item. Looks lovely waving in the current, doesn't it?
   *
   * @param graphic
   *          the graphics context in which to draw this item.
   */
  public void draw(Graphics graphic) {

    // WWhich way does the first segment lean?
    boolean lr = leanRight;

    for (int i = 0; i < weedLenght; i++) { // Draw a "/" seaweed segment: even
      if (i % 2 == 0) {
        if (lr) {
          FishFrame.draw(graphic, "/", (myCurrRow), (-i + myCurrCol), colour);
        } else {
          FishFrame.draw(graphic, "\\", (myCurrRow), (-i + myCurrCol), colour);
        }
      } else {
        if (!lr) {
          FishFrame.draw(graphic, "/", (myCurrRow), (-i + myCurrCol), colour);
        } else {
          FishFrame.draw(graphic, "\\", (myCurrRow), (-i + myCurrCol), colour);
        } 
      } 
    }
  }

  /**
   * Set this item's location.
   * 
   * @param xcoor
   *          the first coordinate.
   * @param ycoor
   *          the second coordinate.
   */
  public void setLocation(int xcoor, int ycoor) {
    this.myCurrRow = xcoor;
    this.myCurrCol = ycoor;
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void wave() {
    leanRight = !leanRight;
  }
}
