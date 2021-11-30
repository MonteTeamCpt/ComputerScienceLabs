
public class Item
{
	private String name;
	private double price;
	private int bulkQty;
	private double bulkPrice;
	
	/**
	 * This method will fill in the variables name and price
	 * with the given parameters name and price
	 * 
	 * @param name - name of item
	 * @param price - price of item
	 */
	Item(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	/**
	 * This method will fill in the variables name, price, bulkQty,
	 * and bulkPrice with their respective inputs in the parameter.
	 * 
	 * @param name - name of item
	 * @param price - price of item
	 * @param bulkQty - number of items needed in order to reach bulk price
	 * @param bulkPrice - the discounted price of item due to bulk qty bought
	 */
	Item(String name, double price, int bulkQty, double bulkPrice)
	{
		//will throw error if any of the numbers are less than 0
		if(price < 0 || bulkQty < 0 || bulkPrice < 0)
			throw new IllegalArgumentException("error");
		this.name = name;
		this.price = price;
		this.bulkQty = bulkQty;
		this.bulkPrice = bulkPrice;
	}
	
	/**
	 * This will calculate the price of the Item including seeing 
	 * the reduced price(bulkPrice) if the requirements(bulkQty) are meet
	 * 
	 * @param quantity - the number of items of this item being purchased
	 * @return - Will return the overall price of the item 
	 */
	double priceFor(int quantity)
	{
		if(quantity < 0)
			throw new IllegalArgumentException("error");
		else if(quantity >= bulkQty && bulkQty != 0)
			return bulkPrice * (double)quantity;
		return price * (double)quantity;
	}
	
	
	@Override
	/**
	 * This method is an overridden version of .equals
	 * This method will be able to see if Item names are the same or not
	 */
	public boolean equals(Object obj) 
	{		
		Item itemObj = (Item) obj;	
		if(this.name == itemObj.name)
			return true;
		return false;
	}
	
	@Override
	/**
	 * This method is an overridden version of .toString()
	 * This method will print out the name and price of the item 
	 * This method will also include bulkPrice and bulkQty if available
	 */
	public String toString() 
	{
		String str = "";
		str += this.name + ", $" + price;
		if(bulkPrice == 0)
			return str;
		return str += "(" + bulkQty + " for $" + bulkPrice + ")";
	}	
}
