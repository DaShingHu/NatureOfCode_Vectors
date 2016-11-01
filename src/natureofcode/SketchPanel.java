/*
Not my code, check this. Mostly just minor modifications
http://cs.lmu.edu/~ray/notes/javagraphics/
 */

// Not my code
package natureofcode;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 */
public class SketchPanel extends JPanel {
    private Point lastPoint;
    private Ball b;
    public SketchPanel(Ball b)
    {
        this.b = b;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                b.ballMover.location.setX(e.getX());
                b.ballMover.location.setY(e.getY());
                b.ballMover.velocity.normalize();
                aFunction();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                /*
                b.ballMover.acceleration.setX(e.getX());
                b.ballMover.acceleration.setY(e.getY());
                b.ballMover.acceleration.normalize();
                b.ballMover.velocity.normalize();
                b.ballMover.location.normalize();
                aFunction();*/
            }
        });
    }
    public void aFunction()
    {

        Graphics g = getGraphics();
        paintComponent(g);
        g.dispose();
    }
    @Override
    public void paintComponent (Graphics g)    
    {
        super.paintComponent(g);
        b.paintBall(g);
    }
    
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == 39)
        {
            this.b.ballMover.acceleration.add(new Vector(1, 1));
        }
        else if (e.getKeyCode() == 37)
        {
            this.b.ballMover.acceleration.add(new Vector(-1, -1));
        }
    }
}