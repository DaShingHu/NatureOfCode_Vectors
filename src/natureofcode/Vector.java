/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natureofcode;


import java.lang.Math.*;
import java.util.Random;
     
/**
 *
 * @author Dustin Hu
 * Purpose: To simulate vectors
 * Date: October 27th, 2016
 * 
 * Fields:
 * x: X component
 * y: Y component
 * 
 * Methods: 
 * Vector() : Constructor
 * Vector(double x, double y): Constructor
 * Vector(float x, float y): Constructor
 * Vector(int x, int y): Constructor
 * add (Vector a, Vector b): Static addition; returns a new vector
 * add (Vector a): Addition; adds to itself
 * subtract(Vector a, Vector b): Static subtraction; returns a new vector
 * subtract(Vector a): Subtraction; adds to itself
 * scalarMult(double scale): Scalar multiplication of itself
 * scalarMult(float scale): Scalar multiplication of itself
 * scalarMult(int scale): Scalar multiplication of itself
 * div(double scale): Scalar division of itself (Inverse multiplication)
 * div(float scale): Scalar division of itself
 * div(int scale): Scalar division of itself
 * mag(): Returns magnitude
 * getUnitVector(): Gets a unit vector equal to this one
 * normalize(): Changes this vector into its own unit vector
 * heading(): Gets the heading (Angle from x axis)
 * rotate(double theta): Rotates the vector through an angle of theta
 * dist(Vectro input): Checks the euclidean distance between this vector and input
 * limit(double max): Limits the vector; reduces its magnitude if too high
 * copy(): Returns a copy of this vector
 * randomizeSelf(): Randomize x and y values
 * getX(): Get x
 * getY(): Get y
 * setX(): Set x
 * setY(): Set y
 */
 public class Vector{
     
    private double x;
    private double y;
    
    /**
     *
     */
    public Vector()
    {
        this.x = 0;
        this.y = 0;
    }
    /**
     * Date: Oct 28, 2016
     * @param x_: X component
     * @param y_ : Y component
     */
    public Vector(double x_, double y_)
    {
        this.x = x_;
        this.y = y_;
    }  
    /**
     * Date: Oct 28, 2016
     * @param x_: X component
     * @param y_ : Y component
     */
    public Vector(float x_, float y_)
    {
        this.x = (double) x_;
        this.y = (double) y_;
    }
    
    /**
     * Oct 28, 2016
     * @param x_: X component
     * @param y_: Y component
     */
    public Vector(int x_, int y_)
    {
        this.x = (double) x_;
        this.y = (double) y_;
    }
    
    /**
     * Date: Oct 28, 2016
     * @param a: Operand 1
     * @param b: Operand 2
     * @return: Vector Sum of operand 1 and operand 2
     */
    public static Vector add(Vector a, Vector b)
    {
        return new Vector(a.x + b.x, a.y + b.y);
    }

    /**
     * Date: Oct 28, 2016
     * Adds a vector A to this vector
     * @param a: 
     */
    public void add(Vector a)
    {
        this.x = a.x + this.x;
        this.y = a.y + this.y;
    }
    
    /**
     * Date: Oct 28, 2016
     * Returns a new vector that is the vector difference of vectors a and b
     * @param a: The subtrahend
     * @param b: The minuend
     * @return: The vector difference
     */
    public static Vector subtract(Vector a, Vector b)
    {
        return new Vector(a.x - b.x, a.y - b.y);
    }

    /**
     * Date: Oct 28, 2016
     * Subtracts a given vector a from this vector, with this vector
     * becoming equal to the difference
     * @param a: Minuend
     */
    public void subtract (Vector a)
    {
        this.x = this.x - a.x;
        this.y = this.y - a.y;
    }
    
    /**
     * Date: Oct 28, 2016
     * Scales the vector
     * @param scale: Scalar multiple of the vector
     */
    public void scalarMult(double scale)
    {
        this.x = scale * this.x;
        this.y = scale * this.y;
    }

    /** 
     * Date: Oct 28, 2016
     * Scales the vector
     * @param scale: Scalar multiple of the vector
     */
    public void scalarMult(float scale)
    {
        this.scalarMult((double) scale);
    }

    /**
     * Date: Oct 28, 2016
     * Scales the vector
     * @param scale: Scalar multiple of the vector
     */
    public void scalarMult (int scale)
    {
        this.scalarMult ((double) scale);
    }

    /**
     * Date: Oct 28, 2016
     * Scales the vector by its multiplicative inverse
     * @param scale: Value to scale; take multiplicative inverse of it.
     */
    public void div(double scale)
    {
        this.x = scale * this.x;
        this.y = scale * this.y;
    }

    /**
     * Date: Oct 29, 2016
     * Scales the vector by its multiplicative inverse
     * @param scale: Value to scale by; take multiplicative inverse of it
     */
    public void div (float scale)
    {
        this.div ((double) scale);
    }

    /**
     * Date: Oct 29, 2016
     * Scales the vector by its multiplicative inverse
     * @param scale: Value to scale by; take multiplicative inverse of it
     */
    public void div (int scale)
    {
        this.div((double)scale);
    }
            
    /**
     *Date: Oct 29, 2016
     * Finds the magnitude of the vector
     * @return: The magnitude of the vector
     */
    public double mag()
    {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    /**
     * Date: Oct 29, 2016
     * Returns the unit vector of this vector
     * @return: The 
     */
    public Vector getUnitVector()
    {
        Vector output;
        double m = mag();
        if (m != 0)
        {
            output = new Vector(this.x * m, this.y * m);
        }
        else
        {
            output = null;
        }
        return output;
    }
    /**
     *  Date: Oct 29, 2016
     * Changes this vector into its own unit vector
     */
    public void normalize()
    {
        double m = mag();
        this.x = this.x / m;
        this.y = this.y / m;
    }
    
    /**
     * Date: Oct 29, 2016
     * @return: Return the heading of the vector; relative to x axis
     */
    public double heading()
    {
        // Return heading in radians relative to the x axis       
        return Math.atan2(this.y, this.x);
    }
    
    /**
     * Date: Oct 29, 2016
     * Rotate this vector by an angle of theta in radians
     * @param theta: The angle to rotate by
     */
    public void rotate(double theta)
    {
        // Rotates this vector through an angle of theta in radians
        this.x = this.x * Math.cos(theta) - this.y * Math.sin(theta);
        this.y = this.x * Math.sin(theta) + this.y * Math.cos(theta);
    }
    
    /**
     *Date: Oct 29, 2016
     * Find the euclidean distance between two vectors, treating them as points using Pythagorean theorem
     * @param input The vector to compare against
     * @return The distance
     */
    public double dist(Vector input)
    {
        return Math.sqrt(Math.pow(this.x - input.x, 2) + Math.pow(this.y - input.y, 2));
    }
    
/**
 * @TODO: Fix me
 * @param max 
 */
    public void limit (double max)
    {
        if (this.mag() > max)
        {
            
        }
    }

    /**
     * Date: Oct 29, 2016
     * Copy this vector
     * @return: A vector that is identical in x and y to this
     */
    public Vector copy()
    {
        return new Vector(this.x, this.y);
    }
    
    /**
     *Date: Oct 29, 2016
     * Randomize this vector
     * 
     */
    public void randomizeSelf()
    {
        Random r = new Random();
        this.x = r.nextDouble();
        this.y = r.nextDouble();
    }        
   
    /**
     * Date: Oct 29, 2016
     * Gets the x value of this vector
     * @return this vector's x value
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * Date: Oct 29, 2016
     * Gets the y value of this vector
     * @return this vector's y value
     */
    public double getY()
    {
        return this.y;
    }
    
    /**
     * Date: Oct 29, 2016
     * Sets the x value of this vector
     * @param x_ The new x value of this vector
     */
    public void setX(double x_)
    {
        this.x = x_;
    }
    
    /**
     * Date: oct 29, 2016
     * Sets the y value of this vector
     * @param y_ The new y value of this vector
     */
    public void setY(double y_)
    {
        this.y = y_;
    }
}
