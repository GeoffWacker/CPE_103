/**
 * Lab 07 - TreeTest
 * @author geoffwacker, kevinliu
 * 10.14.15
 */

import java.util.Scanner;

public class TreeTest 
{
    public static void main (String[] arg)
    {
    	//Create an integer array representation of a complete binary tree with 20 values.
        Integer[] tree = new Integer[20];
        
        //Set number of elements in tree to 0.
        int index = 0;
        
        //Create a scanner to get input.
        Scanner in = new Scanner(System.in);
        
        //Ask for input.
        System.out.print("Input:");

        //Loop for input.
        while ((in.hasNextInt()) && (index < 20))
        {
        	//Fill the tree with the next valid integer.
            tree[index]= in.nextInt();
            
            //Increment the index.
            index++;
        }

        //Our array is empty, no values were added.
        if (index == 0)
        {
            System.out.println("The tree is empty");
        }
        
        //Our array isn't empty, so test if it's a heap.
        else 
        {
        	//Print to let users know we're testing if heap.
            System.out.print("Heaptest:");

            //If it's a heap, let users know.
            if (TreeWork.isHeap(tree, index)) 
            {
                System.out.println("IS a heap.");
            } 
            
            //It must not be a heap, so let users know.
            else 
            {
                System.out.println("is NOT a heap.");
            }
            
            //Print out the entire tree.
            System.out.println("Printout:");
            TreeWork.printTree(tree, index);
            
            //Close scanner since we won't need it anymore.
            in.close();
        }
    }
}