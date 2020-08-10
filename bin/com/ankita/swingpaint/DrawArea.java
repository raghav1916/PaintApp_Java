package com.ankita.swingpaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;

//component for drawing
public class DrawArea extends JComponent{
	//MyRectangle rectangle=new MyRectangle();
	//object for drawing
	private Image img;
	//graphics@2D Object
	private Graphics2D g;
	//Mouse cordinates
	private int currentx,currenty,prevx,prevy;
	public DrawArea() {
//		super("Resizable rectangle");
//        setSize(400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDoubleBuffered(false);
		addMouseListener(new  MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				Coordinate currentMousePosition;
				//save prev cordinates when mouse is pressed
				 prevx=e.getX();
				prevy=e.getY();
				//currentMousePosition=new Coordinate(x,y);
				//rectangle. processMousePressedEvent(currentMousePosition);
                //repaint();
		}
//			public void mouseReleased(MouseEvent e ){ 
//                Coordinate currentMousePosition;
//                int x, y;
//                x = e.getX();
//                y = e.getY();
//                currentMousePosition = new Coordinate(x, y);
//                rectangle. processMouseReleasedEvent(currentMousePosition);
//                repaint();
//			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				//cordinates stored while dragging the mouse
				currentx=e.getX();
				currenty=e.getY();
				//when graphicsContext is empty
				if(g!=null) {
					g.drawLine(prevx,prevy, currentx, currenty);
					//refresh draw area and store current cordinated as previous
				repaint();
				prevx=currentx;
				prevy=currenty;
				//int x, y;
//                Coordinate currentMousePosition;
//                x = e.getX();
//                y = e.getY();
//                currentMousePosition = new Coordinate(x, y);
//                rectangle. processMouseDraggedEvent(currentMousePosition);
//                repaint();
			}}
		});
	}
		//setVisible(true);
		
		protected void paintComponent(Graphics gr) {
			//super.paint(gr);
			//rectangle.draw(gr);
			if(img==null) {
				//image we create
				img=createImage(getSize().width, getSize().height);
				g=(Graphics2D) img.getGraphics();
				//enable antialiasing
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				//clear the screen
				clear();
			}
			gr.drawImage(img, 0, 0,null);
		}
		
		// we define clear method for clearing screen
		public void clear() {
			g.setPaint(Color.white);
			//draw while on entire pane
			g.fillRect(0, 0, getSize().width, getSize().height);
            g.setPaint(Color.black);
            repaint();
		}
		public void red() {
		    // apply red color on g2 context
		    g.setPaint(Color.red);
		  }
		 
		  public void black() {
		    g.setPaint(Color.black);
		  }
		 
		  public void magenta() {
		    g.setPaint(Color.magenta);
		  }
		 
		  public void green() {
		    g.setPaint(Color.green);
		  }
		 
		  public void blue() {
		    g.setPaint(Color.blue);
		  }
		  public void drawRectangle() {
			  if(g!=null) {
				  repaint();
				  int px=Math.min(currentx, prevx);
				  int py=Math.min(currenty, prevy);
				  int pw=Math.abs(currentx-prevx);
				  int ph=Math.abs(currenty-prevy);
					g.drawRect(30,40, 50, 60);
					//refresh draw area and store current cordinated as previous
				
				prevx=currentx;
				prevy=currenty;
				System.out.println(g);
			}
		  }
		  
		  public void drawOval() {
			  if(g!=null) {
				  repaint();
			  g.drawOval(30, 40, 50, 60);
		  }
		  }
		  
		  public void drawCircle() {
			  if(g!=null) {
				  repaint();
				  g.drawOval(40, 40, 70, 70);
			  }
		  }
	}


