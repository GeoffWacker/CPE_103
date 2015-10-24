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
		
		//Construct a node with the specified element.
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
		//Create a temporary node to work with.
		Node tempNode = new Node(item);
		
		//List is empty, so head needs to be changed.
		if (isEmpty())
		{
			head = tempNode;
		}
		
		//If item is less than or equal to the first item, head should be updated to this item.
		else if (item <= head.element)
		{
			tempNode.next = head;
            head = tempNode;
		}
		
		else
		{
			//Create a node pointer to work with.
			Node current = head;
			
			//Advance the pointer until we hit the node containing the last value smaller than item.
            while(current.next != null)
            {
            	if (current.next.element < item)
                {
            			current = current.next;
                }
        	
            	/**MIGHT BE REDUNDANT CODE
                else
                {
                	break;
                }**/
            }

            //If we're at the end, insert the item at the end.
            if (current.next == null)
            {
                current.next = tempNode;
            }
            
            //We're not at the end, so insert it after the smaller value.
            else
            {
                tempNode.next = current.next;
                current.next = tempNode;   
            }
		}	
	}
	
	/**
	 * Delete the first occurrence of the given item.
	 * @param item the item to delete.
	 */
	public void delete(int item)
	{
		//If the list is empty, there is nothing to do.
		if (!isEmpty())
		{
			//If item is at the front of the list(single element), advance the current head.
			if (item == head.element)
			{
				head = head.next;
			}
			
			//It's not the only element, so proceed like normal.
			else
			{
				//Create a node pointer to work with.
				Node current = head;
			
				//Advance our pointer until we get to last value smaller than item.
				while (current.next != null && current.next.element < item) 
				{
					current = current.next;
				}
	        
				//At this point, the next value is what we want to delete.
				if (current.next!= null && current.next.element == item) 
				{
					current.next = current.next.next;
				}
			}
		}
	}

	/**
	 * Return the largest element in the list (value in the last node).
	 * Precondition: The list is not empty.
	 * @return the largest element in the list.
	 */
	public int max()
	{
		//Create a node pointer to work with.
		Node current = head;
		
		//Loop until we get to the last and largest element (because next will be null)
		while (current.next != null)
        {
			current = current.next;
        }
		
		//Return the largest element.
        return current.element;

	}
	
	/**
	 * Return the smallest element in the list (value in the first node).
	 * Precondition: The list is not empty.
	 * @return the minimum element in the list.
	 */
	public int min()
	{
		//Return the minimum value.
		return head.element;
	}
	
	/**
	 * Output the entire list on the screen on one line.
	 */
	public void print()
	{
		//Create a node pointer to work with.
		Node current = head;
        
		//Loop until we reach the end of the list.
		while (current.next != null)
        {
            System.out.print(current.element + " ");
            current = current.next;
        }
		
		//Print out the last element with a blank line after.
        System.out.print(current.element);
        System.out.println();
	}
	
	/**
	 * Return true if the list is empty and false otherwise.
	 * @return true if the list is empty and false otherwise.
	 */
	public boolean isEmpty()
	{
		return head == null;
	}
}