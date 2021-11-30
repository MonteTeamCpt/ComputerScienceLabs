import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
	private List<ItemOrder> cart;
	
	/**
	 * This method will instantiate the private ArrayList, cart
	 */
	ShoppingCart()
	{
		cart = new ArrayList<ItemOrder>();
	}
	
	/**
	 * This method will see if there are any other orders of this item
	 * and delete them before adding a new version of the Item order
	 * 
	 * @param newOrder - this is the newOrder that will be entered
	 */
	void add(ItemOrder newOrder)
	{
		for(int i = 0; i < cart.size(); i++)
		{
			if(cart.get(i).equals(newOrder))
				cart.remove(i);				
		}	
		cart.add(newOrder);
	}
	
	/**
	 * This method will find the total price of the whole shopping cart
	 * by scanning through the whole cart and finding and adding the price 
	 * of each item
	 * 
	 * @return - the total cost of the shopping cart
	 */
	double getTotal()
	{
		double sum = 0;
		for(int i = 0; i < cart.size(); i++)
		{
			sum += cart.get(i).getPrice();
		}		
		return sum;
	}

}
