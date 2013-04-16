package MMC;

/**
 * A test Enum, or enumeration
 * 
 * @author Scott Fasone
 **/
public enum TestEnum 
{
	ENTRY_ONE("", 0),
	ENTRY_TWO("", 1),
	ENTRY_THREE("", 2);
	
	private String key;
	private int value;
	TestEnum(String key, int value)
	{
		this.key = key;
		this.value = value;
	}
	public String getKey() { return this.key; }
	public int getValue() { return this.value; }
	
}
