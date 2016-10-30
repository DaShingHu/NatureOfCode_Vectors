/*
Not my code, check this. Mostly just minor modifications
http://cs.lmu.edu/~ray/notes/javagraphics/
 */

// Not my code
package natureofcode;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
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
                aFunction();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
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
}