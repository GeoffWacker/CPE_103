/**
 * Lab 15 - BasicAVL
 * AVL (Adelson-Velskii and Landis) tree of simple integers.
 * @author geoffwacker
 * @id gwacker
 * 11.29.15
 */

public class BasicAVL 
{
	//Nested private class BSTNode for the tree nodes.
	private class AVLNode
	{
		int element;
		int height;
		AVLNode left;
		AVLNode right;	
	}
	
	//Instance variable.
	private AVLNode root;
	
	//Constructor for empty AVL tree.
	public BasicAVL()
	{
		root = null;
	}
	
	/**
	 * Client-facing public insert method. (Simply calls the private method)
	 * @param item the item we want to insert.
	 */
	public void insert(int item)
	{
		root = insert(item, root);
	}
	
	/**
	 * Private insert method utilizing recursion to insert the item.
	 * @param item the item we want to insert.
	 * @param treeRoot the root of the tree we're in.
	 * @return the updated treeRoot.
	 */
	private AVLNode insert(int item, AVLNode treeRoot)
	{
		//Tree is empty, so insert the item at the root.
		if(treeRoot == null)
		{
			treeRoot = new AVLNode();
			treeRoot.element = item;
			treeRoot.height = 0;
		}
		
		//Tree is not empty, so we can do a regular insert.
		else
		{
			//If tree is right heavy.
			if(item < treeRoot.element)
			{
				//
				treeRoot.left = insert(item, treeRoot.left);
	            
				//Balance factor...
				if(treeRoot.left.height - height(treeRoot.right) == 2)
	            {
					//Tree's right subtree is right heavy.
					if(item < treeRoot.left.element)
					{
						treeRoot = rotateWithLeft(treeRoot);
					}
					
					//Tree's right subtree is left heavy.
					else
					{
						treeRoot = doubleLeftRight(treeRoot);
					}
	            }
			}
	         
			//If tree is left heavy.
			else if(item > treeRoot.element)
			{
				//
				treeRoot.right = insert(item, treeRoot.right);
	            
				//Balance factor...
				if(treeRoot.right.height - height(treeRoot.left) == 2)
				{
					//Tree's left subtree is left heavy.
					if(item >= treeRoot.right.element)
					{
						treeRoot = rotateWithRight(treeRoot);
					}
					
					//Tree's left subtree is right heavy.
					else
					{
						treeRoot = doubleRightLeft(treeRoot);
					}
				}
			}
		}
		
		//Update the height of the root.
		treeRoot.height = Math.max(height(treeRoot.left ), height(treeRoot.right)) + 1;
		
		//Return the updated treeRoot.
		return treeRoot;
	}
	
	/**
	 * Rotate AVL tree node with left child.
	 * @param x the node we want to rotate.
	 * @return the new root.
	 */
	private AVLNode rotateWithLeft(AVLNode x)
	{
		AVLNode y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	/**
	 * Rotate AVL tree node with right child.
	 * @param x the node we want to rotate.
	 * @return the new root.
	 */
	private AVLNode rotateWithRight(AVLNode x)
	{
		AVLNode y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	/**
	 * Left-right (double left) rotation.
	 * @param x the node we want to rotate.
	 * @return the new root.
	 */
	private AVLNode doubleLeftRight(AVLNode x)
	{
		x.left = rotateWithRight(x.left);
		return rotateWithLeft(x);
	}
	
	/**
	 * Right-left (double right) rotation.
	 * @param x the node we want to rotate.
	 * @return the new root.
	 */
	private AVLNode doubleRightLeft(AVLNode x)
	{
		x.right = rotateWithLeft(x.right);
		return rotateWithRight(x);
	}
	
	/**
	 * Get the height of the given node.
	 * @param node the node we want to get the height of.
	 * @return the integer height of the given node.
	 */
	private int height(AVLNode x)
	{
		//Node exists, so return the height of it.
		if(x != null)
		{
			return x.height;
		}
		
		//Node does not exist, so return -1.
		else
		{
			return -1;
		}

	}
	
	/**
	 * Public print method that calls the private print method.
	 */
	public void print()
	{
		print(root, 0);
	}
	
	/**
	 * Print the tree out with appropriate spacing to make it actually look like an AVL tree.
	 * @param root the root of the current subtree we're in.
	 * @param currLevel the current level of the tree we're on.
	 */
	private void print(AVLNode root, int currLevel)
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
				print(root.left, currLevel + 1);
			}
			
			//We have a right subtree, so recursively print it on the next level.
			if(root.right != null)
			{
				print(root.right, currLevel + 1);
			}
		}
	}
}