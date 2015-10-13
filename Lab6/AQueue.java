/**
 * Lab 06 - AQueue<T>
 * @author geoffwacker, kevinliu
 * 10.13.15
 */

import java.util.*;


public class AQueue<T> 
{
	//Instance variables.
	private T[] arr;
	private int front;
	private int end;
	private int count;

	//Initializes an empty queue.
	public AQueue(int size)
	{
		arr = (T[ ]) new Object[size];
		front = 0;
		end = -1;
		count = 0;
	}
	
	//Nested exception class with two constructors.
	public static class MyException extends RuntimeException
	{
		//Create empty exception.
		public MyException()
		{
			super();
		}
			
		//Create exception with a message.
		public MyException(String message)
		{
			super(message);
		}	
	}
	
	/**
	 * Insert a new item into the queue.
	 * @param item the item to insert.
	 */
	public void enqueue(T item)
	{
		//Check if queue is full.
		if (count == arr.length)
		{
			//Create an array that is double the size and then copy the stack to it.
			T[] doubleArr = (T[ ]) new Object[arr.length*2];
			
			//Go through original array and copy all items over to the double array.
			for (int i = 0; i < count; i++)
			{
				doubleArr[i] = arr[front];
				front = (front+1) % arr.length;
			}
			
			//Adjust front and end indexes.
			front = 0;
			end = count-1;
			
			//Make our original array the double array.
			arr = doubleArr;
		}
		
		//wraparound
		end = (end+1) % arr.length;
		
		//Queue isn't full, so add the item and increment count.
		arr[end] = item;
		count++;
	}
	
	/**
	 * Remove and return the last added item.
	 * @return the last added item.
	 * @throws MyException if the queue is empty.
	 */
	public T dequeue()
	{
		//If the queue is empty, throw an exception.
		try
		{
			if (isEmpty())
			{
				throw new MyException();
			}		
		}
				
		//Catch the exception and print a message.
		catch (MyException e)
		{
			System.out.println("Invalid operation: the queue is empty.");
		}
				
		//The queue isn't empty, so carry on.
		if (!isEmpty())
		{
			//Grab the item to dequeue.
			T item = arr[front];
			
			//Replace it with null.
			arr[front] = null;
			
			//increment front.
			front = (front+1) % arr.length;
			
			//Decrement count.
			count--;
			
			//Return the item.
			return item;
		}
				
		//Return null to handle the exception case.
		return null;
	}
	
	/**
	 * Test if the queue is logically empty (count = 0).
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	/**
	 * For testing purposes, print the content of the whole array.
	 */
	public void printArray()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		//Print a blank line to make things look nice.
		System.out.println();
	}
}