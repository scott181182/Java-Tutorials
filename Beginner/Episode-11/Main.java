package MMC;

public class Main 
{
	public Object obj1 = new Object();
	public static Thread thread1 = new Thread()
	{
		public synchronized void run()
		{
			System.out.println("Waiting...");
			try { wait(0); }
			catch(InterruptedException ie) {  }
			notifyAll();
			System.out.println("Done Waiting");
		}
	};
	public static Thread thread2 = new Thread()
	{
		public synchronized void run()
		{
			try { wait(0); } 
			catch (InterruptedException e) {  }
			notifyAll();
		}
	};
	public static void main(String[] args) throws InterruptedException
	{
		thread1.start();
		thread2.start();
	}
	public static synchronized void printStuff(String msg)
	{
		try { Thread.sleep(1000); }
		catch (InterruptedException e) {  }
		System.out.println(msg);
	}
	
}
