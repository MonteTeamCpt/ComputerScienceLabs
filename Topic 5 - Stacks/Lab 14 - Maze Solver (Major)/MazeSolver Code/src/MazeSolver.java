
public abstract class MazeSolver
{
	private Maze thisMaze; 
	public Maze secondMaze;
	private boolean isSolved;
    private boolean solveable;
    private String finalPath = "";
    private Square [][] secondMazeArray;

    public abstract void makeEmpty();
    public abstract void add(Square sq);
    public abstract Square remove();
    public abstract Square getNext();
    public abstract boolean isEmpty();

    /**
     * Initializes the common variables and secondMaze with given maze
     * @param maze - given object of Maze
     */
    public MazeSolver(Maze maze)
    {
        secondMaze = maze;
        secondMazeArray = secondMaze.getMazeArray();
    }
    
    /**
     * Checks to see if the maze has been solved or not by checking if exit
     * been reached properly
     * @param maze - given maze object
     * @return if the maze has been solved or not
     */
    public boolean isSolved(Maze maze)
    {
    	if(secondMaze.getExit().getSquarePrevious() == null)
    		return false;
    	else
    	{
    		Square sq = secondMaze.getExit().getSquarePrevious();
    		
    		while (sq.getType() != Square.START && sq.getType() != Square.WALL)
    		{
    			sq.setType(6);
    			sq = sq.getSquarePrevious();
            }
            return true;
    	}
    	
    }
    
    /**
     * Goes through the whole process of each step the maze solver goes through
     * in order for it to mark through the maze to find a path from start to 
     * exit
     * @return the next step as a square
     */
    public Square step() {
        if(isEmpty()) {
            secondMaze.solvable = false;
            return null;
        }
        Square next = getNext();
        if (next == secondMaze.getExit())
            return next;
        for (Square neighbor : secondMaze.getNeighbors(next)) {
            if (!neighbor.isMarked() && neighbor != secondMaze.getStart()) {
                neighbor.setSquarePrevious(next);
                if (neighbor == secondMaze.getExit()) {
                    return  next;
                }
                else {
                    neighbor.setType(4);
                    add(neighbor);
                }
            }
        }
        if (next.getType() != 1 && next.getType() !=2) next.setType(5);
        return next;
    }
    
    /**
     * This is the method used to find the maze if solvable or not. It 
     * uses step to recur through the whole maze until it reaches a conclusion
     * of it can complete a path or if there was a stalemate.
     */
    public void solve()
    {
    	add(secondMaze.getStart());
        while (!isSolved(thisMaze))
        {
            step();
            if (isEmpty() && secondMaze.getExit().getSquarePrevious() == null) 
            {	
            	solveable = false;
            	break;
            }
        }
        if(isSolved(secondMaze))
        {
	        isSolved = true;
	        solveable = true;
        }
    }

    /**
     * Checks to see if a path has been found or not which in turn checks 
     * the state of the maze(Solved, Unsolvable, and Not yet Solved)
     * @return - the current state of the maze's path
     */
	public String getPath()
	{
		if(isSolved(secondMaze))
		{
			finalPath = "Solved";
		}
		else if(isSolved(secondMaze) == true && solveable == false)
		{
			finalPath = "Unsolvable";
		}
		else 
		{
			finalPath = "Not solved yet...";
		}
		return finalPath;
	}
}
