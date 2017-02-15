package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;


/**
 * Displays the fish tank.
 */
public class FishFrame extends JFrame {

  /** My Serializable id. */
  private static final long serialVersionUID = 1409191926708912242L;
  
  /** The font used to draw instances of this class. */
  private static Font FONT = new Font("Monospaced", Font.PLAIN, 10);
  
  /**
   * Paints this fish tank.
   *
   * @param graphics
   *          the graphics context to use for painting.
   */
  public void paint(Graphics graphics) {

    // Get my width and height.
    int width = getBounds().width;
    int height = getBounds().height;

    // Paint the window white.
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, width, height);

    // Tell all the fishtank items to draw themselves.
    for (int a = 0; a != (int) (480 / 10); a++) {
      if (FishTank.myLittleFishies[a] != null) {
          
        if (FishTank.myLittleFishies[a] instanceof Fish) {
            
          draw(graphics, ((Fish)FishTank.myLittleFishies[a]).appearance, 
                ((Fish)FishTank.myLittleFishies[a]).xcoor, 
                ((Fish)FishTank.myLittleFishies[a]).ycoor, 
                ((Fish)FishTank.myLittleFishies[a]).colour);
            
        } else if (FishTank.myLittleFishies[a] instanceof Seaweed) {
          ((Seaweed) FishTank.myLittleFishies[a]).draw(graphics);
          
        } else if (FishTank.myLittleFishies[a] instanceof JumpingFish) {
          draw(graphics, ((JumpingFish)FishTank.myLittleFishies[a]).appearance, 
                ((JumpingFish)FishTank.myLittleFishies[a]).xcoor, 
                ((JumpingFish)FishTank.myLittleFishies[a]).ycoor, 
                ((JumpingFish)FishTank.myLittleFishies[a]).colour);
          
        } else if (FishTank.myLittleFishies[a] instanceof Bubble) {
          draw(graphics, ((Bubble)FishTank.myLittleFishies[a]).appearance, 
                ((Bubble)FishTank.myLittleFishies[a]).xcoor, 
                ((Bubble)FishTank.myLittleFishies[a]).ycoor, 
                ((Bubble)FishTank.myLittleFishies[a]).colour);
          
        } else if (FishTank.myLittleFishies[a] instanceof Wave) {
          ((Wave) FishTank.myLittleFishies[a]).draw(graphics);
        }
      }
    }
  }
  
  /**
   * Draws the given string in the given graphics context at at the given cursor
   * location.
   *
   * @param graphic
   *          the graphics context in which to draw the string.
   * @param str
   *          the string to draw.
   * @param xcoor
   *          the x-coordinate of the string's cursor location.
   * @param ycoor
   *          the y-coordinate of the string's cursor location.
   */
  public static void draw(Graphics graphic, String str, int xcoor, int ycoor, Color colour) {
    graphic.setColor(colour);
    graphic.setFont(FONT);
    FontMetrics fm = graphic.getFontMetrics(FONT);
    graphic.drawString(str, xcoor * fm.charWidth('W'), ycoor * fm.getAscent());
  }
}
