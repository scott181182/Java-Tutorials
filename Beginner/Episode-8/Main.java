package MMC;

/**
 * The main class for Episode 8 - Errors and Exceptions:
 * 
 * 	http://youtu.be/kEUqtHyzamE
 * 
 * @author Scott Fasone
 */
public class Main 
{
	public static int[] intArray;
	
	public static void main(String[] args)
	{
		try { init(2); }
		catch(Exception e) { e.printStackTrace(); }
	}
	public static void init(int index) throws CustomException
	{
		if(intArray == null) { throw new CustomException("'intArray' == null"); }
		else if(index >= intArray.length) { throw new CustomException("Index requested was out of bounds"); }
		else { System.out.println(intArray[index]); }
	}
	static class CustomException extends Exception
	{
		private static final long serialVersionUID = 1L;
		
		public CustomException()
		{
			this("");
		}
		public CustomException(String msg)
		{
			System.err.println(msg);
		}
	}
}
