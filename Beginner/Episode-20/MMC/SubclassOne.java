package MMC;

public class SubclassOne extends AbstractClass
{
	public SubclassOne(int par1) 
	{
		super(par1);
	}
	@Override public boolean isAbstract()
	{
		return this.abstracticity > 5;
	}
}
