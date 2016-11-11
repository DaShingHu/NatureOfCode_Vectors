/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natureofcode.ecosystem;
import natureofcode.Vector;
import natureofcode.Mover;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
/**
 *
 * @author Saki
 */
public class Fly extends Animal {
    
    public Fly()
    {
        super();
    }
    
    public Fly(Mover a)
    {
        super();
        this.movement = a;
    }
    @Override
    public void update(Graphics g)
    {
        Vector r2;
        Random r = new Random();
        r2 = new Vector(Math.sin(r.nextInt()), Math.sin(r.nextInt()));
        this.movement.acceleration.add(r2);
        this.movement.acceleration.normalize();
        this.movement.velocity.limit(1);
        this.movement.update();
        this.draw(g);
    }
    
    @Override
    public void draw(Graphics g)
    {
        this.checkEdges(800, 800);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D e = new Ellipse2D.Double(this.movement.location.getX()-10,
                this.movement.location.getY()-5,
                20, 10);

        g2d.draw(e);
        /*
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        g2d.setTransform(
                AffineTransform.getRotateInstance(
                        this.movement.velocity.heading()));
        g2d.draw(new Ellipse2D.Double
                (
                    this.movement.location.getX(),
                    this.movement.location.getY(),
                    20, 10));
        /*
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(
                this.movement.velocity.heading()));
        g2d.draw(
                new Ellipse2D.Double(
                        this.movement.location.getX(), 
                        this.movement.location.getY(),
                        200, 100));
        

        g2d.setTransform(old);
        */
        
    }
}
