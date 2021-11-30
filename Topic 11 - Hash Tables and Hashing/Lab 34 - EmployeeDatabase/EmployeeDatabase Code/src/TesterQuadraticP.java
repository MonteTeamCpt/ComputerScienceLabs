import java.io.*;
import java.util.*;

public class TesterQuadraticP
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String factors = "0.10 0.50 0.99";
		Scanner fact = new Scanner(factors);
		
		while(fact.hasNext())
		{
			double FACTOR = Double.parseDouble(fact.next());
			int records = 50000;
			int entries = (int) (records/FACTOR);

			EmployeeDatabaseQuadratic test = new EmployeeDatabaseQuadratic(entries);	
			
			Scanner scanOne = new Scanner(new File("Large Data Set.txt"));
		
			long buildTableTimerInitial= System.currentTimeMillis();
			while(scanOne.hasNextLine())
			{
				int ID = scanOne.nextInt();
				Employee e = new Employee(scanOne.nextLine().trim());
				
				test.put(ID, e);
			}
			long buildTableTimerFinal = System.currentTimeMillis();
			
			
			Scanner scanTwo = new Scanner(new File("Successful Search Records.txt"));
			
			long SuccessfulSearchInitial = System.currentTimeMillis();
			while(scanTwo.hasNextLine())
			{
				int ID = scanTwo.nextInt();
				scanTwo.nextLine();
				
				test.get(ID);
			}
			long SuccessfulSearchFinal = System.currentTimeMillis();
			
			//Report
			System.out.println("Type of hashing used: Quadratic PROBING");
			System.out.println("Hash function used: Multiply the keys together add 7 then modululy divide that by the size of the hashTable");
			System.out.println("Number of records added: " + records);
			System.out.println("Table Size: " + entries);
			System.out.println("Load Factor: " + FACTOR);
			System.out.println("Large Data Set");
			System.out.println("Average Insertion Time: " + ((double) (buildTableTimerFinal - buildTableTimerInitial) / records) + "ms");
			System.out.println("Successful Search Records");
			System.out.println("Average Search(get) Time: " + ((double) (SuccessfulSearchFinal - SuccessfulSearchInitial) / 1000) + "ms\n\n");
		}
	}
}
