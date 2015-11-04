/**
 * Project 03 - BST
 * Generic BST of Comparable type objects.
 * @author geoffwacker
 * @id gwacker
 * 10.28.15
 */

import java.util.*;

public class BST<T extends Comparable<? super T>>
{
	//Nested private class.
	private class BSTNode
	{
		//Instance variables.
		private T element;
		private BSTNode left;
		private BSTNode right;
		
		//Constructor for a BSTNode with no children.
		private BSTNode(T item)
		{
			element = item;
			left = null;
			right = null;
		}
	}
	
	//Instance variables.
	private BSTNode root;

	//Nested pre-order iterator class.
	private class PreIter implements Iterator<T>
	{
		//Create a stack for storing nodes.
		private MyStack<BSTNode> stack;

		//Constructor.
        public PreIter()
        {
        	//Initialize the stack.
            stack = new MyStack<BSTNode>();
            
            //If the stack isn't empty, push the root to the stack.
            if(root != null)
            {
            	stack.push(root);
            }
        }
        
        //Check if we have another value.
		public boolean hasNext() 
		{
			return !(stack.isEmpty());
		}

		//Return the next value.
		public T next() 
		{
			//If we don't have another value, throw a NoSuchElementException.
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}

			//Grab the last element that was added to the stack.
			BSTNode y = stack.pop();

			//If we have a right child, push it to the stack.
			if(y.right != null)
			{
				stack.push(y.right);
			}

			//If we have a right child, push it to the stack.
			if(y.left != null)
			{
				stack.push(y.left);
			}

			//Return the element stored in y.
			return y.element;
		}
		
		//Remove is not supported, so throw an UnsupportedOperationException.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
	//Nested in-order iterator class.
	private class InIter implements Iterator<T>
	{
		//Push all left descendants of x to the stack.
        private void stackUpLefts(BSTNode x)
        {
        	//While we have a left child.
            while (x.left != null) 
            {
            	//Push the child to the stack.
                stack.push(x.left);
                
                //Move x pointer to left child.
                x = x.left;
            }
        }
		//Create a stack for storing nodes.
		private MyStack<BSTNode> stack;
		
		//Constructor.
        public InIter()
        {
        	//Initialize the stack.
            stack = new MyStack<BSTNode>();
            
            //If the stack isn't empty, push the root to the stack.
            if(root != null)
            {
            	//Push root to stack.
            	stack.push(root);
            	
            	//Fill stack with root's left descendants.
            	stackUpLefts(root);
            }
        }
        
		//Check if we have another value.
		public boolean hasNext() 
		{
			return !(stack.isEmpty());
		}

		//Return the next value.
		public T next() 
		{
			//If we don't have another value, throw a NoSuchElementException.
			if(!hasNext())
	         {
	            throw new NoSuchElementException();
	         }
			
			//Grab the last element that was added to the stack.
            BSTNode y = stack.pop();
            
            if (y.right != null) 
            {
            	//Push right child to stack.
                stack.push(y.right);
                
                //Stack up lefts of y's right child.
                stackUpLefts(y.right);
            }
            
            //Return the element stored in y.
            return y.element;
		}
		
		//Remove is not supported, so throw an UnsupportedOperationException.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	//Nested level-order iterator class.
	private class LevelIter implements Iterator<T>
	{
		//Create a queue for storing nodes.
        public LQueue<BSTNode> queue;

        //Constructor.
        public LevelIter()
        {
        	//Initialize the queue.
            queue = new LQueue<BSTNode>();
            
            //If the queue isn't empty, enqueue the root.
            if(root != null)
        	{
            	queue.enqueue(root);
    		}
        }

        //Check if we have another value.
        public boolean hasNext()
        {
            return !queue.isEmpty();
        }

        //Return the next value.
        public T next()
        {
        	//If we don't have another value, throw a NoSuchElementException.
        	if(!hasNext())
            {
            	throw new NoSuchElementException();
            }
            
        	//Grab the node at the front of the queue.
            BSTNode y = queue.dequeue();
            
            //If we have a left child, enqueue it.
            if(y.left != null)
            {
            	queue.enqueue(y.left);
            }
            
            //If we have a right child, enqueue it.
            if(y.right != null)
            {
            	queue.enqueue(y.right);
            }
            
            //Return the element stored in y.
            return y.element;
        }
		
        //Remove is not supported, so throw an UnsupportedOperationException.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	//Nested MyException class.
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}
	      
		public MyException(String message)
		{
			super(message);
		}
	}
	
	//Constructor to create an empty BST.
	public BST()
	{
		root = null;
	}
	
	/**
	 * Public insert method that calls the private insert method.
	 * @param item the item we want to insert.
	 */
	public void insert(T item)
	{
		root = insert(item, root);
	}
	
	/**
	 * Private insert method that uses recursion to insert an element.
	 * @param item the item we want to insert.
	 * @param root The root of the current subtree we're in.
	 * @return the updated root of the subtree.
	 */
	private BSTNode insert(T item, BSTNode root)
	{
		//The tree is empty, so the root will be our item.
		if(root == null)
		{
			root = new BSTNode(item);
		}
		
		//The tree isn't empty, so check the subtrees to see where to insert.
		else
		{
			//Our item is less than the root, so insert it in the left subtree.
			if(item.compareTo(root.element) < 0)
			{
				root.left = insert(item, root.left);
			}
			
			//Our item is greater than the root, so insert it in the right subtree.
			else
			{
				root.right = insert(item, root.right);
			}
		}
		
		//Return the updated root.
		return root; 
	}	
	
	/**
	 * Public delete method that calls the private delete method.
	 * @param item the item we want to delete.
	 */
	public void delete(T item)
	{
		root = delete(item, root);
	}
	
	/**
	 * Private delete method that uses recursion to delete a certain value from our BST.
	 * @param item the item that we want to delete.
	 * @param root the root of the current subtree we're in.
	 * @return the updated root of of the subtree.
	 */
	private BSTNode delete(T item, BSTNode root)
	{
		//The tree isn't empty, so we can delete.
		if(root != null)
		{
			//Item is less, so check the left subtree.
			if(item.compareTo(root.element) < 0)
			{
				root.left = delete(item, root.left);
			}
			
			//Item is greater, so check the right subtree.
			else if(item.compareTo(root.element) > 0)
			{
				root.right = delete(item, root.right);
			}
			
			//We have left and right children.
			else if(root.left != null && root.right != null)
			{
				root.element = findMinimum();
				root.right = delete(root.element, root.right);
			}
			
			//We only have one child, so check left and right.
			else
			{
				//We have a left child, so make it the new root.
				if(root.left != null)
				{
					root = root.left;
				}
				
				//We have a right child, so make it the new root.
				else
				{
					root = root.right;
				}
			}
		}
		
		//Return the updated root.
		return root;
	}
	
	/**
	 * Public find method that calls the private find method.
	 * @param item the item we want to find.
	 * @return if the item was found or not.
	 */
	public boolean find(T item)
	{
		return find(item, root);
	}

	/**
	 * 
	 * @param item the item we want to find.
	 * @param root the root of the current subtree we're in.
	 * @return if the item was found or not.
	 */
	private boolean find(T item, BSTNode root)
	{
		//If the tree is empty, return false.
		if(root == null) 
		{
			return false;
		}
	   
		//Values are equal, so we found it.
		if(root.element.compareTo(item) == 0)
		{
			return true;
		}
	   
		//Recursively search in the left subtree since our root is greater than the item.
		else if(root.element.compareTo(item) > 0)
		{
			return find(item, root.left);
		}
	   
		//Recursively search in the right subtree since our item is greater than the root.
		else 
		{
			return find(item, root.right);
		}
	}
	
	/**
	 * Determine if the tree is empty or not by checking if the root is equal to null.
	 * @return if the tree is empty or not.
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * Make the tree empty by setting root to null.
	 */
	public void makeEmpty()
	{
		root = null;
	}
	
	/**
	 * Public size method that calls the private size method.
	 * @return the size of the tree.
	 */
	public int size()
	{
		return size(root);
	}
	
	/**
	 * Determine the size of the tree with recursion.
	 * @param root the root of the current subtree we're in.
	 * @return the size of the tree.
	 */
	private int size(BSTNode root)
	{
		//Our tree is empty, so return 0.
		if(root == null)
		{
			return 0;
		}
		
		//Our tree isn't empty, so use recursion to get the size of the left and right subtrees, plus one to account for the root.
		else
		{
			return (1 + size(root.left) + size(root.right));
		}
	}
	
	/**
	 * Find the minimum value in the BST.
	 * @return the minimum value of the BST.
	 */
	public T findMinimum()
	{
		//Throw MyException if tree is empty.
		if(root == null)
		{
			throw new MyException();
		}
		
		//Create a temporary node to work with. 
		BSTNode tempNode = root;
		
		//We know the min is going to be in the left subtree, so loop through it to find the min.
		while(tempNode.left != null)
		{
			tempNode = tempNode.left;
		}
		
		//Return the minimum element of the tree.
		return tempNode.element;
	}
	
	/**
	 * Find the maximum value in the BST.
	 * @return the maximum value of the BST.
	 */
	public T findMaximum()
	{
		
		//Throw MyException if tree is empty.
		if(root == null)
		{
			throw new MyException();
		}
		
		//Create a temporary node to work with.
		BSTNode tempNode = root;
		
		//We know the max is going to be in the right subtree, so loop through it to find the max.
		while(tempNode.right != null)
		{
			tempNode = tempNode.right;
		}
		
		//Return the maximum element of the tree.
		return tempNode.element;
	}
	
	/**
	 * Create a PreIter object.
	 * @return the PreIter object.
	 */
	public Iterator<T> iteratorPre()
	{
		return new PreIter();
	}
	
	/**
	 * Create an InIter object.
	 * @return the InIter object.
	 */
	public Iterator<T> iteratorIn()
	{
		return new InIter();
	}
	
	/**
	 * Create a LevelIter object.
	 * @return the LevelIter object.
	 */
	public Iterator<T> iteratorLevel()
	{
		return new LevelIter();
	}
	
	/**
	 * Public printTree method that calls the private printTree method.
	 */
	public void printTree()
	{
		printTree(root, 0);
	}
	
	/**
	 * Print the tree out with appropriate spacing to make it actually look like a BST.
	 * @param root the root of the current subtree we're in.
	 * @param currLevel the current level of the tree we're on.
	 */
	private void printTree(BSTNode root, int currLevel)
	{
		//If the tree is empty, print out a blank line.
		if(root == null)
		{
			System.out.println();
		}
		
		//The tree isn't empty, so we can print it out.
		else
		{
			//Print the correct amount of tabs for each level.
			for(int i = 0; i < currLevel; i++)
			{
				System.out.print("\t");
			}
	         
			//Print the root element at the current level.
			System.out.println("" + root.element);
			
			//We have a left subtree, so recursively print it on the next level.
			if(root.left != null)
			{
				printTree(root.left, currLevel + 1);
			}
			
			//We have a right subtree, so recursively print it on the next level.
			if(root.right != null)
			{
				printTree(root.right, currLevel + 1);
			}
		}
	}
	
	/**
	 * Public toString method that calls the private toString method.
	 */
	public String toString()
	{
		return toString(root);
	}
	
	/**
	 * Print each tree value on the same line, separated by spaces.
	 * @param root the root of the current subtree we're in.
	 * @return the string containing all of the tree elements separated by spaces.
	 */
	private String toString(BSTNode root)
	{
		//Create an empty string to store our tree values in.
		String result = "";
		
		//If the tree isn't empty, start putting all our tree values in one string separated by spaces.
		if(root != null)
		{
			//Print the current element and a space.
			result = root.element + " ";
			
			//Recursively call the toString method for the left subtree.
            result = result.concat(toString(root.left));
            
            //Recursively call the toString method for the right subtree.
            result = result.concat(toString(root.right));
		}
		
		//Return the concatenated string.
		return result;
	}
}