
public class Enum101
{
	Day day;
	
	//Constructor
	public Enum101(Day day)
	{
		this.day = day;
	}
	
	public void dayIsLike()
	{
		switch(day)
		{
			case MONDAY:
				System.out.println("Mondays are awful");
				break;
			case FRIDAY:
				System.out.println("Fridays are pog");
				break;
			case SATURDAY:
			case SUNDAY: 
				System.out.println("Weekends are the best");
				break;
			default:
				System.out.println("Mid-week days are meh");
				break;
		}
	}
	
	public void isItWeekEnd()
	{
		Day d1 = Day.valueOf("SATURDAY");
		Day d2 = Day.valueOf("SUNDAY");
		if(day == d1 || day == d2)
		{
			System.out.println("Time to get lit!!!");
		}
		else 
			System.out.println("Get back to work!");
			
		
	}
	
	public static void main(String[] args)
	{
		String str = "SATURDAY";
		
		Enum101 t1 = new Enum101(Day.valueOf(str));
		
		t1.dayIsLike();
		t1.isItWeekEnd();		
		
	}
}
