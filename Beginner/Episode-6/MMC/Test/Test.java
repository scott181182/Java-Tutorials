package MMC.Test;

import java.awt.Rectangle;

import MMC.NotMain;
import MMC.Rect;

public class Test 
{
	
	public static Rectangle rect1 = new Rectangle(0, 0, 100, 200);
	public static Rectangle rect2;
	public static Rect rect3 = new Rect(0, 0, 100, 200);
	public static NotMain rect4 = new NotMain(0, 0, 100, 200, "Hola", 5);
	
	public static void main(String[] args)
	{
		rect2 = rect3.getRectangle();
		
		
		System.out.println(rect2.width);
	}

}
