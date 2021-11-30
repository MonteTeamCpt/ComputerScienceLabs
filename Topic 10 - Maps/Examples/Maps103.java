import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Maps103
{
	public static void main(String[] args)
	{
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		String s = "dog1cat2pig3cat2pig7dog3dog6cat8dog4pig";
		
		for(String item : s.split("\\d+"))
		{
			if(map.get(item) == null)
			{
				map.put(item, 1);
			}
			else
			{
				map.put(item, map.get(item)+1);
			}
		}
		
		
		//keySet() - return all keys as Set
		
		for(String key: map.keySet())
		{
			System.out.print(key + "\t");
		}
		
		System.out.println();
		
		//values() returns all elements values as a Collection
		
		for(Integer value : map.values()) //prints out all values stores in the map
		{
			System.out.print(value + "\t"); //The order of the values is determined by the key order
		}
		
		System.out.println("\n");
		
		//Using an iterator
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext())
		{
			String key = it.next();
			System.out.println(key + " - " + map.get(key));
		}
	}
}
