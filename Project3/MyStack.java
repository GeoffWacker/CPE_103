/**
 * Project 03 - MyStack<T>
 * Implementation of a generic stack.
 * @author geoffwacker
 * @id gwacker
 * 10.28.15
 */

import java.util.*;

public class MyStack<T> 
{
	//Instance variables.
	private Node first;
	
	//Nested node class.
	private class Node
	{
		public T item;
		public Node next;
	}
	
	//Constructor for an empty stack.
	public MyStack()
	{
		first = null;
	}

	/**
	 * Insert a new item at the top of the stack.
	 * @param item the item to insert.
	 */
	public void push(T item)
	{
		Node pushNode = new Node();
		pushNode.item = item;
		
		//If the first is null, make our item the first node.
		if (first == null)
		{
			first = pushNode;
		}
		
		//The stack isn't empty, so insert.
		else
		{
			pushNode.next = first;
			first = pushNode;
		}
	}

	/**
	 * Remove the top item from the stack and return it.
	 * @return the item that was on top of the stack.
	 */
	public T pop()
	{
		//Check if the stack is empty.
		if (isEmpty())
		{
			throw new EmptyStackException();
		}

		//It's not empty, so continue.
		else
		{
			T popReturn = first.item;
			first = first.next;
			return popReturn;
		}
	}

	/**
	 * Return the top element without removing it.
	 * @return the item that is currently on top of the stack.
	 */
	public T peek()
	{
		//Check if the stack is empty.
		if (isEmpty())
		{
			throw new EmptyStackException();
		}

		//It's not empty, so continue.
		else
		{
			return first.item;
		}
	}

	/**
	 * Determine if the stack is empty or not.
	 * @return True or false if the stack is empty.
	 */
	public boolean isEmpty()
	{
		//If first is null, we know it's empty.
		return first == null;
	}
}