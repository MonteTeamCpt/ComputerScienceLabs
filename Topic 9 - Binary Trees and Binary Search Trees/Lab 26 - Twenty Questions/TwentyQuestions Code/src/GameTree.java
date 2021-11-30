import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class GameTree
{
	/**
	 * Will you need to create an inner class?
	 */
	/**
	 * creates the basis of each node in the Binary Tree
	 */
	private class BinaryTreeNode
	{
		String data;
		BinaryTreeNode left, right;
		
		public BinaryTreeNode(String data) 
		{
			this.data = data;
			left = right = null;
		}
		
		public BinaryTreeNode(String data, BinaryTreeNode left, BinaryTreeNode right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() 
		{ 
			return "Data " + this.data; 
		}
	}

	/**
	 * Will you need any instance variables?
	 */
		private BinaryTreeNode currentRoot;
		private BinaryTreeNode firstRoot;
		private String currentFile;

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName)
	{
		currentFile = fileName;
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			 
			currentRoot = initializeTree(scan);
			firstRoot = currentRoot;
			
		} catch (FileNotFoundException s)
		{
			System.out.println("File does Not Exist Please Try Again: ");
		}	}

	/**
	 * Puts every data point in their correct place within the BinaryTree
	 * @param scan - import scanner with all questions and answers
	 * @return - the Binary Tree with all nodes filled properly
	 */
	private BinaryTreeNode initializeTree(Scanner scan)
	{
		String word = scan.nextLine().trim();
		if(!word.endsWith("?"))
		{
			return new BinaryTreeNode(word);
		}
		else 
		{
			BinaryTreeNode left = initializeTree(scan);
			BinaryTreeNode right = initializeTree(scan);
			return new BinaryTreeNode(word, left, right);
		}
		
	}


	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new left answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		BinaryTreeNode newANode = new BinaryTreeNode(newA);
		BinaryTreeNode temp = new BinaryTreeNode(currentRoot.data);
		
		currentRoot.data = newQ;
		currentRoot.left = newANode;
		currentRoot.right = temp;
		
	}
	
	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		if(currentRoot.data.endsWith("?"))
			return false;
		return true; // replace
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		return currentRoot.data;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.left or right
	 * for Choice.right Example code: theGame.playerSelected(Choice.left);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		if(yesOrNo.equals(Choice.Yes))
		{
			currentRoot = currentRoot.left;
		}
		else 
			currentRoot = currentRoot.right;
	}

	/**
	 * Begin a game at the root of the BinaryTreeNode. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		currentRoot = firstRoot;
	}

	@Override
	/**
	 * Public private compliment, that returns proper toString
	 */
	public String toString() 
	{
		return toString(currentRoot);
	}

	/**
	 * Returns toString based of it is a question or not or if currentNode
	 * @param root
	 * @return
	 */
	private String toString(BinaryTreeNode root)
	{

		if (!root.data.endsWith("?"))
		{
			return "- " + root.data;
		}
		else if (root == currentRoot) 
		{
			return "- " + toString(root.right) + '\n' + root.data + '\n' + "- " + toString(root.left);
		} else
		{
			return toString(root.right) + '\n' + "- " + root.data + '\n' + "- " + toString(root.left);
		}

	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		PrintWriter diskFile = null;
		try 
		{
			diskFile = new PrintWriter(new File(currentFile));
			save(diskFile, firstRoot);
			diskFile.close();
			
		}
		catch (IOException io) 
		{
			System.out.println("Could not create file: " + currentFile);
		}
		
	}
	
	/**
	 * Helper method to recursively print data lines
	 * @param d - diskFile
	 * @param n - firstRoot
	 */
	private void save(PrintWriter d, BinaryTreeNode n)
	{
		if(n != null)
		{
			d.println(n.data);
			save(d, n.left);
			save(d, n.right);
		}
	}
}
