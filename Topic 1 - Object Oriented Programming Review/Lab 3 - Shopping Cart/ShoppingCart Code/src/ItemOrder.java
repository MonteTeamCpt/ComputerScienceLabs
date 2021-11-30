
public class ItemOrder
{
	private Item item;
	private int qty;
	
	/**
	 * This method will fill in the variables Item and qty
	 * with their respective variables in the parameter
	 * 
	 * @param item - an Item class object
	 * @param qty - the number of items purchased
	 */
	ItemOrder(Item item, int qty)
	{
		this.item = item;
		this.qty = qty;
	}
	
	/**
	 * This method will find the price of the current Item
	 * using the Item class method priceFor and this.qty
	 * 
	 * @return - the price of the Item
	 */
	double getPrice()
	{		
		return item.priceFor(this.qty);
	}
	
	/**
	 * This method will return the Item of this Order
	 * @return - the Item of this Order
	 */
	Item getItem()
	{
		return this.item;
	}
	
	@Override
	/**
	 * This method is an overridden version of .equals
	 * This method will be able to see if Items are the same or not
	 */
	public boolean equals(Object obj)
	{
		ItemOrder itemObj = (ItemOrder) obj;	
		if(this.item == itemObj.getItem())
			return true;
		return false;
	}
	
}
