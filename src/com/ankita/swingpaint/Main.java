package com.ankita.swingpaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Main  extends JFrame{
     /* This is the object that will keep information about a Rectangle and support all services needed*/
    MyRectangle rectangle = new MyRectangle();
    public Main(){
        super("Resizable rectangle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener( new MouseAdapter(){
            public void mousePressed(MouseEvent e ){
                Coordinate currentMousePosition;
                /* This will extract the position where the event occurred*/
                int x, y;
                x = e.getX();
                y = e.getY();
                currentMousePosition = new Coordinate(x, y);
                /* This will send a message to rectangle to handle the event*/
                rectangle. processMousePressedEvent(currentMousePosition);
                repaint();
            }
            /* when the left mouse button is released*/
            public void mouseReleased(MouseEvent e ){ 
                Coordinate currentMousePosition;
                int x, y;
                x = e.getX();
                y = e.getY();
                currentMousePosition = new Coordinate(x, y);
                rectangle. processMouseReleasedEvent(currentMousePosition);
                repaint();
            }
        }
        );
 
        addMouseMotionListener( new MouseMotionAdapter(){
            public void mouseDragged( MouseEvent e ){ 
                int x, y;
                Coordinate currentMousePosition;
                x = e.getX();
                y = e.getY();
                currentMousePosition = new Coordinate(x, y);
                rectangle. processMouseDraggedEvent(currentMousePosition);
                repaint();
            }
        }
        ); 
         
        setVisible(true); 
    }
     
    /* called to display the Rectangle*/
    public void paint(Graphics g){ 
        super.paint(g);
        /*this makes the rectangle draw itself... see the MyRectangle class for this method*/
        rectangle. draw(g); 
         
    }
    public static void main(String args[]){
        new Main();
    }
} 