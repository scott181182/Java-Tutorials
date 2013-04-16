package MMC;

/**
 * The main class for Episode 7 - Nested Classes, Enums, and Commenting:
 * 
 * 	http://youtu.be/7nAbMiTo960
 * 
 * @author Scott Fasone
 */
public class Main 
{
	public int int1;
	/**
	 * A really stupid variable for use only for its static modifier
	 */
	public static int int2;
	
	/**
	 * Main's main method for doing stuff on this tutorial series
	 * <code> Hello, World! </code>
	 * @param args The array of Strings for parameter input
	 */
	public static void main(String[] args)
	{
		
		System.out.println(TestEnum.ENTRY_THREE.getValue());
		
		//int3 = 123456789;
		
		int2 = 0;
	}
	
	public class NotMain
	{
		public void init()
		{
			int1 = 0;
			int2 = 1;
		}
	}
	public static class KindaMain
	{
		static int kindaInt;
		public void init()
		{
			int2 = 2;
		}
	}
}
