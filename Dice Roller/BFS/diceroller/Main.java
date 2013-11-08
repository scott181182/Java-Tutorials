package BFS.diceroller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import BFS.diceroller.gui.*;

public class Main implements WindowListener, ActionListener, MouseListener, Runnable
{
	public static final String TITLE = "Dice Roller";
	public static final Dimension SIZE = new Dimension(600, 200);
	
	public static final String D2 = "D2";
	public static final String D6 = "D6";
	public static final String D20 = "D20";
	public static final String CLEAR = "CLEAR";
	
	public Frame frame;
	public Random rand;
	public Image[] dice;
	public Image resImg;
	public int res;
	
	private boolean isRunning, isDone;
	private Image imgBuffer;
	private ArrayList<GuiElement> gui;
	
	public static void main(String[] args)
	{
		Main main = new Main();
		new Thread(main).start();
	}
	public Main()
	{
		frame = new Frame();
		frame.addWindowListener(this);
		frame.addMouseListener(this);
		
		frame.setSize(SIZE);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
		
		isRunning = true;
		isDone = false;
		frame.setVisible(true);
		imgBuffer = frame.createImage(SIZE.width, SIZE.height);
		rand = new Random();
	}
	@Override public void run() 
	{
		loadDice();
		initGUI();
		while(isRunning)
		{
			draw();
			
			try { Thread.sleep(50); }
			catch(InterruptedException ie) { ie.printStackTrace(); }
		}
		isDone = true;
	}
	public void draw()
	{
		Graphics2D g2 = (Graphics2D)imgBuffer.getGraphics();
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, SIZE.width, SIZE.height);
		
		for(GuiElement ge : gui) { ge.draw(g2); }
		drawResult(g2);
		
		g2 = (Graphics2D)frame.getGraphics();
		g2.drawImage(imgBuffer, 0, 0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
		g2.dispose();
	}
	public void drawResult(Graphics2D g2)
	{
		if(resImg != null)
		{
			g2.drawImage(resImg, 436, 36, 564, 164, 0, 0, resImg.getWidth(null), resImg.getHeight(null), null);
		}
		else if(res != 0)
		{
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("Ariel", Font.PLAIN, 200 - 36 - 36));
			g2.drawString(String.valueOf(res), 436, 164);
		}
	}
	public void initGUI()
	{
		gui = new ArrayList<>();
		int top = frame.getInsets().top;
		
		GuiButton gb = new GuiButton("Coin", true, 10, top + 10, 100, 20);
		gb.setActionCommand(D2); gb.addActionListener(this);
		gui.add(gb);
		gb = new GuiButton("D6", 10, top + 30 + 10, gb);
		gb.setActionCommand(D6); gb.addActionListener(this);
		gui.add(gb);
		gb = new GuiButton("D20", 10, top + 30 + 30 + 10, gb);
		gb.setActionCommand(D20); gb.addActionListener(this);
		gui.add(gb);
		gb = new GuiButton("Clear", 10, top + 30 + 30 + 30 + 10, gb);
		gb.setActionCommand(CLEAR); gb.addActionListener(this);
		gui.add(gb);
	}
	@Override public void actionPerformed(ActionEvent e) 
	{
		resImg = null; res = 0;
		switch(e.getActionCommand())
		{
			case D2:
				resImg = dice[rand.nextInt(2)];
				break;
			case D6:
				resImg = dice[rand.nextInt(6) + 2];
				break;
			case D20:
				res = rand.nextInt(20) + 1;
				break;
			case CLEAR: break;
		}
	}
	@Override public void mousePressed(MouseEvent e) 
	{
		for(GuiElement ge : gui)
		{
			if(ge instanceof IClickable)
			{
				if(ge.bounds.contains(e.getPoint())) { ((IClickable)ge).click(); }
			}
		}
	}
	public void loadDice()
	{
		dice = new Image[8];
		try
		{
			dice[0] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d2_1.png"));
			dice[1] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d2_2.png"));
			dice[2] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_1.png"));
			dice[3] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_2.png"));
			dice[4] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_3.png"));
			dice[5] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_4.png"));
			dice[6] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_5.png"));
			dice[7] = ImageIO.read(this.getClass().getResource("/BFS/diceroller/res/d6_6.png"));
		} catch(IOException ioe) { ioe.printStackTrace(); }
	}
	
	@Override public void windowOpened(WindowEvent e) {  }
	@Override public void windowClosing(WindowEvent e) 
	{
		frame.setVisible(false);
		isRunning = false;
		frame.dispose();
	}
	@Override public void windowClosed(WindowEvent e) 
	{
		while(true)
		{
			if(isDone) { System.exit(0); }
			try { Thread.sleep(100); } catch(InterruptedException ie) { ie.printStackTrace(); }
		}
	}
	@Override public void windowIconified(WindowEvent e) {  }
	@Override public void windowDeiconified(WindowEvent e) { }
	@Override public void windowActivated(WindowEvent e) { }
	@Override public void windowDeactivated(WindowEvent e) { }
	@Override public void mouseClicked(MouseEvent e) {  }
	@Override public void mouseReleased(MouseEvent e) {  }
	@Override public void mouseEntered(MouseEvent e) {  }
	@Override public void mouseExited(MouseEvent e) {  }
}
