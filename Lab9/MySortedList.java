/**
 * Lab 09 - MySortedList
 * @author geoffwacker, kevinliu
 * 10.21.15
 */

public class MySortedList 
{
	//Variable declaration.
	private Node head;
		
	//Nested class for node.
	private class Node
	{
		//Instance variables.
		public int element;
		public Node next;
		
		public Node(int element)
		{
			this.element = element;
			next = null;
		}
	}
	
	//Constructor to create an empty list.
	public MySortedList()
	{
		head = null;
	}
	
	/**
	 * Add an item in the proper location to keep the list in ascending order.
	 * @param item the item to add to the sorted list.
	 */
	public void add(int item)
	{
		
	}
	
	/**
	 * Delete the first occurence of the given item.
	 * @param item the item to delete.
	 */
	public void delete(int item)
	{
		
	}

	/**
	 * Return the largest element in the list (value in the last node).
	 * Precondition: The list is not empty.
	 * @return the largest element in the list.
	 */
	public int max()
	{
		//Placeholder code.
		return 0;
	}
	
	/**
	 * Return the smallest element in the list (value in the first node).
	 * Precondition: The list is not empty.
	 * @return the minimum element in the list.
	 */
	public int min()
	{
		//Placeholder code.
		return 0;
	}
	
	/**
	 * Output the entire list on the screen on one line.
	 */
	public void print()
	{
		
	}
	
	/**
	 * Return true if the list is empty and false otherwise.
	 * @return true if the list is empty and false otherwise.
	 */
	public boolean isEmpty()
	{
		//Placeholder code.
		return true;
	}
}