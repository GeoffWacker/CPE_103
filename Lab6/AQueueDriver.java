/**
 * Lab 06 - AQueueDriver
 * @author geoffwacker, kevinliu
 * 10..15
 */

import java.util.*;
import java.util.Scanner;

public class AQueueDriver extends AQueue
{
	//Eclipse added this to fix bug.
	public AQueueDriver(int size) 
	{
		super(size);
	}

	public static void main(String [ ] args)
	{
		//Variable declaration.
		char input = 'a';
		
		//Create an empty integer queue.
		AQueue<Integer> intQueue = new AQueue<Integer>(5);
		
		//Create a scanner.
		Scanner in = new Scanner(System.in);
		
		//Loop to ask for input.
		while (input != 'q')
		{
			System.out.println("Choose one of the following operations: ");
			System.out.println("- enqueue/add (enter the letter a) ");
			System.out.println("- dequeue/delete (Enter the letter d) ");
			System.out.println("- check if the list is empty (enter the letter e) ");
			System.out.println("- print the entire array (Enter the letter p) ");
			System.out.println("- quit (enter the letter q) ");
			input = in.nextLine().charAt(0);
			
			//Switch statement to handle input.
			switch (input)
			{
				//User wants to add.
				case 'a':
				{
					System.out.println("What would you like to add?");
					try
					{
						int enqueueInput = in.nextInt();
						intQueue.enqueue(enqueueInput);
						System.out.println(enqueueInput + " enqueued");
						in.nextLine();
						break;
					}
					catch (InputMismatchException i)
					{
						System.out.println("Invalid enqueue input!");
						in.nextLine();
						break;
					}
				}
				
				//User wants to remove.
				case 'd':
				{
					Integer intQueueOutput = intQueue.dequeue();
					if (intQueueOutput == null)
					{
						break;
					}
					else
					{
						System.out.println(intQueueOutput + " dequeued");
						break;
					}	
				}
				
				//User wants to see if queue is empty.
				case 'e':
				{
					System.out.println(intQueue.isEmpty());
					break;
				}
				
				//User wants to print the array.
				case 'p':
				{
					intQueue.printArray();
					break;
				}
				
				//User wants to quit.
				case 'q':
				{
					in.close();
					//Empty the queue, one value at a time, separated by spaces.
					while (!intQueue.isEmpty())
					{
						System.out.print(intQueue.dequeue() + " ");
					}
					break;
				}
				
				//User entered invalid input.
				default:
				{
					System.out.println("Invalid menu input!");
					break;
				}	
			}	
		}	
	}
}