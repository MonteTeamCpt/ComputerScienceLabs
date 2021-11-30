import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Maps102
{
	public static void main(String[] args)
	{
		Map<Character, Integer> mapOne = new TreeMap<Character, Integer>();
		
		String s = "hawk pride never dies";
		
		for(char c : s.toCharArray())
		{
			if(mapOne.get(c) == null) //map does not contain key
			{
				mapOne.put(c, 0);
			}
			
			mapOne.put(c, mapOne.get(c)+1);
			
		}
		
		//Sorted by ASCII Value
		System.out.println("MapOne: " + mapOne);
		
		System.out.println("\n*********************************************\n");

		//Alternative Approach
		
		Map<Character, Integer> mapTwo = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray())
		{
			if(mapTwo.containsKey(c))
				mapTwo.put(c, mapTwo.get(c)+1);
			else
				mapTwo.put(c,1);
		}
		
		System.out.println("MapTwo: " + mapTwo);
	}
}
