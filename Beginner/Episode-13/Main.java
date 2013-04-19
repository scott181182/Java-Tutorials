package MMC;

public class Main 
{
	public static Pair<String, Integer> pair1 = new Pair<>("Pair #1", 5);
	public static Pair<String, Integer> pair2 = new Pair<>("Pair #2", 5);
	public static Pair<String, Object> pair3 = new Pair<>("Pair #3", new Object());
	
	public static GenericPoint<Integer, Float> genPoint1 = new GenericPoint<>(5, 3.14f);
	
	public static void main(String[] args)
	{
		String string1 = wildString(pair2);
		
		boolean bool1 = compare(pair1, pair2);
		
		System.out.println(string1);
	}
	public static <V, K> boolean compare(Pair<V, K> p1, Pair<V, K> p2)
	{
		if(p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue())) { return true; }
		else { return false; }
	}
	public static String wildString(Pair<String, ? extends Number> p1)
	{
		return p1.getKey();
	}
}
