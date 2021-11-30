import java.io.*;
import java.util.*;

public class BoggleSolver
{
	private Set<String> dictionary;
	private Set<String> words;
	/**
	 * Basic constructor that reads in file of the dictionary and stores it into 
	 * the dictionary hashset
	 * @param dictionaryName - the name of dictionary to add
	 */
	public BoggleSolver(String dictionaryName) 
	{
		dictionary = new HashSet<String>();
		words = new HashSet<String>();
		try 
		{
			Scanner scan = new Scanner(new File(dictionaryName));
			while (scan.hasNextLine())
			{
				dictionary.add(scan.nextLine());
			}
		} 
		catch (Exception e){}
	}
	
	/**
	 * Valid word helper that loops through each index on the boggle board and recursively calls
	 * the validHelper method to cget a set of all the valid words in the Boggle board (I also keep track of
	 * the time it takes in seconds)
	 * @param board - the Boggleboard
	 * @return the hashset of the words
	 */
	public Iterable<String> getAllValidWords(BoggleBoard board) 
	{
        final long S = System.nanoTime();
		for (int i = 0; i < board.rows(); i++)
		{
			for (int j = 0; j < board.cols(); j++)
			{
				validHelper(board, i, j, 0, "", new boolean [board.rows()][board.cols()]);
			}
		}
		final long E = System.nanoTime();
		 System.out.println("Time: " + (E - S) / 1000000000 + "seconds");
		return words;
	}
	/**
	 * Valid helper methods that actually adds the words to set of words; does this by first making sure that
	 * the word is greater than 2 and that dictionary actually contains the word, and then we get the letter from the board
	 * and add QU to it if it starts with Q and then iteravely do this thorughout the boggleboard
	 * @param board - the boggleboard
	 * @param i - x index
	 * @param j - y index
	 * @param size - the size of the word
	 * @param word - the word to append it to
	 * @param v - keeps treacking of visiting the coordinate locations
	 */
	public void validHelper(BoggleBoard board, int i, int j, int size, String word, boolean[][] v)
	{
		String wordTwo = "";
		if (size >= 3 && dictionary.contains(word))
			words.add(word);

		if (notInBounds(i, j, board) || v[i][j])
			return;
		
		v[i][j] = true;
		int add = 1;
		
		if (board.getLetter(i, j) == 'Q')
		{
			add = 2;
			wordTwo = "QU";
		}
		else
			wordTwo = ""+board.getLetter(i, j);
		
		for(int x = -1; x <= 1; x++)
		{
			for(int y = -1; y <= 1; y++)
			{
				validHelper(board, i + x, j + y, size + add, word + wordTwo, v);
			}
		}
		v[i][j] = false;
	}
	/**
	 *Returns the score of the given word if it is in the dictionary, zero otherwise.
	 * @param word - the word
	 * @return score of word
	 */
	public int scoreOf(String word) {
		if (word.length() <= 4)
			return 1;
		if (word.length() == 5)
			return 2;
		if (word.length() == 6)
			return 3;
		if (word.length() == 7)
			return 5;
		if (word.length() >= 8)
			return 11;
		return 0;
	}
	/**
	 * Checks if the index given is not in the boundary constraints
	 * @param i - x index
	 * @param j - y index
	 * @param board - the boggle board
	 * @return true or false if its not in bounds or is
	 */
	public boolean notInBounds(int i, int j, BoggleBoard board)
	{
		return i < 0 || i >= board.rows() || j < 0 || j >= board.cols();
	}
	
	public static void main(String[] args) 
	{
		System.out.println("...");

		final String PATH = "";
		BoggleBoard board = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) 
		{
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("\nScore = " + totalPoints);
	}
}
