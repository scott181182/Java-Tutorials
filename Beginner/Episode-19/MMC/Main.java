package MMC;

public class Main 
{
	public static final int UNKNOWN = 0;
	public static final int OPEN = 1;
	public static final int CLOSE = 2;
	public static final int CRACKED = 3;
	
	public static boolean isOn = false;
	
	public static void main(String[] args)
	{
		int get = 0b01011101;
		int chk = 0b10111010;
		int ret = 0b11100111;
		
		if(isOn)
		{
			get = (get ^ 4);
		}
		else
		{
			get = (get & ~4);
		}
		System.out.println(Integer.toBinaryString(get));
	}
}
