package com.ankita.swingpaint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingPaintArea extends JPanel{
	JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,rectBtn,ovalBtn,circleBtn;
	  DrawArea drawArea;
	  ActionListener actionListener = new ActionListener() {
	 
	  public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == clearBtn) {
	        drawArea.clear();
	      } else if (e.getSource() == blackBtn) {
	        drawArea.black();
	      } else if (e.getSource() == blueBtn) {
	        drawArea.blue();
	      } else if (e.getSource() == greenBtn) {
	        drawArea.green();
	      } else if (e.getSource() == redBtn) {
	        drawArea.red();
	      } else if (e.getSource() == magentaBtn) {
	        drawArea.magenta();
	      }
	      else if(e.getSource()==rectBtn) {
	    	  drawArea.drawRectangle();
	      }
	      else if(e.getSource()==ovalBtn) {
	    	  drawArea.drawOval();
	      }
	      else if(e.getSource()==circleBtn) {
	    	  drawArea.drawCircle();
	      }
	    }
	  };
	  
	 
	  public static void main(String[] args) {
	   new SwingPaintArea().show();
		  //new DrawArea();
	  }
	 
	  public void show() {
	    // create main frame
	    JFrame frame = new JFrame("Swing Paint");
	    Container content = frame.getContentPane();
	    // set layout on content pane
	    content.setLayout(new BorderLayout());
	    // create draw area
	    drawArea = new DrawArea();
	 
	    // add to content pane
	    content.add(drawArea, BorderLayout.CENTER);
	 
	    // create controls to apply colors and call clear feature
	    JPanel controls = new JPanel();
	 
	    clearBtn = new JButton("Clear");
	    clearBtn.addActionListener(actionListener);
	    blackBtn = new JButton("Black");
	    blackBtn.addActionListener(actionListener);
	    blueBtn = new JButton("Blue");
	    blueBtn.addActionListener(actionListener);
	    greenBtn = new JButton("Green");
	    greenBtn.addActionListener(actionListener);
	    redBtn = new JButton("Red");
	    redBtn.addActionListener(actionListener);
	    magentaBtn = new JButton("Magenta");
	    magentaBtn.addActionListener(actionListener);
	    rectBtn=new JButton("Rectangle");
	   rectBtn.addActionListener(actionListener);
	    ovalBtn=new JButton("Oval");
	    ovalBtn.addActionListener(actionListener);
	    circleBtn=new JButton("Circle");
	    circleBtn.addActionListener(actionListener);
	 
	    // add to panel
	    controls.add(greenBtn);
	    controls.add(blueBtn);
	    controls.add(blackBtn);
	    controls.add(redBtn);
	    controls.add(magentaBtn);
	    controls.add(clearBtn);
	    controls.add(rectBtn);
	    controls.add(ovalBtn);
	 
	    // add to content pane
	    content.add(controls, BorderLayout.NORTH);
	 
	    frame.setSize(600, 600);
	    // can close frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // show the swing paint result
	    frame.setVisible(true);
	   // System.out.prtinln(g);
	 
	  }
}
