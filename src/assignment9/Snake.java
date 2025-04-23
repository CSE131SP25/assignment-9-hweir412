package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private double MOVEMENT_SIZE = 0.01;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0.0;
		deltaY = 0.0;
		
		segments = new LinkedList<>();
		BodySegment one = new BodySegment(0.5,0.5, SEGMENT_SIZE);
		segments.add(one);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.getFirst();
		
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;
		
		BodySegment newHead = new BodySegment(newX, newY, SEGMENT_SIZE);
		
		segments.addFirst(newHead);
		
		segments.removeLast();
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(BodySegment segment: segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));
		
		if (distance < SEGMENT_SIZE) {
			addSegment();
			
			if (f.isSuper()) {
				for (int i = 0; i < 5; i++) {
					addSegment();
				}
			}
			
			if (f.isSpeedy()) {
				MOVEMENT_SIZE += 0.01;
			}
			return true;
		}
		return false;
	}
	
	private void addSegment() {
		BodySegment tail = segments.getLast();
		BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
		segments.addLast(newSegment);
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		
		double x = head.getX();
		double y = head.getY();
		
		
		return x >= 0 && x <= 1 && y >=0 && y <= 1;
		
	}
	
	
	public String getHead() {
		BodySegment head = segments.getFirst();
		return "X: " + head.getX() + " Y: " + head.getY();
	}
	
	
	
	
	
	
	
}
