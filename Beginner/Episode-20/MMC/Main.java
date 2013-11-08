package MMC;

public class Main 
{
	
	public static void main(String[] args)
	{
		checkAbstracticity();
	}
	public static void checkAbstracticity()
	{
		SubclassOne a1 = new SubclassOne(10);
		SubclassTwo a2 = new SubclassTwo(10);
		
		System.out.println(isAbstract(a1));
		System.out.println(isAbstract(a2));
		
		System.out.println();
		
		a1.printAbstracticity();
	}
	public static boolean isAbstract(AbstractClass par1)
	{
		return par1.isAbstract();
	}
}
