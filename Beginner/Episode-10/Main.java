package MMC;

public class Main 
{
	public static ThreadExtend tExtend = new ThreadExtend();
	public static Thread tImplement = new Thread(new ThreadImplement());
	
	public static void main(String[] args)
	{
		tImplement.start();
		new Thread()
		{
			public void run()
			{
				try { tImplement.join(1); }
				catch(InterruptedException ie) {  }
				try { Thread.sleep(1000); }
				catch(InterruptedException ie) {  }
				System.out.println("Done");
			}
		}.start();
	}

}
