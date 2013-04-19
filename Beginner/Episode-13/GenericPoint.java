package MMC;

public class GenericPoint<X extends Number, Y extends Number>
{
	public X xCoord;
	public Y yCoord;
	
	public GenericPoint(X x, Y y)
	{
		this.xCoord = x;
		this.yCoord = y;
	}
	
}
