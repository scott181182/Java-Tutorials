package MMC;

public class SubclassTwo extends AbstractClass
{
	public SubclassTwo(int par1)
	{
		super(par1);
	}
	public boolean isAbstract()
	{
		return this.abstracticity > 15;
	}
}
