import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}
	
	/**
	 * This method will be given coordinates of an element in the
	 * array and count the surrounding number of elements that have
	 * a living cell in it.
	 * 
	 * @param i - index of first dimension of array
	 * @param j - index of second dimension of array
	 * @return  - the surrounding numbers around the element given
	 */
	private int getNumAround(int i, int j)
	{
		int num = 0;
		
		for(int x = -1; x <= 1; x++)
		{
			for(int y = -1; y <= 1; y++)
			{
				// this if statement checks for out of boundaries cases
				if(i+x >= grid.length || j+y >= grid[i].length || (i+x) < 0 || (j+y) < 0)
					continue;
				else if(grid[i+x][j+y].isAliveNow())
				{
					num++;
				}	
			}
		}
		
		if(grid[i][j].isAliveNow()) //Unmarks counter if current cell is alive
			return num-1;
		
		return num;
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		int aliveAround = 0;
		
		/**
		 * This for loop will go through each element of the array and
		 * check if they should be alive next turn or not
		 */
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				aliveAround = getNumAround(i,j); 
				
				if(grid[i][j].isAliveNow() == true)
					grid[i][j].setAliveNext(true);
				
				if(aliveAround == 3)
				{
					grid[i][j].setAliveNext(true);
				}
				else if(aliveAround >= 4 || aliveAround <= 1)
				{
					grid[i][j].setAliveNext(false);
				}
				
				aliveAround = 0;		
			}
		}
		
		/**
		 * This for loop will check each elements current state and either
		 * destroy or create a cell, restarting their AliveNext statements
		 */
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				if(grid[i][j].isAliveNext() == true)
				{
					grid[i][j].setAliveNext(false);
					grid[i][j].setAliveNow(true);
 				}
				else
				{
					grid[i][j].setAliveNow(false);
				}
			}
		}
		
	}
}

