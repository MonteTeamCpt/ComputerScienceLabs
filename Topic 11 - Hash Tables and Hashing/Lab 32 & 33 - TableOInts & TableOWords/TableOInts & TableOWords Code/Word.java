
public class Word
{
	private String theValue;
	
	/**
	 * Initializes the value by adding the passed value
	 * @param value - the given value of the number
	 */

	public Word(String w)
	{
		theValue = w;
	}
	
	/**
	 * the value of word
	 * @return - the value
	 */
	public String getValue()
	{
		return theValue;
	}
	
	
	/**
	 * Checks if the given objects equals theValue
	 */
	public boolean equals(Object obj)
	{
		String temp = obj + "";
		
		return temp.equals(theValue);
	}
	
	/**
	 * Returns the hashCode of vowels times thevalue modded by 10
	 */
	public int hashCode()
	{
		int vowels = 0;
		
		for(int i = 0; i < theValue.length(); i++)
		{
			if(theValue.substring(i, i+1).equalsIgnoreCase("a") || theValue.substring(i, i+1).equalsIgnoreCase("e") 
			|| theValue.substring(i, i+1).equalsIgnoreCase("i") || theValue.substring(i, i+1).equalsIgnoreCase("o") 
			|| theValue.substring(i, i+1).equalsIgnoreCase("u"))
				vowels++;
		}
		return (vowels * theValue.length())%10;
	}
	
	/**
	 * returns the value as a string
	 */
	public String toString()
	{
		return theValue;
	}
	
}