package MMC;

/**
 * Main class for Episode 3 - Arrays and Arithmetic:
 * 
 * 	http://youtu.be/YlRN9yayemc
 * 
 * @author Scott Fasone
 **/
public class Main 
{
	static int int1 = 256;
	static int int2;
	
	static int[] intArray1 = new int[11];
	static int intArray2[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	
	static String[] stringArray1 = { "Hello", ", ", "World", "!" };
	
	
	public static void main(String[] args)
	{
		int x = intArray2[0] + intArray2[5];
		int y = intArray2[5] - intArray2[1];
		int z = 5 * 5;
		float a = 79 / 9;
		int b = 41 % 2;
		
		int1++;
		
		boolean bool1 = false;
		
		boolean bool2 = !bool1;
		boolean bool3 = x > y;
		
		System.out.println(bool3);
	}
}
