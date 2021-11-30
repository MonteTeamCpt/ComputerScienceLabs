import java.util.*;

public class Histogram
{
	private Map<String,Integer> histogram;

	/**
	 * Instatiates the histogram
	 */
	public Histogram()
	{
		setSentence();
	}

	/**
	 * Instantiates the histogram and sets the values into histogram
	 * @param sent - a line of Strings 
	 */
	public Histogram(String sent)
	{
		setSentence();
		String[] letters = sent.split(" ");
		
		for(String c : letters)
		{
			if(histogram.get(c) == null) //map does not contain key
			{
				histogram.put(c, 0);
			}
			
			histogram.put(c, histogram.get(c)+1);	
		}
		
	}
	
	//sets the histogra,
	public void setSentence()
	{
		histogram = new TreeMap<String,Integer>(); 
	}

	/**
	 * Properly orders the output onto the a string for the console
	 * @returns String - The proper output
	 */
	public String toString()
	{
		String output = "char    1---5----10\n";
		
		Iterator<String> it = histogram.keySet().iterator();
		
		while(it.hasNext())
		{
			String key = it.next();
			output += key + "       ";
			for(int i = 0; i < histogram.get(key); i++)
			{
				output += "*";
			}
			output += "\n";
		}
		
		return output;
	}
}