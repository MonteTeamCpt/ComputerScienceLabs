
public class Square
{
	//These values are used to denote what type of Square this is in the maze
	final static int EMPTY 	   = 0; //an empty
	final static int WALL  	   = 1; //a wall
	final static int START	   = 2; //the start
	final static int EXIT      = 3; //the exit
	final static int WORKLIST  = 4;// Currently on the work list(the s
	final static int EXPLORED  = 5; //done, already explored
	final static int FINALPATH = 6; //on the exit path, used in a later lab
	
	private int row, col; //r, c location in the maze
	private int type, finalType;     //type of this square, e.g. working explored, etc, for the GUI
	private char status;  //current status of this square, e.g. working, explored, etc, for the GUI
	private Square squarePrevious;

	/**
	 * Instantiates row, col, and type
	 * @param row - Integer value of row val
	 * @param col - Integer value of col val
	 * @param type - Integer value of square status
	 */
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		finalType = type;
		squarePrevious = null;
	}
	// returns row
	public int getRow()
	{return row;}
	// returns col
	public int getCol()
	{return col;}
	// returns type
	public int getType()
	{return type;}
	// returns status
	public char getStatus()
	{return status;}
	
	/**
	 * Sets row equal to r
	 * @param r - given int value
	 */
	public void setRow(int r)
	{row = r;}

	/**
	 * Sets col equal to c
	 * @param c - given int value
	 */
	public void setCol(int c)
	{col = c;}
	
	/**
	 * Sets type equal to t
	 * @param t - given int value
	 */
	public void setType(int t)
	{type = t;}
	
	/**
	 * Sets status equal to s
	 * @param r - given chat value
	 */
	public void setStatus(char s)
	{status = s;}
	
	//resets Type to its original value
	public void resetType()
    {type = finalType;}
	
	/**
	 * Sets the previousSquare to s
	 * @param s - given square object
	 */
	public void setSquarePrevious(Square s)
	{squarePrevious = s;}
	
	//returns the SquarePrevious
	public Square getSquarePrevious()
	{return squarePrevious;}
	
	/**
	 * Checks to see if the square has/can be checked
	 * @return if the square has been checked or not
	 */
	public boolean isMarked()
    {
        if(type == 4 || type == 5 || type == WALL)
        {
            return true;
        }else
        {
            return false;
        }
    }
	
	/**
	 * Checks to see of the given square is equal to the current Square
	 * @param obj - given square object
	 * @return - if the Square objects are the same or not, judging by
	 * 			 its col and row values
	 */
	public boolean equals(Square obj)
	{
		if(obj.getCol() == this.col && obj.getRow() == this.row)
			return true;
		return false;
	}
	
	/**
	 * Prints a String depending on the state of the square
	 */
	public String toString()
	{
		switch(type)
        {
            case EMPTY:
                return "_";
            case WALL:
                return "#";
            case START:
                return "S";
            case EXIT:
                return "E";
            case WORKLIST:
                return "o";
            case EXPLORED:
                return ".";
            case FINALPATH:
                return "x";
            default:
                return "~";

        }
	}

}
