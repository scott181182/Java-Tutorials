package MMC;

import java.util.*;

public class Main 
{
	public static ArrayList<String> strings = new ArrayList<>();
	public static HashMap<String, String> values = new HashMap<>();
	
	public static void main(String[] args)
	{
		values.put("username", "baralaborn");
		values.put("password", "password");
		values.put("age", "15");
		values.put("height", "5'6\"");
		values.put("name", "Scott");
		values.put("surname", "Fasone");
		
		String value = values.get("surname");
		System.out.println(value);
	}
	public static void arrayList()
	{
		strings.add("Hello");
		strings.add(", ");
		strings.add("World");
		strings.add("[redacted]");
		strings.add("!");

		strings.remove("[redacted]");
		
		Iterator<String> i = strings.iterator();
		
		while(i.hasNext())
		{
			System.out.print(i.next());
		}
	}
}
