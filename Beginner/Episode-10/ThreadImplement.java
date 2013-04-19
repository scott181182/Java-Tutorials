package MMC;

public class ThreadImplement implements Runnable
{
	public void run()
	{
		System.out.println("Hello, World!");
		try { Thread.sleep(2000); }
		catch(InterruptedException ie) { System.err.println("It's rude to interrupt"); }
		System.out.println("Goodbye, World!");
	}
}
