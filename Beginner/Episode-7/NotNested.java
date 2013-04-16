package MMC;

public class NotNested 
{
	public Main main = new Main();
	public Main.KindaMain kindaMain = new Main.KindaMain();
	
	public void init()
	{
		Main.KindaMain.kindaInt = 0;
		
	}
}
