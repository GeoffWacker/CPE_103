**
 * Project 01 - StackTest
 * @author geoffwacker, kevinliu
 * 10.04.15
 */
package com.company;
import java.util.*;

public class StackTest {
	public static void main(String[] args) {
		//Create an empty Stack
		MyStack Strings = new MyStack();

		//Variable declaration.
		char input = 'a';

		//Create a scanner.
		Scanner in = new Scanner(System.in);

		//Loop to ask for input.
		while (input != 'q') {
			System.out.println();
			System.out.println("Choose one of the following operations: ");
			System.out.println("- add/push (enter the letter a) ");
			System.out.println("- delete/pop (Enter the letter d) ");
			System.out.println("- peek (Enter the letter p) ");
			System.out.println("- check if the stack is empty (enter the letter e) ");
			System.out.println("- quit (enter the letter q) ");
			input = in.nextLine().charAt(0);

			//Switch statement to handle input.
			switch (input) {
				//User wants to add.
				case 'a': {
					System.out.println("What would you like to add?");
					try {
						String pushInput = in.next();
						Strings.push(pushInput);
						System.out.println(pushInput + " pushed in");
						in.nextLine();
						break;
					} catch (InputMismatchException i) {
						System.out.println("Invalid push input!");
						in.nextLine();
						break;
					}
				}

				//User wants to remove.
				case 'd': {
					String popOutput = (String) Strings.pop();
					if (popOutput == null) {
						System.out.println("Invalid operation on an empty stack");
						break;
					} else {
						System.out.println(popOutput + " popped out");
						break;
					}
				}

				//User wants to peek.

				case 'p': {
					System.out.println(Strings.peek());
					break;
				}
				//User wants to see if queue is empty.
				case 'e': {
					if (Strings.isEmpty()){
						System.out.println("empty");
					}
					else{
						System.out.println("not empty");
					}
					break;
				}

				//User wants to quit.
				case 'q': {
					in.close();
					System.out.println("quitting");
					System.out.println("Have A Nice Day");
					break;
				}

				//User entered invalid input.
				default: {
					System.out.println("Invalid menu input!");
					break;
				}
			}
		}
	}
}
