/**
 * Lab 14 - RunTimes
 * Driver for Algorithms to test run times of different algorithms.
 * @author geoffwacker
 * @id gwacker
 * 11.13.15
 */

public class RunTimes 
{
	public static void main(String[] args)
	{	
		//Print for logarithm.
		System.out.println("Logarithmic algorithm’s running times:");
		
		//Logarithm print loop.
		for (long N = 10000; N < 100000000; N = 2*N)
		{
			//Get start time in nanoseconds.
			long startTime = System.nanoTime();
			
			//Call logarithm function.
			Algorithms.logarithmicAlgTime(N);
			
			//Get end time in nanoseconds.
			long endTime = System.nanoTime();
			
			//Calculate running time.
			long runningTime = (endTime - startTime) / 1000000;
			
			//Print the output.
			System.out.println("T(" + N + ") = " + runningTime);
		}
		
		//Print for linear.
		System.out.println("Linear algorithm’s running times:");
		
		//Linear print loop.
		for (long N = 10000; N < 100000000; N = 2*N)
		{
			//Get start time in nanoseconds.
			long startTime = System.nanoTime();
			
			//Call linear function.
			Algorithms.linearAlgTime(N);
			
			//Get end time in nanoseconds.
			long endTime = System.nanoTime();
			
			//Calculate running time.
			long runningTime = (endTime - startTime) / 1000000;
			
			//Print the output.
			System.out.println("T(" + N + ") = " + runningTime);
		}
		
		//Print for NlogN.
		System.out.println("NlogN algorithm’s running times:");
				
		//NlogN print loop.
		for (long N = 10000; N < 100000000; N = 2*N)
		{
			//Get start time in nanoseconds.
			long startTime = System.nanoTime();
			
			//Call NlogN function.
			Algorithms.NlogNAlgTime(N);
			
			//Get end time in nanoseconds.
			long endTime = System.nanoTime();
			
			//Calculate running time.
			long runningTime = (endTime - startTime) / 1000000;
			
			//Print the output.
			System.out.println("T(" + N + ") = " + runningTime);
		}
		
		//Print for quadratic.
		System.out.println("Quadratic algorithm’s running times:");
		
		//Quadratic print loop.
		for (long N = 10000; N < 800000; N = 2*N)
		{
			//Get start time in nanoseconds.
			long startTime = System.nanoTime();
			
			//Call quadratic function.
			Algorithms.quadraticAlgTime(N);
			
			//Get end time in nanoseconds.
			long endTime = System.nanoTime();
			
			//Calculate running time.
			long runningTime = (endTime - startTime) / 1000000;
			
			//Print the output.
			System.out.println("T(" + N + ") = " + runningTime);
		}
	}
}