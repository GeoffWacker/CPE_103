/**
 * Lab 14 - Algorithms
 * Empirical analysis of algorithm run times.
 * @author geoffwacker
 * @id gwacker
 * 11.13.15
 */

public class Algorithms 
{
	/**
	 * "Dummy" algorithm of complexity O(N).
	 * @param N the "dummy" long we're using to test the algorithm.
	 */
	public static void linearAlgTime(long N)
	{
		int x;
		
		for(int i = 1; i < N; i++)
		{
			x = i;
		}
	}
	
	/**
	 * "Dummy" algorithm of complexity O(N^2).
	 * @param N the "dummy" long we're using to test the algorithm.
	 */
	public static void quadraticAlgTime(long N)
	{
		int x;
	      
		for(int i = 1 ; i <  N; i++)
		{
			for(int j = 1; j < N; j++)
			{
				x = i;
			}
		}
	}
	
	/**
	 * "Dummy" algorithm of complexity O(log N).
	 * @param N the "dummy" long we're using to test the algorithm.
	 */
	public static void logarithmicAlgTime(long N)
	{
		long x;
	      
		for(long i = N; i > 1; i = i/2)
		{
			x = i;
		}
	}
	
	/**
	 * "Dummy" algorithm of complexity O(N log N).
	 * @param N the "dummy" long we're using to test the algorithm.
	 */
	public static void NlogNAlgTime(long N)
	{
		long x;
		
		for(int i = 1; i < N; i++)
		{
			for(long j = N; j > 1; j = j/2)
			{
				x = j;
			}
		}
	}
}