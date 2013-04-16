package MMC;

public class ThreadExtend extends Thread
{
	public ThreadExtend() {  }
	
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
}
