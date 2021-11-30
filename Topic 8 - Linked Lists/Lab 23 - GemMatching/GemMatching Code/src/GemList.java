public class GemList 
{
    private int size;
    private Node head;
    private Node tail;

    /**
     * The LinkedList node of gem
     */
	private class Node
    {
        public Gem gem;
        public Node next;

        @SuppressWarnings("unused")
		public Node()
        {
            gem = null;
            next = null;
        }

        public Node(Gem gem)
        {
            this.gem = gem;
            next = null;
        }
    }
   
	/**
	 * Initializes size, tail, and head
	 */
    public GemList()
    {
        size = 0;
        tail = null;
        head = null;
    }

    /**
     * Inserts the gem into the Linked list with the given index
     * @param gem - gem inserted
     * @param index - index where gem is put
     */
    public void insertBefore(Gem gem, int index)
    {
        Node gemNode = tail;
        if (index == 0 || size == 0) 
        {
            tail = new Node(gem);
            if (size != 0)
                tail.next = gemNode;
            else
            	head = tail;
            size++;
        }

        else if (index >= size) 
        {
            head.next = new Node(gem);
            gemNode = head.next;
            head = gemNode;
            
            size++;
        }
        else 
        {
            for(int i = 0; i < index-1; i++)
                gemNode = gemNode.next;
            
            Node gemNode2 = gemNode.next;
            gemNode.next = new Node(gem);
            gemNode.next.next = gemNode2;
            
            size++;
        }
    }

    /**
     * The size of the linkedList of gems
     * @return - size of linked list
     */
    public int size()
    {
        return size;
    }

    /**
     * The proper format of the gem
     * @return the toString of each gem;
     */
    @Override
    public String toString()
    {
        String str = "[";
        Node gemNode = tail;
        for(int i = 0; i < size; i++)
        {
            str += gemNode.gem.toString()+ " ";
            gemNode = gemNode.next;
        }
        str += "]";
        return str;
    }

    /**
     * Draws all gems in the list using given the y coordinate
     * @param y - y coordinate
     */
    public void draw(double y)
    {
        int count = 0;
        Node gemNode = this.tail;
        while(gemNode != null)
        {
            gemNode.gem.draw(GemGame.indexToX(count), y);
            gemNode = gemNode.next;
            count++;
        }
    }

    /**
     * Calculates the total score of the list using all of the appropriate
     * rules of the game
     * @return Proper score the gems in the linkedList
     */
    public int score ()
    {
        int score = 0;
        Node gemNode = tail;
        if(this.size == 0)
        {
            return 0;
        }
            GemType gemNodeType = tail.gem.getType();
            int count = 0;
            int scoreTwo = 0;
            for(int i = 0; i < size(); i++) 
            {
                Gem gemNodeGem = gemNode.gem;
                if(gemNodeGem.getType() == gemNodeType)  
                {
                    count++; 
                    scoreTwo += gemNodeGem.getPoints(); 
                }
                else
                {
                    gemNodeType = gemNode.gem.getType();
                    score += scoreTwo * count;
                    count = 1;
                    scoreTwo = gemNodeGem.getPoints();
                }
                gemNode = gemNode.next;
            }
            score += scoreTwo * count;
        return score;

    }
	
	public static void main(String [] args)
	{	
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
		
	}	
}
