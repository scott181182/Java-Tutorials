package MMC;

public class NotGeneric 
{
	private Object key;
	private Object value;
	
	public NotGeneric(Object key, Object value)
	{
		this.key = key;
		this.value = value;
	}
	public Object getKey() { return this.key; }
	public Object getValue() { return this.value; }
}
