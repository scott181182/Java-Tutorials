package MMC;

/**
 * Main class for Episode 2 - Primitive Data Types and Strings:
 * 
 * 	http://youtu.be/2HUqp92HBCA
 * 
 * @author Scott Fasone
 **/
public class Main 
{
	static byte byte1 = 1_2_7;	
	static short short1 = 32767;
	static int int1 = 2147483647;
	static long long1 = 1234_1234_1234_4321L;
	
	static float float1 = 256.15284651274512079451274f;
	static double double1 = 32767.1623546871235640172354690d;
	
	static boolean boolean1 = false;
	
	static char char1 = 'S';
	static String string1 = "Hello, World!";
	static String string2 = new String("Goodbye, World!");
	static String string3 = string1 + "\n" + string2;
	
	public static void main(String[] args)
	{
		System.out.println(byte1);
	}
}
