
// An IntTree Object represents an entire binary tree of ints

public class IntTree
{
	private IntTreeNode overallRoot; //null for an empty tree
	
	
	
	//Known as public-private pair 
	public boolean contains(int num)
	{
		return contains(overallRoot, num);
	}
	
	private boolean contains(IntTreeNode root, int num)
	{
		/*
		
		if(root != null)
		{
			//recursive case: print left, center, then right
			print(root.left);
			if(root.data == num)
				return true;
			print(root.right);
		}
		return false;
		
		*/
		
		if(root == null)
		{
			return false; //base case
		}
		else if(root.data == num)
		{
			return true; //base case
		}
		else 
		{
			return contains(root.left, num) || contains(root.right, num); //recursive case
		}
		
	}
	
	//Known as public-private pair 
	public void print()
	{
		print(overallRoot);
		System.out.println();
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
