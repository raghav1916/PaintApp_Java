package com.ankita.swingpaint;

	import java.awt.Color;
	import java.awt.Graphics;
	public class MyRectangle {
	    Coordinate topLeftCorner; 
	    Coordinate lastMousePosition;
	    int width, height;
	    Color RectangleColor;
	    int topLeftX, topLeftY;
	    boolean RectangleIsSelectedForMoving = false; 
	    boolean bottomSelected = false;
	    boolean rightSelected = false;
	     
	    /* This is the initial definition of the rectangle*/
	    public MyRectangle(){
	        topLeftCorner = new Coordinate(50, 50); 
	        width = 100;
	        height = 100;
	        RectangleColor = Color.RED;
	    }
	     
	    /* called when the user drags the mouse*/
	    public void processMouseDraggedEvent(Coordinate currentMousePosition){
	        if (RectangleIsSelectedForMoving){
	            /* Find new position of Rectangle*/
	            updateRectanglePosition(currentMousePosition); 
	        } else if (bottomSelected){
	            updateRectangleHeight(currentMousePosition); 
	        } else if (rightSelected){
	            updateRectangleWidth (currentMousePosition);
	        }
	    }
	     
	    /* This method will be called when the user releases the left mouse button*/
	    public void processMouseReleasedEvent(Coordinate currentMousePosition){
	        //change the color back to red */
	        RectangleColor = Color.RED;     
	        RectangleIsSelectedForMoving = false;             
	        bottomSelected = false;
	        rightSelected = false;
	    }
	    /* will be called when the user presses the left mouse button*/
	    public void processMousePressedEvent(Coordinate currentMousePosition){
	        lastMousePosition = currentMousePosition;
	        if (RectangleIsSelected(lastMousePosition)){ 
	            RectangleIsSelectedForMoving = true;     
	            RectangleColor = Color.GREEN;           
	        }
	        else if (onBottom(lastMousePosition)){ 
	            bottomSelected = true;            
	                                                   
	            RectangleColor = Color.BLUE;             
	        }
	        else if (onRight(lastMousePosition)){
	            rightSelected = true;
	            RectangleColor = Color.BLUE;
	        }
	    }
	     
	    /* This method is called when the user selects the Rectangle*/
	    private void updateRectanglePosition(Coordinate newMousePosition){
	        /* x value and the y value of the new topLeftCorner of the Rectangle*/                                                        
	        int newXValue, newYValue; 
	        newXValue = topLeftCorner.getX() + newMousePosition.getX() - lastMousePosition.getX();
	        newYValue = topLeftCorner.getY() + newMousePosition.getY() - lastMousePosition.getY();
	        /*new position of topLeftCorner of Rectangle*/
	        topLeftCorner = new Coordinate(newXValue, newYValue); 
	        lastMousePosition = newMousePosition; 
	    }
	     
	    /*This method is used to modify the size of Rectangle*/
	    private void updateRectangleHeight(Coordinate newMousePosition){
	        int newYValue;
	        newYValue = newMousePosition.getY();
	        height = Math.abs ((int) (topLeftCorner.getY() - newYValue));
	    }
	     
	    /*This method is used to modify the size of Rectangle*/
	    private void updateRectangleWidth(Coordinate newMousePosition){
	        int newXValue;
	        newXValue = newMousePosition.getX();
	        width = Math.abs((int) (topLeftCorner.getX() - newXValue));
	    }
	    private boolean  RectangleIsSelected(Coordinate point){
	        double Distance;
	        Distance = Math.sqrt((double) (topLeftCorner.getX() + width/2 - point.getX())*(topLeftCorner.getX() + width / 2 - point.getX())
	                + (topLeftCorner.getY() + height / 2 - point.getY()) * (topLeftCorner.getY() + height / 2 - point.getY()));
	    if (Distance < 10.0 && Distance > 0.0) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	      
	     /* method is called to check if the user has pressed mouse button*/
	    private boolean onBottom(Coordinate point){ 
	        if ((point.getY() < (topLeftCorner.getY() + height + 5)) && (point.getY() > (topLeftCorner.getY() + height - 5 ))
	            && (point.getX() <  (topLeftCorner.getX() + width + 5)) && (point.getX() > (topLeftCorner.getX() - width - 5))){
	                    return true;
	        } else{
	            return false;
	        }
	    }
	 
	    private boolean onRight (Coordinate point){
	        if ((point.getX() > (topLeftCorner.getX() + width - 5)) && (point.getX() < (topLeftCorner.getX() + width + 5))
	                && (point.getY() < (topLeftCorner.getY() + height + 5)) && (point.getY() > (topLeftCorner.getY() - height - 5))){
	            return true;
	        }
	        else return false;
	    }
	     
	    /*this method receives the Graphics object of the JFrame and draws on it
	    this method simply draws the rectangle by setting its color and calling drawRect*/
	    public void draw(Graphics g){   
	        g.setColor(RectangleColor);
	        g.drawRect(topLeftCorner.getX() , topLeftCorner.getY() , width, height);
	    }
	 
	}

