/**
 * Lab 13 - MyHashTable<T>
 * Hash table structure with separate chaining.
 * @author geoffwacker
 * @id gwacker
 * 11.08.15
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<T>
{
	//Instance variables.
	LinkedList<T>[] table;

	//Constructor.
	public MyHashTable(int size)
	{
		//Create an array of LinkedList<T> objects of the given size.
		table = (LinkedList<T>[]) new LinkedList[size];
		
		//Initialize all array entries as empty linked lists.
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList<T>();
		}
	}
	
	/**
	 * FInd the hash value of a given item in our table.
	 * @param item the item we're looking for in the table.
	 * @return the int hash value of the item for the table.
	 */
	private int hash(T item)
	{
		return item.hashCode() % table.length;
	}
	
	/**
	 * Add a certain item to the table.
	 * @param item the item we'd like to add to the table.
	 */
	public void insert(T item)
	{
		table[hash(item)].addFirst(item);
	}
	
	/**
	 * Delete a certain item from the table.
	 * @param item the item we'd like to delete from the table.
	 */
	public void delete(T item)
	{
		table[hash(item)].remove(item);
	}
	
	/**
	 * Find a certain item in the table.
	 * @param item the item we'd like to find in the table.
	 * @return if the item was found or not.
	 */
	public boolean find(T item)
	{
		return table[hash(item)].contains(item);
	}
	
	/**
	 * Check if the table is empty.
	 * @return if the table is empty or not.
	 */
	public boolean isEmpty()
	{
		//Loop while we still have entries in the table.
		for (int i =0; i<table.length; i++)
		{
			//If any of the lists in the table are empty, return false.
			if(table[i].size() != 0)
			{
				return false;
			}
		}
		
		//Must not be empty.
		return true;
	}
	
	/**
	 * Print out the hash table.
	 */
	public void print()
	{
		//Loop while we still have entries in our table.
		for (int i = 0; i < table.length; i++)
		{
			//Print the line numbers.
			System.out.print(i + ": "); 
	         
			//Print all the values at the current level, separated by spaces.
			for (int j = 0; j < table[i].size(); j++)
			{
				System.out.print(table[i].get(j) + " ");
			}
	         
			//Line for spacing.
			System.out.println();
	      }
	}
	
	/**
	 * Make the table empty.
	 */
	public void makeEmpty()
	{
		for(int i = 0; i < table.length; i++)
		{
			table[i].clear();
		}
	}
	
	/**
	 * Find the size of the table.
	 * @return the size of our table.
	 */
	public int size()
	{
		//Variable to store size.
		int size = 0;
		
		//Loop through table until we reach the end, adding the size of each list.
		for(int i = 0; i < table.length; i++)
		{         
			size+= table[i].size();
		}
		
		//Return the size.
		return size;
	}
	
	//Nested iterator class.
	private class Iter implements Iterator<T>
	{
		//Instance variables.
		int i;
		int j;
		
		//Iterator constructor.
		public Iter()
		{
			//Initialize variables.
        	i = 0;
        	j = 0;
            	
        	//Search for a non-empty list in the array, and set i to the table length.
        	while(i < table.length && table[i].size() <= 0)
        	{
        		i++;
        	}
  
		}
		
		/**
		 * Return true if there is another element.
		 */
		public boolean hasNext()
		{
			return i < table.length;
		}
		
		/**
		 * Return the next element.
		 */
		public T next() throws NoSuchElementException
		{
			//No more elements to visit, so throw a NoSuchElementException.
			if (!hasNext()) 
			{
				throw new NoSuchElementException();
			}
			
			//Grab the next value of this list.
			T next = table[i].get(j);
			
			//Update j to the next element we'll visit in this list.
			if (j < table[i].size() - 1) 
			{
				j++;
			}
			
			//We don't have another element to visit in our current list.
			else 
			{
				j = 0;
				i++;
				
				//Go through the rest of the lists.
				while(hasNext() && (table[i].size() == 0)) 
				{
					i++;
				}
			}
			
			//Return the next element.
			return next;
		}
		
		//Remove is not supported, so throw an UnsupportedOperationException.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
	/**
	 * Create an Iterator object.
	 * @return the Iterator object. 
	 */
	public Iter iterator()
	{
		return new Iter();
	}
}