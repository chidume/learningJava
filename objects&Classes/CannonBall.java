/**
This class simulates a cannon ball being shot g
*/

public class CannonBall{
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity; 
    private static final double GRAVITY = -9.8;

    public CannonBall(int xPosition){
	this.xPosition = xPosition;
	yPosition = 0;
	xVelocity = 0;
	yVelocity = 0;
    }

    public double getXPosition(){
	return xPosition;
    }

    public double getYPosition(){
	return yPosition;
    }

    public void move(double sec){
	xPosition = xVelocity * sec;

	yPosition = (yVelocity * sec) + (0.5 * GRAVITY * sec * sec);
    }

    public void shoot(double angle, double velocity){
	double alpha = Math.toRadians(angle);

	xVelocity = velocity * Math.cos(alpha);

	yVelocity = velocity * Math.sin(alpha);
	
	double sec = 0;
	System.out.printf("Time(s)  Position(m)\n");
	while(yPosition >= 0){
	    move(sec);
	    System.out.printf("%-6.2f \t (%.2f, %.2f)\n", sec, xPosition, yPosition);
	    sec += 0.1;
	}
    }
}