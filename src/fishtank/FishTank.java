package fishtank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A fish tank simulation.
 */
public class FishTank {

  /** The width of a character. */
  public final int charWidth = 6;
  /** The height of a character. */
  public final int charHeight = 10;
  /** numbered fishtank object. */
  public static Object[] myLittleFishies = new Object[60];

  /**
   * Start the fishies!
   * 
   * @param pars
   *          ignored. Why is this normally called args when the thing is called
   *          a parameter?
   */
  public static void main(String[] pars) {

    // The window in which the fish swim.
    FishFrame frame = new FishFrame();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    myLittleFishies[1] = new Fish();
    ((Fish) myLittleFishies[1]).setLocation(23, 18);
    myLittleFishies[2] = new Fish();
    ((Fish) myLittleFishies[2]).setLocation(6, 12);
    myLittleFishies[3] = new Fish();
    ((Fish) myLittleFishies[3]).setLocation(17, 4);
    myLittleFishies[4] = new Fish();
    ((Fish) myLittleFishies[4]).setLocation(15, 28);
    myLittleFishies[5] = new Fish();
    ((Fish) myLittleFishies[5]).setLocation(16, 35);
    myLittleFishies[6] = new Fish();
    ((Fish) myLittleFishies[6]).setLocation(16, 18);
    
    myLittleFishies[7] = new Fish("IMHUNGRY");
    ((Fish) myLittleFishies[7]).setLocation(10, 33);
    
    myLittleFishies[8] = new Seaweed(6);
    ((Seaweed) myLittleFishies[8]).setLocation(24, 33);
    myLittleFishies[9] = new Seaweed(7);
    ((Seaweed) myLittleFishies[9]).setLocation(32, 25);
    myLittleFishies[10] = new Seaweed(5);
    ((Seaweed) myLittleFishies[10]).setLocation(83, 35);
    myLittleFishies[11] = new Seaweed(5);
    ((Seaweed) myLittleFishies[11]).setLocation(43, 29);
    myLittleFishies[12] = new Seaweed(8);
    ((Seaweed) myLittleFishies[12]).setLocation(53, 36);
    myLittleFishies[13] = new Seaweed(7);
    ((Seaweed) myLittleFishies[13]).setLocation(13, 30);
    myLittleFishies[14] = new Seaweed(5);
    ((Seaweed) myLittleFishies[14]).setLocation(63, 24);

    
    myLittleFishies[15] = new Wave();
    ((Wave) myLittleFishies[15]).setLocation(0);
    myLittleFishies[16] = new Wave();
    ((Wave) myLittleFishies[16]).setLocation(60);
    
    myLittleFishies[17] = new JumpingFish();
    ((JumpingFish) myLittleFishies[17]).setLocation(12, 43);
    myLittleFishies[18] = new JumpingFish();
    ((JumpingFish) myLittleFishies[18]).setLocation(14, 73);



    // Show it all!
    frame.setSize(640, 480);
    frame.setLocation(10, 10);
    frame.setVisible(true);

    // Every .3 seconds, tell each item in the fishtank to take
    // a turn.
    while (true) {
      for (int a = 0; a != 60; a++) {
        if (myLittleFishies[a]instanceof Fish) {
          // If the fish hit the edge they get teleported to the other edge
          if (((Fish) myLittleFishies[a]).xcoor <= 0) {
            ((Fish) myLittleFishies[a]).xcoor += 100;
          } else if (((Fish) myLittleFishies[a]).xcoor >= 100) {
            ((Fish) myLittleFishies[a]).xcoor -= 100;
            //If fish hit the top they stay at the top
          } else if (((Fish) myLittleFishies[a]).ycoor <= 10) {
            ((Fish) myLittleFishies[a]).ycoor = 11;
          } else if (((Fish) myLittleFishies[a]).ycoor >= 50) {
            ((Fish) myLittleFishies[a]).ycoor = 50;
          }
          ((Fish) myLittleFishies[a]).move();
        } else if (myLittleFishies[a] instanceof Seaweed) {
          ((Seaweed) myLittleFishies[a]).wave();
        } else if (myLittleFishies[a]instanceof JumpingFish) {
          ((JumpingFish) myLittleFishies[a]).move();
        } else if (myLittleFishies[a] instanceof Bubble) {
          if (((Bubble) myLittleFishies[a]).ycoor <= 10) {
            myLittleFishies[a] = null;
            Fish.bubNumber.add(a);
          } else if (myLittleFishies[a] instanceof Wave) {
            ((Wave) myLittleFishies[a]).wave();
          } else {
            // Figure out whether to float left or right, if at all.
            Bubble heybub = (Bubble) myLittleFishies[a];
            heybub.randMove = Math.random();
            heybub.floatUp(heybub.randMove);
          }
        }
      }
      // Tell the fishtank to redraw itself.
      frame.repaint();

      // Wait .3 seconds before redoing the queue.
      try {
        Thread.sleep(300);
      } catch (InterruptedException exept) {
        exept.printStackTrace();
      }
    }
  }
}
