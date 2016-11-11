
package natureofcode;

/**
 * Date: Oct 29, 2016
 * @author Dustin Hu
 * 
 * Fields: 
 * 
 * location : The movers' location
 * velocity : The mover's velocity
 * acceleration: The mover's acceleration
 * 
 * Methods:
 * 
 * Mover(): Constructor
 * Mover(Vector location_): Constructor
 * Mover(Vector location_, Vector velocity_): Construcotr
 * Mover(Vector location_, Vector velocity_, Vector acceleration_): Constructor
 * timePasses(double time): Calculates the new positions and velocities given the time that passes
 * copy(): Creates a copy of mover
 * checkEdges(): Checks if the mover has reached the bounds of its box
 * update(): Updates the mover
 */
public class Mover {

    /**
     * Date: Oct 29, 2016
     * The mover's location
     */
    public final Vector location;

    /**
     *The mover's velocity
     */
    public final Vector velocity;

    /**
     *The mover's acceleration
     */
    public final Vector acceleration;
    
    /**
     *Date: 29, Oct 2016
     * Default constructor
     */
    public Mover()
    {
        this.location = new Vector();
        this.velocity = new Vector();
        this.acceleration = new Vector();
    }

    /**
     * Date: Oct 29, 2016
     * Constructs the mover given a location
     * @param location_: The location/initial point of the mover
     */
    public Mover(Vector location_)
    {
        this.location = location_;
        this.velocity = new Vector();
        this.acceleration = new Vector();
    }

    /**
     * Date: Oct 29, 2016
     * Constructs a mover given its location and velocity
     * @param location_: Initial location
     * @param velocity_: Initial velocity
     */
    public Mover (Vector location_, Vector velocity_)
    {
        this.location = location_;
        this.velocity = velocity_;
        this.acceleration = new Vector();
    }

    /**
     * Date: Oct 29, 2016
     * Constructs a mover based on its position, velocity, and acceleration
     * @param location_: Initial position
     * @param velocity_: Initial velocity
     * @param acceleration_: Initial acceleration
     */
    public Mover (Vector location_, Vector velocity_, Vector acceleration_)
    {
        this.location = location_;
        this.velocity = velocity_;
        this.acceleration = acceleration_;
    }
  
    /**
     * Date: 29, Oct 2016
     * Updates the mover based on the amount of time that has passed
     * @param time: The amonut of time that's passed
     */
    public void timePasses(double time)
    {
        Vector deltaV = this.acceleration.copy();
        deltaV.scalarMult(time);
        
        this.velocity.add(deltaV);
        Vector deltaD = this.velocity.copy();
        deltaD.scalarMult(time);
        
        this.location.add(deltaD);
    }
    
    /**
     * Date: Oct 29, 2016
     * Copies the mover into a new Mover object
     * @return : A copy of this mover
     */
    public Mover copy()
    {
        return new Mover(this.location, this.velocity, this.acceleration);
    }
    
    /**
     * Date: Oct 29, 2016
     * Checks to see if the mover's reached the edges of its boundary
     * @param xMax: The x boundary
     * @param yMax: The y boundary
     */
    public void checkEdges(int xMax, int yMax)
    {
        if (location.getX() > 800 || location.getX() < 0)
        {
            this.velocity.setX(-1 * this.velocity.getX());
            this.acceleration.setX(-1 * this.acceleration.getX());
//            this.acceleration.randomizeSelf();
        }

        if (location.getY() > 800 || location.getY() < 0)
        {
            this.velocity.setY(-1 * this.velocity.getY());
            this.acceleration.setY(-1 * this.acceleration.getY());
//            this.acceleration.randomizeSelf();
        }
    }
    
    /**
     *Date: Oct 29, 2016
     *Updates the mover as if 1 second has passed
     */
    public void update()
    {
        // Assume that time interval of 1 passes
        this.timePasses(1);
        this.checkEdges(800, 800);
    }
}
