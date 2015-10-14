import java.util.Scanner;

/**
 * Created by Kevin on 10/14/2015.
 */
public class TreeTest {

    public static void main (String[] arg){

        Integer[] tree = new Integer[20];
        int index = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Input:");

        while(in.hasNextInt()&& index < 20){
            tree[index]= in.nextInt();
            index++;
        }

        if(index == 0){
            System.out.println("The tree is empty");
        }
        else {
            System.out.print("Heaptest:");

            if (TreeWork.isHeap(tree, index)) {
                System.out.println("IS a heap.");
            } else {
                System.out.println("is NOT a heap.");
            }
            System.out.println("Printout:");
            TreeWork.printTree(tree, index);
        }

    }
}
