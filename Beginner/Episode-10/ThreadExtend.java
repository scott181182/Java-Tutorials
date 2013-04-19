package MMC;

public class ThreadExtend extends Thread
{
	public void run()
	{
		System.out.println("Hello, World!");
		try { Thread.sleep(2000); }
		catch(InterruptedException ie) {  }
		System.out.println("Goodbye, World!");
	}
}
