
public class Number
{
	private int theValue;
	
	/**
	 * Initializes the value by adding the passed value
	 * @param value - the given value of the number
	 */
	public Number(int value)
	{
		theValue = value;
	}	
	
	/**
	 * the value of number
	 * @return - the value
	 */
	public int getValue()
	{
		return theValue;
	}
	
	/**
	 * Checks if the given objects equals theValue
	 */
	public boolean equals(Object obj)
	{
		Integer temp = (Integer)obj;
		
		return temp == theValue;
	} 
	
	/**
	 * Returns the hashCode of thevalue modded by 10
	 */
	public int hashCode()
	{
		return ((Integer)theValue).hashCode()%10;
	}

	/**
	 * returns the value as a string
	 */
	public String toString()
	{
		return theValue + " ";
	}	
}