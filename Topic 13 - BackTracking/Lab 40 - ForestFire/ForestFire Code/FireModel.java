public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    /**
     * Constructor that creates the grid and generates all of the cells 
     * @param view - A graphic JPanel for the Grid
     */
    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /**
     * Checks all of the bottom trees of the grid and lits them on fire
     * then it send those trees into solve(rec) after all the recursion is 
     * done it will check if Onett is safe by checking all northern cells
     */
    public void solve()
    {
        // student code here
    	for(int i = 0; i < myGrid[SIZE-1].length; i++)
    	{
    		if(myGrid[SIZE-1][i].getStatus() == 1)
    		{
	    		myGrid[SIZE-1][i].setStatus(2);
	    		solve(SIZE-1,i);
    		}
    	}
        myView.updateView(myGrid);
        Boolean prob = false;
        for(int i = 0; i < myGrid[0].length && prob == false; i++)
    	{
    		if(myGrid[0][i].getStatus() == 2)
    		{
    			prob = true;
    		}
    	}
        
        if(!prob)
        	System.out.println("Onett is safe - Anikin");
        else
        	System.out.println("Onett is in trouble! - Anikin");
    }

    /**
     * Recieves a node that is on fire and lits all surrounding cells that are
     * trees and makes them recur. They all use inBounds in order to avoid 
     * Out of bound Exceptions
     * @param r - # of row
     * @param c - # of col
     */
    public void solve(int r, int c)
    {
    	if(myGrid[r][c].getStatus() == 2)
    	{
    		if(inbounds(r,c+1))
	    		if(myGrid[r][c+1].getStatus() == 1)
	    		{
	    			myGrid[r][c+1].setStatus(2);
	    			solve(r,c+1);
	    		}
    		if(inbounds(r,c-1))
	    		if(myGrid[r][c-1].getStatus() == 1)
	    		{
	    			myGrid[r][c-1].setStatus(2);
	    			solve(r,c-1);
	    		}
    		if(inbounds(r+1,c))
	    		if(myGrid[r+1][c].getStatus() == 1)
	    		{
	    			myGrid[r+1][c].setStatus(2);
	    			solve(r+1,c);
	    		}
    		if(inbounds(r-1,c))
	    		if(myGrid[r-1][c].getStatus() == 1)
	    		{
	    			myGrid[r-1][c].setStatus(2);
	    			solve(r-1,c);
	    		}
    	}
    	
    }
    
    /**
     * Checks to see if myGrid[r][c] is inbounds
     * @param r - # of row
     * @param c - # of col
     * @return if the node is inbounds using the array
     */
	private boolean inbounds(int r, int c)
	{
		try 
		{
			myGrid[r][c].getStatus();
			return true;
		}
		catch(IndexOutOfBoundsException e)
		{
			return false;
		}
	}
	
}
