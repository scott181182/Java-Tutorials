package MMC;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class Main extends Applet implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = new Dimension(800, 600);
	public static final Dimension GAME_SIZE = new Dimension(400, 300);
	public static final String TITLE = "Episode 14 - Testing";
	
	public static JFrame frame;
	public static boolean isRunning = true;
	
	public int x = 0, y = 0;
	
	public Image screen;
	
	public static void main(String[] args)
	{
		Main main = new Main();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main);
		frame.pack();
		frame.setVisible(true);
		main.start();
	}
	public Main()
	{
		setPreferredSize(SCREEN_SIZE);
		frame = new JFrame();
	}
	public void start()
	{
		init();
		new Thread(this).start();
	}
	public void init()
	{
		screen = createVolatileImage(GAME_SIZE.width, GAME_SIZE.height);
	}
	public void tick()
	{
		
	}
	public void render()
	{
		Graphics g = screen.getGraphics();
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 100, 100);
		
		if(x % 100 == 0) { x++; } else { y++; }
		
		g = getGraphics();
		g.drawImage(screen, 0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height, 0, 0, GAME_SIZE.width, GAME_SIZE.height, null);
	
		g.dispose();
	}
	public void run()
	{
		while(isRunning)
		{
			tick();
			render();
			try { Thread.sleep(50); }
			catch(InterruptedException ie) {  }
		}
	}
	public void stop()
	{
		isRunning = false;
	}
}
