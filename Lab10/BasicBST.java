/**
 * Lab 10 - BasicBST
 * Binary search tree for integers.
 * @author geoffwacker
 * 10.27.15
 */

public class BasicBST 
{
	//Nested private class BSTNode for the tree nodes.
	private class BSTNode
	{
		int element;
		BSTNode left;
		BSTNode right;	
	}
	
	//Instance variables.
	private BSTNode root;
	
	//Constructor for empty BST.
	public BasicBST()
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
	private BSTNode insert(int item, BSTNode treeRoot)
	{
		//Tree is empty, so insert the item at the root.
		if(treeRoot == null)
		{
			treeRoot = new BSTNode();
			treeRoot.element = item;
		}
		
		//Tree is not empty.
		else
		{
			//Our item is less than the current element, so it should go in the left subtree.
			if(item < treeRoot.element)
			{
				treeRoot.left = insert(item, treeRoot.left);
			}
			
			//Our item is more than the current element, so it should go in the right subtree.
			else
			{
				treeRoot.right = insert(item, treeRoot.right);
			}
		}
		
		//Return the updated treeRoot.
		return treeRoot;
	}
	
	/**
	 * Client-facing public countOdds method. (Simply calls the private method)
	 * @return the number of odds in the tree. (0 if empty)
	 */
	public int countOdds()
	{
		return countOdds(root);
	}
	
	/**
	 * Private countOdds method utilizing recursion to count the number of odds in the tree.
	 * @param treeRoot the root of the tree we're in.
	 * @return the number of odds in the tree. (0 if empty)
	 */
	private int countOdds(BSTNode treeRoot)
	{
		//Hold the number of odds.
		int numOdds = 0;
		
		//Tree is empty, so return 0.
		if (treeRoot == null)
		{
			return 0;
		}
		
		//Tree isn't empty.
		else
		{
			//If the current element is odd, increment numOdds.
			if (treeRoot.element % 2 == 1)
			{
				numOdds++;
			}
			
			//Recursively call countOdds for the left and right subtrees.
			numOdds += countOdds(treeRoot.left);
			numOdds += countOdds(treeRoot.right);
		}
		
		//Return the total number of odds in the tree.
		return numOdds;
	}
	
	/**
	 * Client-facing public height method. (Simply calls the private method)
	 * @return the height of the tree. (-1 if empty)
	 */
	public int height()
	{
		return height(root);
	}
	
	/**
	 * Private height method utilizing recursion to find the height of the tree.
	 * @param treeRoot the root of the tree we're in.
	 * @return the height of the tree. (-1 if empty)
	 */
	private int height(BSTNode treeRoot)
	{
		//Tree is empty, so return -1.
		if(treeRoot == null)
		{
			return -1;
		}
		
		//Tree is not empty.
		else
		{
			//Get the height of the left subtree.
			int height1 = height(treeRoot.left);
	         
			//Get the height of the right subtree.
			int height2 = height(treeRoot.right);
	         
			//Right subtree is longer, so return it + 1 to account for the current node.
			if(height1 < height2)
			{
				return height2 + 1;
			}
			
			//Left subtree is longer, so return it + 1 to account for the current node.
			else
			{
				return height1 + 1;
			}
		}
	}
	
	/**
	 * Client-facing public countLeaves method. (Simply calls the private method)
	 * @return the number of leaves in the tree. (0 if empty)
	 */
	public int countLeaves()
	{
		return countLeaves(root);
	}
	
	/**
	 * Private countLeaves method utilizing recursion to count the number of leaves in the tree.
	 * @param treeRoot the root of the tree we're in.
	 * @return the number of leaves in the tree. (0 if empty)
	 */
	private int countLeaves(BSTNode treeRoot)
	{
		//Store the number of leaves.
		int numLeaves = 0;

		//Tree is empty, so return 0.
		if(treeRoot == null)
		{
			numLeaves = 0;
		}
	      
		//We only have one node without any children, so we have one leaf.
		else if(treeRoot.left == null && treeRoot.right == null)
		{
			numLeaves = 1;
		}
	      
		//We still have nodes to go through, so recursively count the total number of leaves in the left and right subtrees.
		else
		{
			numLeaves = countLeaves(treeRoot.left) + countLeaves(treeRoot.right);
		}
		
		//Return the total number of leaves in the tree.
		return numLeaves;
	}
	
	/**
	 * Client-facing public countOneChildParents method. (Simply calls the private method)
	 * @return the number of nodes with only one child. (0 if empty)
	 */
	public int countOneChildParents()
	{
		return countOneChildParents(root);
	}
	
	/**
	 * Private countOneChildParents method utilizing recursion to find the number of nodes with only one child.
	 * @param treeRoot the root of the tree we're in.
	 * @return the number of nodes with only one child. (0 if empty)
	 */
	private int countOneChildParents(BSTNode treeRoot)
	{
		//Store the number of one child parents.
		int numOneChildParents = 0;
		
		//Tree is empty, so return 0.
		if(treeRoot == null)
		{
			return 0;
		}
		
		//Tree is not empty.
		else
		{
			//Node doesn't have a left child, so increment numOneChildParents.
            if(treeRoot.left == null && treeRoot.right != null)
        	{
            	numOneChildParents++;
            }
            
            //Node doesn't have a right child, so increment numOneChild parents.
            if(treeRoot.left != null && treeRoot.right == null)
            {
            	numOneChildParents++;
            }
            
            //Node has both left and right children, so recursively call the methods on the left and right subtrees.
            else
            {
            	numOneChildParents += countOneChildParents(treeRoot.left);
            	numOneChildParents += countOneChildParents(treeRoot.right);
            }   
		}
		
		//Return the total number of one-child nodes in the tree.
		return numOneChildParents;
	}	
}