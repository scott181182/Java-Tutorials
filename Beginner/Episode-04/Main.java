package MMC;

/**
 * Main class for Episode 4 - Inequalities and Conditionals:
 * 
 * 	http://youtu.be/JWR-V0-m67Y
 * 
 * @author Scott Fasone
 **/
public class Main 
{
	static int int1 = 5;
	static int int2 = 10;
	static int int3 = 10;
	
	static boolean bool1 = true;
	
	static String string1 = "";
	static Object obj1 = new Object();
	
	public static void main(String[] args)
	{
		if(obj1 instanceof String)
		{
			System.out.println("If 'if' worked");
		}
		else
		{
			System.out.println("If 'if' didn't work");
		}
		switch(int2)
		{
		case 5: System.out.println("== 5"); break;
		case 10: System.out.println("== 10"); break;
		case 15: System.out.println("== 15"); break;
			default: break;
		}
	}
}
