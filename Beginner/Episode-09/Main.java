package MMC;

/**
 * The main class for Episode 9 - Type Casting and Primitive Data Objects:
 * 
 * 	http://youtu.be/tqY9nLytxGs
 * 
 * @author Scott Fasone
 */
public class Main 
{
	public static int int1 = 0;
	public static double double1 = 0.1234567d;
	
	public static Integer integer1 = 0;
	public static Double double2 = 12345.24141;
	
	public static char[] charArray1 = { 'a', 'b' };
	
	public static void main(String[] args)
	{
		String msg = charArray1.toString();
		System.out.println(msg);
	}
	public static Object toObject(Number num)
	{
		return new Integer(5);
	}
}
