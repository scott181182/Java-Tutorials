package MMC;

import java.io.*;
import java.util.HashMap;

public class Main 
{
	public static int int1 = 14;
	public static double double1 = 2.71951;
	public static String herro = "Hello, World!";
	
	public static HashMap<String, Double> map = new HashMap<>();
	
	public static void main(String[] args)
	{
		loadObject();
		
		System.out.println("PI = " + map.get("PI"));
		System.out.println("E = " + map.get("E"));
	}
	private static void saveObject()
	{
		ObjectOutputStream fileOut = null;
		try
		{
			fileOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("texts/data.save")));
			fileOut.writeObject(map);
		}
		catch(IOException ioe) {  }
		finally
		{
			try { if(fileOut != null) { fileOut.close(); } }
			catch(IOException ioe) {  }
		}	
	}
	private static void loadObject()
	{
		ObjectInputStream fileIn = null;
		try
		{
			fileIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("texts/data.save")));
			
			map = (HashMap<String, Double>)fileIn.readObject();
		}
		catch(ClassNotFoundException cnfe) {  }
		catch(IOException ioe) {  }
		finally
		{
			try { if(fileIn != null) { fileIn.close(); } }
			catch(IOException ioe) {  }
		}	
	}
	private static void saveData()
	{
		DataOutputStream fileOut = null;
		try
		{
			fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("texts/data.save")));
			fileOut.writeInt(int1);
			fileOut.writeDouble(double1);
			fileOut.writeUTF(herro);
		}
		catch(IOException ioe) {  }
		finally
		{
			try { if(fileOut != null) { fileOut.close(); } }
			catch(IOException ioe) {  }
		}
	}
	private static void loadData()
	{
		DataInputStream fileIn = null;
		try
		{
			fileIn = new DataInputStream(new BufferedInputStream(new FileInputStream("texts/data.save")));
			
			System.out.println("int1 = " + fileIn.readInt());
			System.out.println("double1 = " + fileIn.readDouble());
			System.out.println("herro = " + fileIn.readUTF());
		}
		catch(IOException ioe) {  }
		finally
		{
			try { if(fileIn != null) { fileIn.close(); } }
			catch(IOException ioe) {  }
		}	
	}
	private static void bufferedStream()
	{
		BufferedReader fileIn = null;
		BufferedWriter fileOut = null;
		try
		{
			fileIn = new BufferedReader(new FileReader("texts/charIn"));
			fileOut = new BufferedWriter(new FileWriter("texts/charOut"));
			
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
