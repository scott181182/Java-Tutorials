package MMC;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Main implements KeyListener
{
	public static final int SUPER_WIDTH = 150;

	static int int1 = 2;
	public static String string1 = "Literal";
	public static String string2 = new String("Literal");
	public static String string3;
	
	public static Rectangle rect1 = new Rectangle(0, 0, SUPER_WIDTH, 200);
	public static Rectangle rect2;
	public static Rect rect3 = new Rect(0, 0, 100, 200);
	public static NotMain rect4 = new NotMain(0, 0, 100, 200, "Hola", NotMain.YES);
	public static NotMain rect5 = new NotMain(0, 0, 100, 200, "Hola", NotMain.MAYBE);
	
	public static void main(String[] args)
	{
		rect2 = rect3.getRectangle();
		string3 = Rect.getDesc();
		//System.out.println(rect3.width);
	}
	
	public void keyTyped(KeyEvent e) {  } 
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_H) { System.out.println("Hello, everybody"); }
		else if(key == KeyEvent.VK_SPACE) { System.out.println("Everybody Jump!"); }
	}
	public void keyReleased(KeyEvent e) 
	{
		
	}
	
	
}
