package baralaborn.physics;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements Runnable
{
	public static final String VERSION = "0.0.1";
	public static final String TITLE = "Physics Simulator " + VERSION;
	public static final Dimension SCREEN_SIZE = new Dimension(800, 600);
	
	public static JFrame frame;
	public static JPanel screenPanel;
	public static BodyPanel bodyPanel;
	
	public Renderer rend;
	public ForceList forceList;
	
	public static void main(String[] args)
	{
		Main main = new Main();
		new Thread(main).start();
	}
	public Main()
	{
		frame = new JFrame();
		frame.setSize(SCREEN_SIZE);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		
		rend = new Renderer(frame);
		forceList = new ForceList();
		bodyPanel = new BodyPanel();
		screenPanel = new JPanel(null);
		screenPanel.setBackground(Color.LIGHT_GRAY);
		screenPanel.add(bodyPanel);
		screenPanel.add(new NetPanel());
		
		forceList.setBounds(0, 0, 200, 580);
		screenPanel.setBounds(205, 0, 595, 580);
		frame.add(forceList);
		frame.add(screenPanel);
		
		frame.setVisible(true);
	}
	public void run()
	{
		while(true)
		{
			rend.render();
			
			try { Thread.sleep(50); }
			catch(InterruptedException ie) {  }
		}
	}
}
