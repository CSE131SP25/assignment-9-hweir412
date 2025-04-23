package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	private boolean superfood = false;
	private boolean speedyfood = false;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = Math.random();
		this.y = Math.random();	
		
		double pos = Math.random();
		
		if (pos > 0.9) {
			superfood = true;
		}
		
		if (pos < 0.9 && pos > 0.8) {
			speedyfood = true;
		}
		
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.MAGENTA);
		
		if (superfood) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (speedyfood) {
			StdDraw.setPenColor(StdDraw.PINK);
		}
		StdDraw.filledCircle(x, y, FOOD_SIZE);
		
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public boolean isSuper() {
		return superfood;
	}
	
	public boolean isSpeedy() {
		return speedyfood;
	}
}
