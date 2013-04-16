package MMC;

/**
 * A boring class to exemplify the differences between Inner Classes and Static Nested Classes
 * 
 * @author Scott Fasone
 **/
public class NotNested 
{
	public Main main = new Main();
	public Main.KindaMain kindaMain = new Main.KindaMain();
	
	public void init()
	{
		Main.KindaMain.kindaInt = 0;
		
	}
}
