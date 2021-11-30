import java.util.NoSuchElementException;

public class MyBST
{
	private BSTNode root;
	
	/**
	 * This is the basis of the Binary Search Tree
	 */
	private class BSTNode
	{
		Integer val;
		BSTNode left, right;
		
		public BSTNode(Integer val) 
		{
			this.val = val;
			left = right = null;
		}
		@Override
		public String toString() 
		{ 
			return "" + this.val; 
		}
	}
	
	/**
	 * This instantiates the class and root
	 */
	public MyBST() 
	{
		root = null;
	}
	
	/**
	 * Public-Private compliment to find size
	 * @return - the size of root using private method size(BSTNode t)
	 */
	public Integer size()
	{
		return size(root);
	}
	
	/**
	 * It receives a BSTNode and counts each node inside
	 * @param t - Given BST 
	 * @return - the size of t
	 */
	private Integer size(BSTNode t)
	{
		if(t != null)
			return 1 + size(t.left) + size(t.right);
		return 0;
	}
	
	/**
	 * Public-Private compliment to insert a node into root
	 * @param num - number to insert into root
	 */
	public void insert(Integer num)
	{
		root = insert(root, num);
	}
	
	/**
	 * Receives a BSTnode object and number then inserts num into the
	 * correct place inside of t 
	 * @param t
	 * @param num
	 * @return
	 */
	private BSTNode insert(BSTNode t, Integer num)
	{
		if(t == null)
		{
			t = new BSTNode(num);
		}
		else if(t.val > num)
		{
			t.left = insert(t.left, num);
		}
		else if(t.val < num)
		{
			t.right = insert(t.right, num);
		}
		
		return t;
	}
	
	/**
	 * Public-Private compliment to see if a given Integer is inside of root
	 * @param num - integer to see if is root
	 * @return - if root contains num
	 */
	public boolean contains(Integer num)
	{
		return contains(root, num);
	}
	
	/**
	 * Goes through the entire given t in a ordered fashion and checks if 
	 * it's value is equal to num
	 * @param t - the given BST Obj to check 
	 * @param num - the number to check if t contains
	 * @return - if root contains num
	 */
	private boolean contains(BSTNode t, Integer num)
	{
		if(t == null)
		{
			return false;
		}
		else if(t.val == num)
		{
			return true;
		}
		else if(t.val > num)
		{
			return contains(t.left, num);
		}
		else
		{
			//node.data < value
			return contains(t.right, num);
		}
	}
	
	/**
	 * Public-Private compliment that finds the minimum value inside of root 
	 * @return - min value of root
	 */
	public Integer getMin()
	{
		return getMin(root);
	}
	
	/**
	 * Find the min value given a BSTNode object
	 * @param t - given BSTNode obj
	 * @return min value of t
	 */
	private Integer getMin(BSTNode t)
	{
		if(t == null)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			if(t.left == null)
				return t.val;
			else
				return getMin(t.left);
		}
	}
	
	/**
	 * Public-Private compliment that finds the maximum value inside of root 
	 * @return - max value of root
	 */
	public Integer getMax()
	{
		return getMax(root);
	}
	
	/**
	 * Find the max value given a BSTNode object
	 * @param t - given BSTNode obj
	 * @return max value of t
	 */
	private Integer getMax(BSTNode t)
	{
		if(t == null)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			if(t.right == null)
				return t.val;
			else
				return getMax(t.right);
		}
	}
	
	/**
	 * Public-Private compliment that deletes the given num from root
	 * @param num - Integer to get deleted from 
	 */
	public void delete(Integer num)
	{
		root = delete(root, num);
	}
	
	/**
	 * Goes through node and locates num if num is in node. Once num is located
	 * it checks if it is a leaf or branch, if branch it checks the number 
	 * of childen is has then correctly deletes the num.
	 * @param node - given BSTNode obj
	 * @param num - Int to remove from node
	 * @return node without num
	 */
	private BSTNode delete(BSTNode node, Integer num)
	{
		if(node == null)
		{
			return null;
		}
		else if(node.val > num)
		{
			node.left = delete(node.left, num);
		}
		else if(node.val < num)
		{
			node.right = delete(node.right, num);
		}
		else
		{
			if(node.left == null && node.right == null)
			{
				node.right = null;
				node = null;
			}
			else if(node.left == null && node.right != null)
			{
				node = node.right;
			}
			else if(node.left != null && node.right == null)
			{
				node = node.left;
			}
			else if(node.left != null && node.right != null)
			{
				Integer min = getMin(node.right);
				
				delete(min);			
				node.val = min;
			}
		}
		return node;
	}
	
	/**
	 *  Public-Private compliment that uses method inOrder to print the
	 *  array in order from least to greatest
	 */
	public void inOrder()
	{
		System.out.print("[");
		inOrder(root);
		System.out.print("]");
	}
	
	/**
	 * Goes through the array in order using recursion and proper formatting
	 * @param node - Given BSTNode Object to print in order
	 */
	private void inOrder(BSTNode node)
	{
		if(node != null)
		{
			inOrder(node.left);
			if(node.val != getMax(root))
				System.out.print(node.val + ", ");
			else 
				System.out.print(node.val);
			inOrder(node.right);
		}
	}		
	
	/**
	 * Public-Private compliment that prints the root in a in a
	 * specific order
	 */
	public void print()
	{
		print(root, 0);
	}
	
	/**
	 * Properly formats and prints root in a tree like way
	 * @param root - BSTNode object to print
	 * @param level - what level of the root on the node is on
	 */
	private void print(BSTNode root, Integer level)
	{
		if(root != null)
		{
			print(root.right, level+1);
			
			String spacing = "";
			for(Integer i = 0; i < level; i++)
			{
				spacing += "    ";
			}
			
			System.out.println(spacing + root.val);
			print(root.left, level+1);
		}
	}
}
