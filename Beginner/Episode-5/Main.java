package MMC;

public class Main 
{
	static int int1;
	
	static boolean bool1 = true;
	
	static String[] greetings = { "Hi", "Hello", "Hola", "Good Morning" };
	static String[][] farewells = { { "Bye", "Goodbye", "Farewell" }, { "Adios", "Caoi", "Buenas Noches" } };
	
	public static void main(String[] args)
	{
		int1 = 5 < 10 ? 5 : 10;
		
		while(int1 > 10);
		{	
			int1++;
			//System.out.println(int1);
		}
		for(int i = 0; i < greetings.length; i++)
		{
			//if( i == 2 ) { System.out.println(greetings[i]); }
		}
		sifter:
		for(int i = 0; i < farewells.length; i++)
		{
			for(int j = 0; j < farewells[0].length; j++)
			{
				if(j == 1) { return; }
				System.out.println(farewells[i][j]);
			}
		}
		
		System.out.println(int1);
	}
}
