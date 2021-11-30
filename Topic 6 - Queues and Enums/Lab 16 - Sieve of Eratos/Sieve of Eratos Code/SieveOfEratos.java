import java.util.*;

public class SieveOfEratos
{
	private Queue<Integer> eratos;
	private Queue<Integer> primes;
	
	/**
	 * Instantiates private Queue variables eratos and prunes
	 */
	public SieveOfEratos()
	{
		eratos = new LinkedList<Integer>();
		primes = new LinkedList<Integer>();
	}
	
	/**
	 * An algorithm for finding all prime numbers up to any given limit. It
	 * does so by iteratively marking as composite (i.e., not prime) the 
	 * multiples of each prime, starting with the first prime number, 2. 
	 * The multiples of a given prime are generated as a sequence of numbers 
	 * starting from that prime, with constant difference between them that is 
	 * equal to that prime.
	 * @param n - the number that we need to find the primes of
	 * @return The prime numbers of n
	 */
	public Queue<Integer> primes(int n)
	{
		
		if(n < 2)
			throw new IllegalArgumentException("Value must be 2 or greater!");
			
		for(int i = 2; i <= n; i++)
		{
			eratos.offer(i);
		}
		
		int num = eratos.poll();
		primes.offer(num);
		
		do
		{
			int size = eratos.size();
			for(int s = 0; s < size ; s++)
			{
				int ele = eratos.poll();
				
				if((ele % num) != 0)
					eratos.offer(ele);
			}

			num = eratos.poll();
			primes.offer(num);
			
		}while(num < Math.sqrt(n));
		
		while (eratos.size() != 1) 
		{
			num = eratos.poll();
			primes.offer(num);
		}
		
		return primes;
	}
}
