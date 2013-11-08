package BFS.diceroller.gui;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GuiElement 
{
	public Rectangle bounds;
	
	protected BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
	
	public GuiElement(int x, int y, int w, int h)
	{
		this.bounds = new Rectangle(x, y, w, h);
	}
	
	public abstract void draw(Graphics2D g2);
}
