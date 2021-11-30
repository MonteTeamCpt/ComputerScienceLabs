
public class Tour 
{
	private Node head;
	private int size;
	
	/**
	 * Creates a class that is a fundamental part of the linked list
	 */
	private class Node
	{
		Point P;
		Node next;		
		
		public Node(Point P)
		{
			this.P = P;
			this.next = null;
		}
	}
	
	/** create an empty tour */
	public Tour()
	{
		head = null;
	}
	
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		
		Node na = new Node(a);
		head = na;
		
		Node nb = new Node(b);
		head.next = nb;
		
		Node nc = new Node(c);
		head.next.next = nc;
		
		Node nd = new Node(d);
		head.next.next.next = nd;
		
		Node nat = new Node(a);
		head.next.next.next.next = nat;
		
		head.next.next.next.next.next = null;
		
	}
	
	/** print tour (one point per line) to std output */
	public void show()
	{
		Node show = head;
		while(show.next != null)
		{
			System.out.println(show.P.toString());
			show = show.next;
		}
		System.out.println();
	}
	
	/** draw the tour using StdDraw */
	public void draw()
	{
		Node show = head;
		
		while(show.next != null)
		{
			show.P.drawTo(show.next.P);
			show = show.next;
		}
	}
	
	/** return number of nodes in the tour */
	public int size()
	{
		return size;
	}
	
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		double dis = 0;
		Node show = head;
		
		while(show.next != null)
		{
			dis += show.P.distanceTo(show.next.P);
			show = show.next;
		}
		
		return dis;
	}
	
	/** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
    	double nearDist = 0;
		Node comp = new Node(p); 
		Node nextNode = head; 
		Node nearNode = nextNode; 

		while(nextNode != null)
		{
			double dist = nextNode.P.distanceTo(comp.P); 
			if (dist < nearDist || nearDist == 0) 
			{
				nearNode = nextNode; 
				nearDist = dist;
			}
			nextNode = nextNode.next;
		}
		
		if (nearNode != null) 
		{
			Node end = nearNode.next; 
			nearNode.next = comp;
			comp.next = end;
		}
		else
			head = comp; 
		
		size++;
    }

	/** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
    	if(size == 0)
		{
			head = new Node(p);
			head.next = null;
		}
		else
		{
			double smallDist = Double.MAX_VALUE;
			int smallNode = -1;
			int nextNode = 0;
			
			Node comp = head;
			Node point = new Node(p);
			
			while(comp != null) 
			{
				Node compNext = comp.next;
				point.next = compNext;
				comp.next = point;
				double distance = this.distance();
				
				if(distance < smallDist)
				{
					smallNode = nextNode;
					smallDist = distance;
				}
				
				comp.next = compNext;
				nextNode++;
				comp = comp.next;
		}
			comp = this.head;
			Node tempNext = comp.next;
			
			while(smallNode != 0)
			{
				comp = comp.next;
				tempNext = comp.next;
				smallNode--;
			}
			
			point.next = tempNext;
			comp.next = point;
		}
		size++;
    }

	
	public static void main(String[] args)
	{
		//define 4 points forming a square
		 Point a = new Point(100.0, 100.0);
		 Point b = new Point(500.0, 100.0);
		 Point c = new Point(500.0, 500.0);
		 Point d = new Point(100.0, 500.0);
		 
		 Tour squareTour = new Tour(a, b, c, d);
		 
		squareTour.show();
		
		System.out.println(squareTour.distance() + "\n");
		
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		
		squareTour.draw();

	}
    
}