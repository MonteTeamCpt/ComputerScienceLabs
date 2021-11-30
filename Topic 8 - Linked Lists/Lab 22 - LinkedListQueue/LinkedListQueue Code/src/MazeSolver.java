import java.util.*;

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
    public boolean isSolved()
	{
		if (secondMaze.getExit().getSquarePrevious() == null)
			return false;
		else
		{
			Square pathBuilder = secondMaze.getExit().getSquarePrevious();
			while (pathBuilder.getType() != 2 && pathBuilder.getType() != 1)
			{
				pathBuilder.setType(6);
				pathBuilder = pathBuilder.getSquarePrevious();
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
		while (!isSolved())
		{
			step();
			if (this.isEmpty() && secondMaze.getExit() == null)
				break;
		}

	}

    /**
     * Checks to see if a path has been found or not which in turn checks 
     * the state of the maze(Solved, Unsolvable, and Not yet Solved)
     * @return - the current state of the maze's path
     */
	public String getPath()
	{
		if (isEmpty() && !isSolved())
			return "Unsolvable :(";
		// check to see if the type is equal to 6 (on_path)
		if (!isSolved())
		{
			return "Solving...";
		}
		else
		{
			Square current = this.secondMaze.getExit();
			ArrayList<ArrayList<Integer>> finalPath = new ArrayList<ArrayList<Integer>>();
			
			while(current != null)
			{
				ArrayList<Integer> cord = new ArrayList<Integer>();
				cord.add(current.getRow());
				cord.add(current.getCol());
				finalPath.add(cord);
				current = current.getSquarePrevious();
			}
			Collections.reverse(finalPath);
			
			return "Solved!" + finalPath.toString();
		}
	}
}
