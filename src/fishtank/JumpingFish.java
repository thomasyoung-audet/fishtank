package fishtank;

import java.awt.Color;

/**
 * A fish.
 */
public class JumpingFish extends Fish {

  /** Indicates whether this fish is moving right. */
  protected boolean goingUp;
  
  /**
   * Constructs a new hungry fish.
   */
  public JumpingFish() {
    super();
    colour = Color.pink.darker();
    appearance = "><IJUMP>";
    goingUp = true;
  }
  
  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  @Override
  public void move() {
    
    // Move one spot to the right or left.
    if (goingRight) {
      xcoor += 1;
    } else {
      xcoor -= 1;
    }
    //Do I jump?
    if ((ycoor <= 11 && ycoor >= 5) && goingUp == true) {
      ycoor -= 5 ;
      if (goingRight == true) {
        xcoor += 5;
      } else {
        xcoor -= 5;
      }
      goingUp = false;
      
    } else if ((ycoor >= 10) && goingUp == false) {

      goingUp = true;
      ycoor += 3;
    } else {


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
      if (rand < 0.2) {
        ycoor += 1;
      } else if (rand < 0.5) {
        ycoor -= 1;
      }
    }
  }
}
  
 
