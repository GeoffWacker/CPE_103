/**
 * Lab 05 - AStack<T>
 * @author geoffwacker, kevinliu
 * 10.12.15
 */

import java.util.*;

public class AStack<T> 
{
	//Instance variables.
	private T[] arr;
	private int top;
	
	//Create an empty stack.
	public AStack()
	{
		//When using generics for arrays, we need to cast.
				arr = (T[ ]) new Object();
				top = -1;
	}
	
	//Initialize a stack with a certain size.
	public AStack(int size)
	{
		//When using generics for arrays, we need to cast.
		arr = (T[ ]) new Object[size];
		top = -1;
	}
	
	/**
	 * Insert a new item at the top of the stack.
	 * @param item the item to insert.
	 */
	public void push(T item)
	{
		//Stack is full, so copy to an array that is twice the size.
		if (top + 1 == arr.length)
		{
			//Create an array that is double the size and then copy the stack to it.
			T[] doubleArr = (T[ ]) new Object[arr.length*2];
			
			//Go through original array and copy all items over to the double array.
			for (int i = 0; i < arr.length; i++)
			{
				doubleArr[i] = arr[i];
			}
			
			//Make our original array the double array.
			arr = doubleArr;
		}
		
		//Increment top and then insert the item.
		top++;
		arr[top] = item;
	}
	
	/**
	 * Remove the top item from the stack and return it.
	 * @return the item that was on top of the stack.
	 */
	public T pop()
	{
		try
		{
			//Check if the stack is empty.
			if (isEmpty())
			{
				throw new EmptyStackException();
			}
		}
		
		catch (EmptyStackException e)
		{
			System.out.println("Invalid operation: the stack is empty!");
		}
		
		//It's not empty, so continue.
		if (!isEmpty())
		{
			
			//Get the top item.
			T popReturn = arr[top];
			
			//Decrement top.
			top--;
			return popReturn;
		}
		
		//Handle empty stack case.
		return null;
	}
	
	/**
	 * Return the top element without removing it.
	 * @return the item that is currently on top of the stack.
	 */
	public T peek()
	{
		try
		{
			//Check if the stack is empty.
			if (isEmpty())
			{
				throw new EmptyStackException();
			}
		}
		
		catch (EmptyStackException e)
		{
			System.out.println("Invalid operation: the stack is empty!");
		}
		
		//It's not empty, so continue.
		if (!isEmpty())
		{
			return arr[top];
		}
		
		//Handle empty stack case.
		return null;
	}
	
	/**
	 * Determine if the stack is empty or not.
	 * @return True or false if the stack is empty.
	 */
	public boolean isEmpty()
	{
		//If top is equal to -1, we know it's empty.
		return top == -1;
	}
}