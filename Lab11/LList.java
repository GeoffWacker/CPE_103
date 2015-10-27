/**
 * Lab 11 - LList<T>
 * Generic linked list using iterators.
 * @author geoffwacker
 * 10.27.15
 */

import java.util.*;

public class LList<T> 
{
	//Instance variables.
	private Node head;
	
	//Nested private Node class.
	private class Node
	{
		//Instance variables.
		public T element;
		public Node next;
		
		//Construct a node with the specified element.
		public Node(T element)
		{
			this.element = element;
			next = null;
		}
	}
	
	//Nested private iterator class.
	private class Iter implements Iterator<T>
	{
		//Instance variables.
		public Node cursor;
		
		//Constructor to point cursor at beginning of list.
		public Iter()
		{
			cursor = head;
		}
		
		//If cursor isn't equal to null, we must have another element.
		public boolean hasNext()
		{
			return cursor != null;
		}
		
		//Implementation of Iterator's next method.
		public T next()
		{
			//If we don't have another element, throw a NoSuchElementException.
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			//Get the next element, and update cursor.
            T next = cursor.element;
            cursor = cursor.next;
            
            //Return the next element.
            return next;
		}
		
		//Remove is not supported, so throw a UnsupportedOperationException.
		public void remove()
        {
            throw new UnsupportedOperationException();
        }
	}
	
	//Constructor to create an empty linked list.
	public LList()
	{
		head = null;
	}
	
	/**
	 * Method to create a new Iterator object.
	 */
	public Iterator<T> iterator()
	{
		return new Iter();
	}
	
	/**
	 * Insert a new item at the end of the list.
	 * @param item the element we want to add to the end of the list.
	 */
	public void add(T item)
	{
		//Create a temporary node to work with.
		Node tempNode = new Node(item);

		//List is empty, so insert the item at head.
        if (head == null)
        {
            head = new Node(item);
            tempNode.next = head;
        }
        
        //List is not empty.
        else
        {
        	//Create a current node.
            Node current = head;
            
            //Keep looping until we don't have another element. (Where we want to insert)
            while (current.next != null)
            {
                current = current.next;
            }
            
            //The next element is going to be what we want to insert.
            current.next = tempNode;
        }
		
	}
}