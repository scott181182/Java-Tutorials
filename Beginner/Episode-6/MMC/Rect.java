package MMC;

import java.awt.*;

import javax.swing.JFrame;

public class Rect
{
	protected int x, y, width, height;
	
	public Rect() {  }
	public Rect(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		frame.addKeyListener(new Main());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
	public static String getDesc()
	{
		return "This class is a psuedo class for java.awt.Rectangle";
	}
}
