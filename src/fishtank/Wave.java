package fishtank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wave {

  /** wave colour. */
  protected Color colour;
  /** This bubble's first coordinate. */
  protected int xcoor;
  
  /** How this wave appears on the screen. */
  protected List<String> appearance = new ArrayList<>(Arrays.asList(
      "¸",",","ø","¤","º","°","`","°","º","¤","ø",",",
      "¸",",","ø","¤","º","°","`","°","º","¤","ø",",",
      "¸",",","ø","¤","º","°","`","°","º","¤","ø",",",
      "¸",",","ø","¤","º","°","`","°","º","¤","ø",",",
      "¸",",","ø","¤","º","°","`","°","º","¤","ø",","));
  /** index of wave progression. */
  protected int progress;
  
  
  /**
   * Constructs a new wave.
   */
  public Wave() {
    colour = Color.blue.darker();
  }
  
  /**
   * Set this item's location.
   * 
   * @param xloc
   *          the X coordinate.
   */
  public void setLocation(int xloc) {
    xcoor = xloc;
  }
  
  /**
   * Draws this fish tank item.
   *
   * @param graphic
   *          the graphics context in which to draw this item.
   */
  public void draw(Graphics graphic) {
    String placeHolder = new String();
    for (int j = 0; j <= 59; j++) {
      placeHolder = placeHolder + appearance.get(j);
    }
    FishFrame.draw(graphic, placeHolder, xcoor, 10, colour);
    appearance.add(appearance.get(progress));
    appearance.remove(progress);
  }
  
  /**
   * Makes the waves move along the surface of the tank.
   */
  public void wave() {
    if (progress <= 59) {
      progress++;
    } else {
      progress = 0;
    }
  }
  
  
  
  
  
  
}
