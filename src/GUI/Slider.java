package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.io.*; // allows file access
import javax.imageio.*; // allows image loading

/**
 * Defines a JButton that visually appears like a slider with a toggle.
 * <p>
 * The graphics of the slider are designed to fit the theme of the game as a whole.
 */
@SuppressWarnings("serial")
public class Slider extends JButton implements MouseListener {
	private int width, height, value = 50, sliderL, mouseX;

	/**
	 * Constructs a slider with a horizontal bar and vertical toggle bar to indicate the current relative position of the slider.
	 * The toggle bar is automatically centered on the slider and the toggle is responsive to the position when the mouse was first pressed.
	 * 
	 * @param w Length of the slider from left to right
	 */
	public Slider(int w) {
		addMouseListener(this);
		
		//set size
		width = w;
		height = w/6;

		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setBounds(0, 0, width, height);
		
		//establish default values so that slider starts at fifty
		mouseX = this.getSize().width/2 - this.getSize().width/32;
		sliderL = getSize().width/16;
		value = mouseX * 100 / getSize().width;
		
		// This call causes the JButton not to paint the background.
		setContentAreaFilled(false);
	}

	
	// Paint the round background and label.
	protected void paintComponent(Graphics g) {
		//draws a dark bar that is horizontal
		Color bar = new Color(75,55,35);
		g.setColor(bar);
		g.fillRect(0, 5*getSize().height/12, getSize().width, getSize().height/6);
		
		//draw a light rectangle as the slider at the mouse coordinate
		Color slider = new Color(155,155,155);
		g.setColor(slider);
		g.fillRect(mouseX, 0, sliderL, getSize().height);

		// This call will paint the label and the focus rectangle.
		super.paintComponent(g);
	}

	// Paint the border of the button using a simple stroke.
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		// g.drawOval(0, 0, getSize().width-1, getSize().height-1);
	}

	// Hit detection.
	Shape shape;
	public boolean contains(int x, int y) {
		// If the button has changed size, make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Rectangle2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
	
	/**
	 * @return The value that the slider is currently set to
	 */
	public int value()
	{
		return value;
	}
	
	public void mouseClicked(MouseEvent e) {
	}


	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	//listener for when mouse is pressed
	public void mousePressed(MouseEvent e) {
		mouseX = (int) (e.getXOnScreen() - this.getLocationOnScreen().getX());		//gets a mouse coordinate relative to left bound of slider
		
		if (mouseX > 15*getSize().width/16)		//if the coordinate is too high, lower to 15/16 of the width
			mouseX = 15*getSize().width/16;
		if (mouseX < 0 )		//if it's too low, bring value to zero
			mouseX = 0;
		
		//let the value on the slider be the mouse coordinate relative to total width
		value = mouseX * 100 / getSize().width;
	
	
	}

	public void mouseReleased(MouseEvent e) {
		}

	//-------------------------------------------------------------------------------------------------------------
//	// Test routine.
//	public static void main(String[] args) {
//		// Create a button with the label "Jackpot".
//		Slider button = new Slider(414);
//		//button = new Slider("C://work//Projects//2018//EvoSim//src//settings.png", 114, 114);
//
//		// Create a frame in which to show the button.
//		JFrame frame = new JFrame();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(button);
//
//		//        frame.getContentPane().setLayout(new FlowLayout());
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//
//		MouseListener mouseListener = new MouseAdapter() {
//			public void mouseEntered( MouseEvent e )
//			{}
//
//			public void mouseExited( MouseEvent e )
//			{}
//
//			public void mouseClicked( MouseEvent e )
//			{
//			}
//
//			public void mousePressed( MouseEvent e )
//			{
//			}
//
//			public void mouseReleased( MouseEvent e )
//			{
//				System.out.println(button.value());
//			}
//		};
//		button.addMouseListener( mouseListener );
//
//	}
}