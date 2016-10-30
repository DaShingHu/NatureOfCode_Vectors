
package natureofcode;

import java.awt.Graphics;
/**
 *
 * @author Dustin Hu
 * It's a ball. It moves around.
 * 
 * Fields: 
 * 
 * Mover: The mover that reperesents this ball
 * Radius: The radisu of the ball
 * 
 * Methods:
 * 
 * Ball(): Constructor
 * Ball(int r): Constructor
 * Ball(int r, Mover m): Creates a ball
 * update(): Updates the ball
 * paintBall(Graphics g): Paints the ball
 */
public class Ball {
    private final Mover ballMover;
    private final int radius;
    
    /**
     * Date: Oct 29, 2016
     * Creates a ball
     */
    public Ball()
    {
        this.ballMover = new Mover();
        this.radius = 0;
    }
    
    /**
     * Date: Oct 29, 2016
     * Creates a ball given its radius
     * @param r: The radisu of the ball
     */
    public Ball (int r)
    {
        this.ballMover = new Mover();
        this.radius = r;
    }

    /**
     * Date: Oct 29, 2016
     * Creates a ball of radius r with a mover M
     * @param r: The radisu fo the ball
     * @param m : The mover of the ball
     */
    public Ball (int r, Mover m)
    {
        this.ballMover = m.copy();
        this.radius = r;
    }
    
    /**
     * Date: OCt 29, 2016
     * Updates the ball; calls mover's update();
     */
    public void update()
    {
        this.ballMover.update();
    }

    /**
     * Date: Oct 29, 2016
     * Paints the ball given a Graphics g; no idea how that works
     * @param g: The... Graphics objecT?
     */
    public void paintBall(Graphics g)
    {
        this.update();
        g.drawOval((int)this.ballMover.location.getX(), (int)this.ballMover.location.getY(), this.radius, this.radius);
    }
}
