/**
 * Project 01 - MyStack<T>
 * @author geoffwacker, kevinliu
 * @id gwacker, 
 * 10.04.15
 */
package com.company;
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
	//

	/**
	 * Insert a new item at the top of the stack.
	 * @param item the item to insert.
	 */
	public void push(T item)
	{
		Node input = new Node();
		input.item = item;
		input.next = first;
		first = input;
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
		else{
			T peekReturn = first.item;
			return peekReturn;
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
