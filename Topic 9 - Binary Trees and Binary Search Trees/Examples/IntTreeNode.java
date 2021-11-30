// An intTreeNode Object is on enode in a binary tree of ints
public class IntTreeNode
{
	int data; // Data stored at this node
	IntTreeNode left; //reference to left subtree
	IntTreeNode right; // reference to right subtree
	
	//constructs a leaf node with given data
	public IntTreeNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	//constructs a branch node with the given data and links
	public IntTreeNode(int data, IntTreeNode right, IntTreeNode left)
	{
		this.data = data;
		this.right = right;
		this.left = left;
	}
}
