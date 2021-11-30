
public class Person
{
	private String name;
	
	public Person(String name)
	{
		this.name = name;
	}

	public int hashCode()
	{
		return (name.length()) % 10;
	}

	public boolean equals(Object obj)
	{
		Person temp = (Person) obj;
		if(temp.name == name)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return name;
	}
}
