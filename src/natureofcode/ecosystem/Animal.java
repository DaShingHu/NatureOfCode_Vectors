/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natureofcode.ecosystem;

import natureofcode.Mover;
import natureofcode.Vector;
import java.awt.Graphics;
/**
 *
 * @author Saki
 */
public abstract class Animal {
    public Mover movement;
    
    public void checkEdges(int xMax, int yMax)
    {
        if (this.movement.location.getX() > xMax || this.movement.location.getX() < 0)
        {
            this.movement.velocity.setX(-1 * this.movement.velocity.getX());
            this.movement.acceleration.setY(-1 * this.movement.acceleration.getX());
        }
        
        if (this.movement.location.getY() > yMax || this.movement.location.getY() < 0)
        {
            this.movement.velocity.setY(-1 * this.movement.velocity.getY());
            this.movement.acceleration.setY(-1 * this.movement.acceleration.getY());
        }
    }
    public abstract void update(Graphics g);
    public abstract void draw(Graphics g);
    
    
}
