import java.util.*;

public class Catalog
{
	private String name;
	private List<Item> collection = new ArrayList<Item>();
	
	/**
	 * This constructor will input and record a name of an item
	 * 
	 * @param name - name of an item
	 */
	Catalog(String name)
	{
		this.name = name;
	}
	
	/**
	 * This method will add inputed Items into the ArrayList
	 * 
	 * @param item - an Item from the catalog
	 */
	void add(Item item)
	{
		collection.add(item);
	}
	
	/**
	 * This method will return the length/size of the Array list
	 * 
	 * @return The length/size of the Array list
	 */
	int size()
	{
		return collection.size();
	}

	/**
	 * This method will receive a number and use it to get an Item
	 * from the number it received
	 * 
	 * @param index - the value used to mark at what 
	 * 				  index the ArrayList will be searched
	 * @return - an item from the ArrayList at index
	 */
	Item get(int index)
	{	
		return collection.get(index);
	}
	
	/**
	 * The method will return the name of the Item
	 * @return - will return the name of the Item
	 */
	String getName()
	{
		return this.name;
	}
}
