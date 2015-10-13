/**
 * Lab 06 - AQueueClient
 * @author geoffwacker, kevinliu
 * 10.13.15
 */

import java.util.*;

public class AQueueClient 
{
	public static void main(String [ ] args)
	{
		//Create a float queue.
		AQueue<Float> floatQueue = new AQueue<Float>(5);
		
		//Create the scanner.
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter some numeric values to add to the queue: ");
		//Gather input add enqueue.
		while (in.hasNext())
		{
			if (in.hasNextFloat())
			{
				floatQueue.enqueue(in.nextFloat());
			}
		}
		
		//Output line.
		System.out.print("Here are the queue values: ");
		//Empty queue and output on one line.
		while (!floatQueue.isEmpty())
		{
			System.out.print(floatQueue.dequeue() + " ");
		}
		
		//close the scanner since we're done.
		in.close();
	}
}