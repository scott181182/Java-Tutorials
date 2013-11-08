package MMC;

import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args)
	{
		System.out.format("Character: %c%nInteger: %d%nFloating-Point: %f%n", '^', 5, 2.7);
		System.out.format("Int #1: %1$d     Int #2: %2$d     Int #1: %1$d%n", 5, 13);
		System.out.format("Pi: %.20f     E: %10f", Math.PI, Math.E);
	}
	public static void pass()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input you Username and Password...");
		System.out.print("username: ");
		String username = scanner.nextLine();
		System.out.print("password: ");
		String password = scanner.nextLine();
		System.out.format("Username: %s%nPassword: %s%n", username, password);
	}
}
