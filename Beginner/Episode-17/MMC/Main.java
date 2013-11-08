package MMC;

import java.io.*;

public class Main 
{
	
	public static void main(String[] args)
	{
		FileReader fileIn = null;
		FileWriter fileOut = null;
		try
		{
			fileIn = new FileReader("texts/input");
			fileOut = new FileWriter("texts/output");
			
			int i;
			while((i = fileIn.read()) != -1)
			{
				fileOut.write(i);
			}
		}
		catch(IOException ioe) {  }
		finally
		{
			try
			{
				if(fileIn != null) { fileIn.close(); }
				if(fileOut != null) { fileOut.close(); }
			}
			catch(IOException ioe) {  }
		}
	}
	@SuppressWarnings("unused")
	private static void byteStream()
	{
		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		try
		{
			fileIn = new FileInputStream("texts/input");
			fileOut = new FileOutputStream("texts/output");
			
			int i;
			while((i = fileIn.read()) != -1)
			{
				fileOut.write(i);
			}
		}
		catch(IOException ioe) {  }
		finally
		{
			try
			{
				if(fileIn != null) { fileIn.close(); }
				if(fileOut != null) { fileOut.close(); }
			}
			catch(IOException ioe) {  }
		}	
	}
}
