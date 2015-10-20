/**
 * Lab 07 - TreeTest
 * @author geoffwacker, kevinliu
 * 10.14.15
 */

public class TreeWork 
{
	/**
	 * Determine if given complete binary tree is a heap or not.
	 * @param arr the array representation of the tree.
	 * @param N the number of elements in the tree.
	 * @return True if the tree is a heap.
	 */
    public static <T extends Comparable<? super T>> boolean isHeap (T[] arr, int N)
    {
    	//Loop through all nodes to evaluate order property to see if we have a heap.
        for (int i = 0; i < N; i++) 
        {
        	//Order property: Make sure parent is less than left child.
            if ((i * 2 + 1 < N) && (arr[i * 2 + 1].compareTo(arr[i]) < 0)) 
            {
                return false;
            } 
            
            //Order property: Make sure parent is less than right child.
            else if ((i * 2 + 2 < N) && (arr[i * 2 + 2].compareTo(arr[i]) < 0)) 
            {
                return false;
            }
        }
        
        /** 
         * We've established that the order property holds, and the structure property
         * is already satisfied since we were given a complete binary tree, so return true. 
         */
        return true;
    }
    
    /**
     * Print out the complete binary tree on the screen, one level per line.
     * @param arr the array representation of the tree.
     * @param N the number of elements in the tree.
     */
    public static <T > void printTree (T[] arr, int N)
    {
    	//Set us up to start at the top of the tree.
        int level = 1;
        int nodes = 0;
        
        //Loop until we've printed all nodes.
        while (nodes<N)
        {
        	///Print out all values of this level on one line.
            for(int i=0; i<level && nodes + i <N ; i++)
            {
                System.out.print(arr[i+nodes]+" ");
            }
            
            //Update the number of nodes and levels.
            nodes = nodes+level;
            level= level *2;
            
            //Print out a blank line to separate the levels.
            System.out.println();
        }
    }
}