import java.io.*;
import java.util.*;

public class Maze
{
	private Square[][] maz;
	private int numRow, numCol;
	private Square start, exit;
	public boolean solvable; 
	
	/**
	 * Instantiates Maze
	 */
	public Maze(){}
	
	/**
	 * Goes through a given file and correctly gathers the information from the
	 * file such as row and col then the values of the elements inside of the
	 * array. If the loops completes itself it returns true. Every other case
	 * the loop returns false.
	 * @param fileName
	 * @return
	 */
	public boolean loadMaze(String fileName)
	{
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			
			numRow = scan.nextInt();
			numCol = scan.nextInt();
			
			maz = new Square[numRow][numCol];
			
			for(int i = 0; i < numRow; i++)
			{
				for(int j = 0; j < numCol; j++)
				{
					maz[i][j] = new Square(i, j, scan.nextInt());
					if(maz[i][j].toString() == "S")
						start = maz[i][j];
					else if(maz[i][j].toString() == "E")
						exit = maz[i][j];
				}
			}
			reset();
			return true;
		}
		catch(FileNotFoundException e)
		{
			return false;
		}
	}
	
	/**
	 * Resets the maze by going through it and clearing each element
	 */
	public void reset()
	{
		for (int r = 0; r < numRow; r++)
		{
			for (int c = 0; c < numCol; c++)
			{
				maz[r][c].resetType();
			}
		}
	}
	
	//Returns numCol
	public int getNumCols()
	{return numCol;}
	//Returns numRow
	public int getNumRows()
	{return numRow;}
	//Returns the start of the maze
	public Square getStart()
	{return start;}
	//Returns the end/exit of the maze
	public Square getExit()
	{return exit;}
	//Returns the maze
	public Square[][] getMazeArray()
	{return maz;}
	
	/**
	 * It will find all proper neighbors of the given square and return a list
	 * of them
	 * @param s - given square that you are trying to find the neighbors of
	 * @return - a list of all the neighbors of s
	 */
	public List<Square> getNeighbors(Square s)
	{
		int row = s.getRow();
		int col = s.getCol();
		ArrayList<Square> list = new ArrayList<Square>();
		
		if(!(col == 0) && s.getType() != 1)
		{
			list.add(maz[row][col-1]);
		}
		if(!(row == numRow - 1) && s.getType() != 1)
		{
			list.add(maz[row+1][col]);
		}
		if(!(col == numCol - 1) && s.getType() != 1)
		{
			list.add(maz[row][col+1]);
		}
		if(!(row == 0) && s.getType() != 1)
		{
			list.add(maz[row-1][col]);
		}
		
		return list;
	}
	
	/**
	 * Properly formats maz in a string for the Console
	 */
	public String toString()
	{
		String str = "";
		
		for (int r = 0; r < numRow; r++)
		{
			for (int c = 0; c < numCol; c++)
			{
				str += maz[r][c].toString();
			}
			str += "\n";
		}
		
		return str;
	}	
}
