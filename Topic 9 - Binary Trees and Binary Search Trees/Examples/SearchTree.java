import java.util.NoSuchElementException;

public class SearchTree
{
	private IntTreeNode overallRoot; //null for an empty tree
	
	//Known as public-private pair 
	public void print()
	{
		print(overallRoot);
		System.out.println();
	}
	
	//Known as public-private pair 
	public boolean contains(int num)
	{
		return contains(overallRoot, num);
	}
	
//	private boolean contains(IntTreeNode root, int num)
//	{
//		if(root == null)
//			return false; //base case
//		else if(root.data == num)
//			return true; //base case
//		else 
//			return contains(root.left, num) || contains(root.right, num); //recursive case		
//	}
	
	private boolean contains(IntTreeNode node, int value)
	{
		if(node == null)
		{
			return false;
		}
		else if(node.data == value)
		{
			return true;
		}
		else if(node.data > value)
		{
			return contains(node.left, value);
		}
		else
		{
			//node.data < value
			return contains(node.right, value);
		}
	}
	
	/*
	 * Doesnt work
	 * public void add(int value)
	{
		add(overallRoot, value);
	}
	
	private void add(IntTreeNode t, int value)
	{
		if(t == null)
		{
			t = new IntTreeNode(value);
		}
		else if(t.data > value)
		{
			add(t.left, value);
		}
		else if(t.data <= value)
		{
			add(t.right, value);
		}
		
		//else node.data == value;
		//     it's duplicate(don't add)
	}*/
	
	public void add(int value)
	{
		overallRoot = add(overallRoot, value);
	}
		
	private IntTreeNode add(IntTreeNode t, int value)
	{
		if(t == null)
		{
			t = new IntTreeNode(value);
		}
		else if(t.data > value)
		{
			t.left = add(t.left, value);
		}
		else if(t.data <= value)
		{
			t.right = add(t.right, value);
		}
		
		return t;
	}
	
	public int minVal()
	{
		return minVal(overallRoot);
	}
	
	private int minVal(IntTreeNode t)
	{
		if(t == null)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			if(t.left == null)
				return t.data;
			else
				return minVal(t.left);
		}
	}
	
	private void print(IntTreeNode root)
	{
		//base case in implicitly to do nothing null
		if(root != null)
		{
			//recursive case: print left, center, then right
			print(root.left);
			System.out.println(root.data + " ");
			print(root.right);
		}
		
	}
}
