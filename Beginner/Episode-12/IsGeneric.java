package MMC;

public class IsGeneric<K, V>
{
	private K key;
	private V value;
	
	public IsGeneric(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	public K getKey() { return this.key; }
	public V getValue() { return this.value; }
}
