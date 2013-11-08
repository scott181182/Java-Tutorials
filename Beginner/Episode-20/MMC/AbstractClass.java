package MMC;

public abstract class AbstractClass
{
	protected int abstracticity;
	
	public AbstractClass(int par1)
	{
		this.abstracticity = par1;
	}
	public int getAbstracticity() { return this.abstracticity; }
	public void setAbstracticity(int par1) { this.abstracticity = par1; }
	public abstract boolean isAbstract();
	public final void printAbstracticity() { System.out.println(this.abstracticity); }
}
