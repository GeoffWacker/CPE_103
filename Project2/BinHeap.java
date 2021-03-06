/**
 * Project 02 - BinHeap
 * @author geoffwacker, kevinliu
 * 10.19.15
 */

public class BinHeap <T extends Comparable <? super T>> 
{
	//Public static nested MyException with two constructors.
	public static class MyException extends RuntimeException
	{
	   public MyException()
	   {
	      super();
	   }
	   public MyException (String message)
	   {
	      super(message);
	   }
	}
	
	//Instance variables.
	private T[] arr;
    private int n = 0;
    
    /**
     * Create an empty heap that is can hold 100 elements.
     */
    public BinHeap()
    {
    	arr = (T[]) new Comparable [100];
    	n = 0;
    }
    
    /**
     * Create a heap of specified size.
     * @param size how large of a heap we want.
     */
    public BinHeap(int size)
    {
    	arr = (T[]) new Comparable [size];
    	n = 0;
    }
    
    /**
     * Add an item to the heap, and increment the size.
     * @param element the item we want to add to the heap.
     */
    public void insert(T element)
    {
    	//Check if heap is full.
    	if (arr.length-1 == n)
    	{
    		//Heap is full, so double it.
    		T [] doubleHeap = (T[]) new Comparable [arr.length*2];
    		
    		//Go through original heap and copy all items over to the double-sized heap.
    		for (int i = 0; i < arr.length; i++)
    		{
    			doubleHeap[i] = arr[i];
    		}
    		
    		//Make our original heap the double heap.
    		arr = doubleHeap;
    	}
    		//Define the hole we're working with as our current count.
    		int hole = n;
    		
    		//Percolate up.
    		while ((hole != 0) && (arr[(hole - 1) / 2].compareTo(element) > 0))
    		{
    			arr[hole]= arr[(hole - 1) / 2];
    			hole= (hole - 1) / 2;
    		}
    		
    		//Finally add the element at the right hole.
    		arr[hole]= element;
    		
    		//Increment size.
    		n++;
    	
    }
    
    /**
     * Remove and return the minimum value of the heap.
     * @return the minimum value of the heap.
     */
    public T deleteMin()
    {
    	//Check if the heap is empty.
    	if (isEmpty())
    	{
    		throw new MyException("heap is empty");
    	}
    	
    	//Grab the first heap value.
    	T val = arr[0];
    	
    	//Figure out what we're going to remove.
 	   	T element = arr[n - 1];
 	   	
 	   	//Define a hole.
 	   	int hole = 0;
 	   	
 	   	//Let's traverse to the next hole.
 	   	int newHole = holeTraverse(hole, element);
 	   	
 	   	//Decrement the size of the heap.
    	n --;
    	
    	while (newHole != -1)
    	{
    		arr[hole] = arr[newHole];
    		hole = newHole;
    		newHole = holeTraverse(hole, element);
    	}
    	
    	arr[hole] = element;
    	return val;
    }
    
    /**
     * Check to see if we have an empty heap.
     * @return true if the heap is empty.
     */
    public boolean isEmpty()
    {
    	return n == 0;
    }
    
    /**
     * Return the number of elements in the heap.
     * @return n the number of elements in the heap.
     */
    public int size() 
    {
 	   return n;
 	}
    
    /**
     * Convert the heap to a string.
     * @return the string representation of the heap.
     */
    public String toString()
    {
    	//Define an empty string to work with.
    	String myString = "";
    	
    	//Add all elements to the string, separated by spaces.
    	for(int i = 0; i < n; i++) 
    	{
    		myString = myString + arr[i] + " ";
  	   	}
    	
    	//Return the string containing all elements of the heap.
    	return myString;
    }
    
    /**
     * Helper method for deleteMin.
     * @param hole the hole we're currently in.
     * @param element The element we're looking at.
     * @return newHole, the hole to traverse to next.
     */
    private int holeTraverse(int hole, T element)
    {
    	//Initialize newHole.
    	int newHole = -1;
    	
    	//See if hole has any children.
        if((hole*2 + 1) < n) 
        {
        	//if it has a validright child.
        	if( (hole*2 + 2) >= n) 
        	{
        		//if left child is less than our element.
        		if( arr[hole*2+1].compareTo(element) < 0) 
        		{
        			//Left child becomes the hole.
        			newHole = hole*2+1;
        		}
        	}
        	
        	else 
        	{
        		//If left child is less than the right child.
        		if (arr[hole*2+1].compareTo(arr[hole*2+2]) < 0) 
        		{
        			//If left child is less than our element.
        			if (arr[hole*2+1].compareTo(element) < 0)
        			{
        				//Left child becomes the hole.
        				newHole = hole*2+1;
        			}
        		}
              
        		else 
        		{
        			//If right child is less than our element.
        			if (arr[hole*2+2].compareTo(element) < 0)
        			{
        				//Right child becomes the hole.
        				newHole = hole*2+2;
        			}
        		}
        	}
        }
    	return newHole;
    }
}