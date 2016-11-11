/*
Not my code, check this. Mostly just minor modifications
http://cs.lmu.edu/~ray/notes/javagraphics/
 */

// Not my code
package natureofcode;

import natureofcode.ecosystem.Fly;
import natureofcode.ecosystem.Fish;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import java.util.LinkedList;

/**
 *
 */
public class SketchPanel extends JPanel {
    private Point lastPoint;
    private LinkedList<Fish> fishList;
    private LinkedList<Ball> bList;
    private LinkedList<Fly> fList;
    private Ball b;
    private Fly f;
    private Fish fish;
    public SketchPanel(Ball b)
    {
        this.b = b;
        this.f = new Fly(b.ballMover);
        this.fish = new Fish(b.ballMover);
        
        fList = new LinkedList();
        fishList = new LinkedList();
        
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Mover m;
                Fly f2;
                Fish f3;
                Vector location = new Vector(e.getX(), e.getY());
                Vector velocity = new Vector();
                Vector acceleration = new Vector();
                velocity.randomizeSelf();
                acceleration.randomizeSelf();
                velocity.normalize();
                acceleration.normalize();
                m = new Mover(location, velocity, acceleration);
                
                f2 = new Fly(m);
                fList.addLast(f2);
                aFunction();
                /*b2
                Mover m;
                Ball b2;
                Vector location = new Vector(e.getX(), e.getY());
                Vector velocity = new Vector();
                Vector acceleration = new Vector();
                
                velocity.randomizeSelf();
                acceleration.randomizeSelf();
                velocity.normalize();
                acceleration.normalize();
                
                m = new Mover(location, velocity, acceleration);
                f = new Fish(m);
                b2 = new Ball(10, m);
                bList.addLast(b2);
                aFunction();*/
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                Vector mouse = new Vector(e.getX(), e.getY());
                Vector dir = Vector.subtract(mouse, b.ballMover.location);
                
                b.ballMover.acceleration.setX(dir.getX());
                b.ballMover.acceleration.setY(dir.getY());
                b.ballMover.acceleration.normalize();
                double scaleFactor = b.ballMover.location.dist(mouse);
                scaleFactor = 10/(scaleFactor * scaleFactor) ;
                b.ballMover.acceleration.scalarMult(scaleFactor);
                
                f.movement.acceleration.setX(dir.getX());
                f.movement.acceleration.setY(dir.getY());
                f.movement.acceleration.normalize();
                
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
        f.draw(g);
        for (int i = 0; i < fList.size(); i++)
        {
            fList.get(i).update(g);
        }
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