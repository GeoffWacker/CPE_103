/**
 * Project 04 - HashTable ADT
 * Hash Table ADT with Open Addressing and Quadratic Probing
 * @author geoffwacker
 * @id gwacker
 * 11.16.15
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable 
{
	//Instance variables.
	private HashEntry[] table;
	private int numOccupied;
	
	//Nested private HashEntry class.
	private class HashEntry
	{
		//Instance variables.
		public Object element;
		public boolean isActive;
		
		//Constructor for HashEntry.
		private HashEntry(Object item)
		{
			element = item;
			isActive = true;
		}
	}
	
	//Constructor for an empty HashTable.
	public HashTable(int numElements)
	{
		table = new HashEntry[nextPrime(2 * numElements)];
		numOccupied = 0;
	}
	
	/**
	 * Helper method for the HashTable constructor that finds the next prime number after a given number.
	 * @param num the number we'll use to find the next prime number after.
	 * @return the next prime number after the given input.
	 */
	private static int nextPrime(int num)
	{
		//If even, iterate.
		if (num % 2 == 0)
		{
			num++;
		}
		
		//Number isn't prime yet, so add 2 to it.
		while (!isPrime(num))
		{
			num += 2;
		}
		
		//Return the next prime number.
		return num;
	}
	
	/**
	 * Helper method for nextPrime, determines if a given number is prime or not.
	 * @param num the number we'd like to check if prime or not.
	 * @return True if the given number is a prime, false otherwise.
	 */
	private static boolean isPrime(int num)
	{
		//It's an even number (multiple of 2), so it can't be prime.
		if (num % 2 == 0)
		{
			return false;
		}
		
		//Loop through odds starting at 3.
		for (int i = 3; i*i <= num; i += 2)
		{
			//If the number is cleanly divisible, it's not a prime.
			if (num % i == 0)
			{
				return false;
			}
		}
		
		//Must be a prime.
		return true;
	}
	
	//Nested private iterator class.
	private class Iter implements Iterator
	{
		//Instance variable.
		public int cursor = 0;
		
		public Iter() 
		{
			//Initialize to zero.
			cursor = 0;	
	         
			//Move the cursor to the first active entry in the table. While we still have entries, and the current entry isn't null or not active, iterate the cursor.
			while (cursor < table.length && (table[cursor] == null || !table[cursor].isActive)) 
			{
				cursor++;
			}
		}

		//Check if have another element.
		public boolean hasNext() 
		{
			return cursor < table.length;
		}

		//Return the next element.
		public Object next() 
		{
			//We don't have a next element, so throw an exception.
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			//Grab the next element.
			Object nextElement = table[cursor].element;
			
			//Advance the cursor.
			cursor++;
			
			//Keep iterating the cursor until we get to another valid element.
			while (cursor < table.length && (table[cursor] == null || !table[cursor].isActive)) 
			{
				cursor++;
			}
			
			return nextElement;
		}
		
		//Remove is not supported, so throw an UnsupportedOperationException.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Insert the specified item into the table.
	 * @param item the item we'd like to insert.
	 */
	public void insert(Object item)
	{
		//Get the position of where this item would be in the table.
		int index = findPosition(item);
		
		//If their isn't an element there.
		if(table[index] == null)
		{
			//Create a new element there.
			table[index] = new HashEntry(item);
			
			//Iterate numOccupied.
			numOccupied++;
			
			//We don't have enough space in the table, so we need to make the table bigger.
			if(numOccupied >= table.length / 2)
			{
				rehash();
			}
		}
	    
		//There's already an element there.
		else
		{
			//The element isn't active, so make it active now.
			if(table[index].isActive == false)
			{
				table[index].isActive = true;
			}
		}
	}
	
	/**
	 * Helper method for insert, makes the table equal to the first prime number greater than or equal to twice the original size.
	 */
	private void rehash() 
	{
		//Temporarily store the old table.
		HashEntry[] temp = table;
		
		//Increase the size of the original table and reset numOccupied.
		table = new HashEntry[nextPrime(2*table.length)];
		numOccupied = 0;
	      
		//Loop through the original table.
		for(int i = 0; i < temp.length; i++) 
		{
			//If we have a valid, active entry, insert it into the new, larger table.
			if(temp[i] != null && temp[i].isActive) 
			{
				insert(temp[i].element);
			}
		} 
	}
	
	/**
	 * Delete the specified item from the table.
	 * @param item the item we'd like to delete.
	 */
	public void delete(Object item)
	{
		//Get the position of where this item would be in the table.
		int index = findPosition(item);
		
		//The element is there, so deactivate it.
		if(table[index] != null)
		{
			table[index].isActive = false;
		}
	}
	
	/**
	 * Find and retrieve the specified item.
	 * @param item the item we'd like to find.
	 * @return the element of the collection, or null if not found.
	 */
	public Object find(Object item)
	{
		//Get the position of where this item would be in the table.
		int index = findPosition(item);
		
		//If we have an active entry, return it.
		if(table[index] != null && table[index].isActive)
		{
			return item;
		}
		
		//We didn't find it, so return null.
		else
     	{
			return null;		 
     	}
	}
	
	/**
	 * Find the number of elements in the collection.
	 * @return the number of elements in the collection.
	 */
	public int elementCount()
	{
		//Integer to hold the current count.
		int count = 0;
		
		//Iterate through the table.
		for(int i = 0; i < table.length; i++)
		{
			//Find all ACTIVE entries in the table.
			if(table[i] != null && table[i].isActive == true)
			{
				count++;
			}
		}
		
		//Return the total number of active elements.
		return count;
	}
	
	/**
	 * Check if the collection is empty or not.
	 * @return true if the collection is empty.
	 */
	public boolean isEmpty()
	{
		return elementCount() == 0;
	}
	
	/**
	 * Clear the contents of the table (no occupied cells in the table).
	 */
	public void makeEmpty()
	{
		//Make the table empty by creating a new one of the same length, and then overwriting the old one.
		table = new HashEntry[table.length];
	}
	
	/**
	 * Print the entire contents of the table, including unoccupied cells, as well as cells with inactive entries.
	 */
	public void printTable()
	{
		//Loop through the entire table.
		for( int i = 0; i <table.length; i++)
		{
			//Print the line number.
			System.out.print("[" + i + "]: ");
	        
			//If we have a valid element, print it out with active/inactive.
			if(table[i] != null)
			{
				System.out.print(table[i].element);
	            
	            if(table[i].isActive)
	            {
	            	System.out.println(", active");
	            }
	            
	            else
	            {
	            	System.out.println(", inactive");
	            }
			}	
			
			//There's nothing there, so print empty.
			else
        	{
				System.out.println("empty");
            }
		}
		
		//Print line for spacing.
		System.out.println();
	}
	
	/**
	 * Create a new Iter object for the collection.
	 * @return
	 */
	public Iterator iterator()
	{
		return new Iter();
	}
	
	/**
	 * Helper method for insert, delete, and find. Uses quadratic probing to find index of an object.
	 * @param x the item we'd like to find the position of in the table.
	 * @return the position of the item.
	 */
	private int findPosition(Object x) 
	{
		//Counter variable.
		int i = 0;
	      
		//Get the hashCode of the input.
		int hashCode = Math.abs(x.hashCode()) % table.length;
      
		//Store the hashCode as the current index so we can work with it.
		int index = hashCode;
      
		//Loop until we get to the right position.
		while(table[index] != null && !x.equals(table[index].element)) 
		{
			i++;
			index = (hashCode + i*i) % table.length;
		}

		return index;
	}
}