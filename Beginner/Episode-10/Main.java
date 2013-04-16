package MMC;

/**
 * Main class for Episode 10 - Basic Threading
 * 
 * @author Scott Fasone
 */
public class Main
{
	public static int sec = 0;
	public static char abc = 'a' - 1;
	
	public boolean isRunning = true;
	
	public static void main(String[] args)
	{	
		new Thread()
		{
			public void run()
			{
				while(Main.sec < 10)
				{
					Main.sec++;
					System.out.println(Main.sec);
					
					try { Thread.sleep(1000); }
					catch(InterruptedException ie) { System.err.println("INTERRUPTED!"); }
				}
			}
		}.start(); 
	}
	public void run() 
	{ 
		while(isRunning)
		{
			abc++;
			System.out.println(Main.abc);
			
			if(abc == 'Z') { stop(); }
			try { Thread.sleep(1000); }
			catch(InterruptedException ie) { System.err.println("INTERRUPTED!"); }
		}
	}
	public void stop() { isRunning = false; }
}
