/**
 * Project 01 - ConTest
 * @author geoffwacker, kevinliu
 * 10.04.15
 */
package com.company;
import java.util.*;

public class ConTest 
{
	public static void main(String [ ] args)
	{
		//Variable declaration.
		char input = 'i';
		
		//Create new scanner.
		Scanner in = new Scanner(System.in);
		
		//Keep looping until the user inputs 'q'
		while (input != 'q')
		{
			//Print out the menu.
			System.out.println("Choose one of the following operations:");
			System.out.println("- Infix to postfix conversion (enter the letter i)");
			System.out.println("- Postfix expression evalulation (enter the letter p)");
			System.out.println("- Arithmetic expression evaluation (enter the letter a)");
			System.out.println("- Quit the program (enter the letter q)");
			
			//Get the answer.
			input = in.nextLine().charAt(0);
			
			//Switch statement to handle input.
			switch (input)
			{
				//Infix to postfix.
				case 'i':
				{
					System.out.println("Please enter the infix expression:");
					String exp = in.nextLine();
					System.out.println(exp);
					String answer = Converter.infixToPostfix(exp);
					System.out.println("The postfix expression is " + answer);
					break;
				}
				
				//Postfix expression evaluation.
				case 'p':
				{
					System.out.println("Please enter the postfix expression:");
					System.out.println("The value of the postfix expression is "+ Converter.postfixValue(in.nextLine()));
					break;
				}
				
				//Arithmetic expression evaluation.
				case 'a':
				{
					System.out.println("Please enter the infix expression:");
					System.out.println("The value of the arithmetic expression is " + Converter.postfixValue(Converter.infixToPostfix(in.nextLine())));
					break;
				}
				
				//User wants to quit.
				case 'q':
				{
					break;
				}
				
				//Invalid input.
				default:
				{
					System.out.println("Invalid choice");
					break;
				}
			}
		}
	}
}
