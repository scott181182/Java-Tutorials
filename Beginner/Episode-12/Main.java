package MMC;

public class Main 
{
	public static String key1 = "I'm the first Key";
	public static Integer value1 = 5;
	
	public static Object obj1 = new Object();
	public static Integer integer1 = new Integer(19);
	
	public static NotGeneric notGen = new NotGeneric(key1, value1);
	public static IsGeneric<String, Integer> isGen = new IsGeneric<>(key1, value1);
	public static SingleGeneric<Integer> sGen1 = new SingleGeneric<>(new Integer(3));
	public static SingleGeneric<Number> sGen2;
	
	public static void main(String[] args)
	{
		obj1 = integer1;
		
		Number num1 = getNumber(value1);
		Number num2 = getGenNumber(sGen2);
		
		Integer int1 = (Integer)notGen.getValue();
		String string1 = isGen.getKey();
		
		System.out.println(num2);
	}
	public static Number getGenNumber(SingleGeneric<Number> sGen) { return sGen.getType(); }
	public static Number getNumber(Number num) { return num; }
}
