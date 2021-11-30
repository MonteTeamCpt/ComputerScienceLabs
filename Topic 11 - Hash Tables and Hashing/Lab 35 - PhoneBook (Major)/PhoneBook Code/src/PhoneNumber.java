
public class PhoneNumber
{
	private String number;
	
	/**
	 * Initializes the number
	 * @param number
	 */
	public PhoneNumber(String number)
	{
		this.number = number;
	}

	/**
	 * Checks to see if the object is equal to current number
	 * @return - if they are equal
	 */
	public boolean equals(Object obj)
	{
			PhoneNumber temp = (PhoneNumber) obj;
			return number == (temp.number);
	}

	/**
	 * Returns the hashCode of the current number
	 */
	public int hashCode()
	{
		int hash = 11;
		for(int i = 0; i < number.length(); i++)
		{
			hash = hash*31 + number.charAt(i);
		}
		return hash;
	}

	/**
	 * returns number
	 */
	public String toString()
	{
		return "" + number;
	}
}
