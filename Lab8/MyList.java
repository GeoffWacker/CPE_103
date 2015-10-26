/**
 * Lab 08 - MyList
 * @author geoffwacker, kevinliu
 * 10.21.15
 */

public class MyList 
{
	//Variable declaration.
	private Node head;
	
	//Nested class for node.
	private class Node
	{
		//Instance variables.
		public int element;
		public Node next;
		
		//Construct a node with the specified element.
		public Node(int element)
		{
			this.element = element;
			next = null;
		}
	}
	
	//Constructor to create an empty list.
	public MyList()
	{
		head = null;
	}
	
	/**
	 * Add a new item to the front of the list.
	 * @param item the item to add to the list.
	 */
	public void add(int item)
	{
		//Create a temporary node to work with.
		Node tempNode = new Node(item);
	      
		//If the list isn't empty, make head be after our new node.
		if (head != null)
		{
			tempNode.next = head;
		}
	      
		//Insert at the front.
		head = tempNode;
	}
	
	/**
	 * Find method to for the client.
	 * @param item the item to look for.
	 * @return if the item is in the list or not.
	 */
	public boolean find(int item)
	{
		//Call the private find method.
		return find(item, head);
	}

	/**
	 * Find method to for recursion.
	 * @param item the item to look for.
	 * @param firstNode the first node of the list segment.
	 * @return if the item is in the list or not.
	 */
	private boolean find(int item, Node firstNode)
	{
		//firstNode is null, so our item must not be in the list.
		if (firstNode == null)
		{
			System.out.println("" + item + " was not found");
			System.out.println();
			return false;
		}
		
		//We've found the item, so return true.
		else if (firstNode.element == item)
		{
			return true;
		}
      
		//Recursively look for the item.
		else
		{
			return find(item, firstNode.next);
		}
	}
	
	/**
	 * Client method to print all elements of the list from last to first.
	 */
	public void print()
	{
		//Call the private print method.
		print(head);
		
		//Print out a line for spacing.
		System.out.println();
	}
	
	/**
	 * Print the elements of the list from last to first.
	 * @param firstNode the first node of the list segment.
	 */
	private void print(Node firstNode)
	{
		//Recursively print all elements until we've gone through all of them.
		if(firstNode != null)
		{
			print(firstNode.next);
			System.out.print(firstNode.element+" ");
		}
	}
	  
	/**
	 * Client method to find sum of all list elements.
	 * @return the sum of all elements in the list.
	 */
	public int sum()
	{
		//Return the output from the private sum method.
		return sum(head);
	}
	   
	/**
	 * Find the sum of all elements in the list.
	 * @param firstNode the first node of the list segment.
	 * @return the sum of all elements in the list.
	 */
	private int sum(Node firstNode)
	{
		//Continue recursion until we've gone through all elements.
		if(firstNode.next == null)
		{
			return firstNode.element;
		}
		
		//Recursively sum all list elements.
		return sum(firstNode.next) + firstNode.element;
	}
}