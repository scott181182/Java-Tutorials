package MMC;

/**
 * A class that was subject to some change throughout the episode, but ended up extending Rect, 
 * to show more features of extension, inheretence, and super classes
 * 
 * @author Scott Fasone
 **/
public class NotMain extends Rect implements Inter 
{
	private String string;
	
	public static final int YES = 1;
	public static final int NO = 2;
	public static final int MAYBE = 3;
	
	public NotMain(int x, int y, int width, int height, String string, int answer) 
	{
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.string = string;
		switch(answer)
		{
			case YES: System.out.println("Yes, please"); break;
			case NO: System.out.println("No thank you"); break;
			case MAYBE: System.out.println("Maybe, I'll think about it"); break;
		}
	}
	public void This() {  }
	public void That() {  }
	public void Sure() {  }
}
