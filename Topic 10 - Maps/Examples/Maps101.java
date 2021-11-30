import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Maps101
{
	public static void main(String[] args)
	{
		//HashMap is speed
		Map<Integer, String> mapOne = new TreeMap<Integer,String>();
		
		mapOne.put(1, "Zavier");
		mapOne.put(11, "Ty");
		mapOne.put(8, "Arjun");
		mapOne.put(3, "Ricky");
		mapOne.put(5, "Teja");
		
		System.out.println("Map One: " + mapOne + "\n");
		
		System.out.println("Element at 1: " + mapOne.get(1));
		System.out.println("Element at 5: " + mapOne.get(5) + "\n");
		
		//Does not throw an index out of bounds expcetion because there isnt an index(returns null)
		System.out.println("Element at 2: " + mapOne.get(2));
		System.out.println("Element at 99: " + mapOne.get(99) + "\n");
		
		//.put(x,y) returns element value thatr was at key previously
		System.out.println(mapOne.put(2, "Ravi"));
		System.out.println(mapOne.put(3, "Oscar") + "\n");

		System.out.println("Map One: " + mapOne + "\n");
		
		System.out.println("**************************************\n");
		
		//Tree Map is order
		Map<Integer, String> mapTwo = new HashMap<Integer,String>();
		
		mapTwo.put(1, "Zavier");
		mapTwo.put(11, "Ty");
		mapTwo.put(8, "Arjun");
		mapTwo.put(3, "Ricky");
		mapTwo.put(5, "Teja");
		
		System.out.println("Map One: " + mapTwo + "\n");
		
		System.out.println("Element at 1: " + mapTwo.get(1));
		System.out.println("Element at 5: " + mapTwo.get(5) + "\n");
		
		//Does not throw an index out of bounds expcetion because there isnt an index(returns null)
		System.out.println("Element at 2: " + mapTwo.get(2));
		System.out.println("Element at 99: " + mapTwo.get(99) + "\n");
		
		//.put(x,y) returns element value thatr was at key previously
		System.out.println(mapTwo.put(2, "Ravi"));
		System.out.println(mapTwo.put(3, "Oscar") + "\n");

		System.out.println("Map One: " + mapTwo + "\n");
		
	}
}
