package BFS.diceroller.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GuiButton extends GuiElement implements IClickable
{
	public String label;
	
	@SuppressWarnings("unused")
	private int charHeight, charWidth, fontSize;
	private boolean isFramed;
	private Font font;
	private Color fgColor = Color.BLACK, bgColor = Color.GRAY, txtColor = Color.BLACK;
	private Rectangle2D stringBounds;
	
	private String command;
	private ArrayList<ActionListener> listeners;
	
	public GuiButton(String l, boolean f, int x, int y, int w, int h)
	{
		super(x, y, w, h);
		isFramed = f;
		label = l;
		fontSize = h;
		
		this.font = new Font("Ariel", Font.PLAIN, h);
		init();
	}
	public GuiButton(String l, String fnt, int fntS, boolean f, int x, int y, int w, int h)
	{
		super(x, y, w, h);
		isFramed = f;
		label = l;
		fontSize = h;
		
		this.font = new Font(fnt, fntS, h);
		init();
	}
	public GuiButton(String l, int x, int y, GuiButton gb)
	{
		super(x, y, gb.bounds.width, gb.bounds.height);
		isFramed = gb.isFramed;
		label = l;
		fontSize = gb.fontSize;
		
		this.font = gb.font;
		init();
	}
	public void init()
	{
		Graphics2D g2 = img.createGraphics();
		FontMetrics fm = g2.getFontMetrics(font);
		
		charHeight = fm.getAscent();
		charWidth = fm.charWidth(' ');
		stringBounds = fm.getStringBounds(label, g2);
		
		g2.dispose();
		listeners = new ArrayList<>();
	}
	
	@Override public void draw(Graphics2D g2) 
	{
		if(isFramed)
		{
			g2.setColor(fgColor);
			g2.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
			g2.setColor(bgColor);
			g2.fillRect(bounds.x + 2, bounds.y + 2, bounds.width - 4, bounds.height - 4);
		}
		g2.setColor(txtColor); g2.setFont(font);
		int x = bounds.x + ((bounds.width / 2) - (int)(stringBounds.getWidth() / 2));
		int y = bounds.y + ((bounds.height / 2) + (int)(stringBounds.getHeight() / 3f));
		g2.drawString(label, x, y);
	}
	public void setColors(Color fg, Color bg, Color txt) { fgColor = fg; bgColor = bg; txtColor = txt; }
	
	@Override public boolean addActionListener(ActionListener al) { return listeners.add(al); }
	@Override public boolean removeActionListener(ActionListener al) { return listeners.remove(al); }
	@Override public void setActionCommand(String ac) { this.command = ac; }
	@Override public void click() { for(ActionListener al : listeners) { al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, command)); } }
}
