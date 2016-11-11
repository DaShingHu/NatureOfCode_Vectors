/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natureofcode.ecosystem;
import natureofcode.Mover;
import natureofcode.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.math.*;
/**
 *
 * @author Saki
 */
public class Fish extends Animal {
    
    public Fish()
    {
        super();
        this.movement = new Mover();
        
    }
    
    public Fish(Mover m)
    {
        super();
        this.movement = m;
    }
    
    @Override
    public void update(Graphics g)
    {
        this.movement.update();
        this.draw(g);
    }
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle2D.Double(this.movement.location.getX(), this.movement.location.getY(), 10, 2));
        
    }
}
