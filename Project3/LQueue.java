/**
 * Project 03 - LQueue<T>
 * Linked list implementation of Queue ADT.
 * @author geoffwacker
 * @id gwacker
 * 10.28.15
 */

public class LQueue<T>
{
	//Instance variables.
	private Node front;
	private Node end;
	
	//Initializes an empty queue.
	public LQueue()
	{
		front = null;
		end = null;
	}
	
	//Node.
	private class Node
	{
		public T item;
		public Node next;
	}
	
	//Nested exception class with two constructors.
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}
		
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
		Node tempNode = new Node();
		tempNode.item = item;
		
		//The queue is empty, so make the front our item.
		if(front == null)
		{
			front = tempNode;
			end = front;
		}
		
		//The queue isn't empty, so insert the item after our last value.
		else
		{
			end.next = tempNode;
			end = tempNode;
		}
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
			T item = front.item;
			front = front.next;
			return item;
		}
		
		//Return null to handle the exception case.
		return null;
	}
	
	/**
	 * Test if the queue is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return front == null;
	}
}