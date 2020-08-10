package com.ankita.swingpaint;

public class Coordinate {
	 private int x;
	    private int y;
	 
	    public Coordinate(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	 
	    public int getX(){
	        return x;
	    }
	 
	    public int getY(){
	        return y;
	    }
	 
	    // Method distance calculates the distance from the current object to point
	    public double distance(Coordinate point)
	       {
	         double dist;
	         dist = Math.sqrt((double) ((point.getX() - x)*(point.getX() - x) +
	                          (point.getY() - y)*(point.getY() - y)));
	         return dist;
	       }
	 
	    public Coordinate add(Coordinate anotherPosition){
	        int newXValue, newYValue;
	        newXValue = this. x + anotherPosition.x;
	        newYValue = this. y + anotherPosition.y;
	        return new Coordinate(newXValue, newYValue);
	    }
	 
	    public Coordinate difference(Coordinate anotherPosition){
	        int newXValue, newYValue;
	        newXValue = this. x - anotherPosition.x;
	        newYValue = this. y - anotherPosition.y;
	        return new Coordinate(newXValue, newYValue);
	    }
}
