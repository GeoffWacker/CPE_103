/**
 * Lab 05 - StringChecker
 * @author geoffwacker, kevinliu
 * 10.12.15
 */

import java.util.*;

public class StringChecker 
{
	/**
	 * Return true if in the parameter string all brackets, braces, and parenthesis are balanced, and false otherwise.
	 * @param input the string we want to evaluate for balance.
	 * @return If the string is balanced or not.
	 */
	public static boolean isBalanced(String input)
	{
		//Get length of string.
		int inputSize = input.length();
		
		//Create an empty character stack of size 50 to handle big strings.
		AStack<Character> charStack = new AStack<Character>(50);
		
		//Process input using i as an index for string.
		for (int i = 0; i < inputSize; i++)
		{	
			//If character isn't bracket, brace, or parentheses, go to next character.
			switch(input.charAt(i))
			{
			
				//Opening bracket, push onto stack.
				case '[':
				{
					//Push the opening bracket.
					charStack.push(input.charAt(i));
					break;
				}
				
				//Opening brace, push onto stack.
				case '{':
				{
					//Push the opening brace.
					charStack.push(input.charAt(i));	
					break;
				}
				
				//Opening parentheses, push onto stack.
				case '(':
				{
					//Push the opening parentheses.
					charStack.push(input.charAt(i));
					break;
				}
				
				//Closing bracket.
				case ']':
				{
					//Check if stack is empty.
					if (charStack.isEmpty())
					{
						return false;
					}
					
					//Stack must not be empty, so pop.
					else
					{
						//Popped character is an opening match.
						if (charStack.pop() == '[')
						{
							break;
						}
						
						//It isn't, so we're not balanced.
						else
						{
							return false;
						}		
					}
				}
				
				//Closing brace.
				case '}':
				{
					//Check if stack is empty.
					if (charStack.isEmpty())
					{
						return false;
					}
					
					//Stack must not be empty, so pop.
					else
					{
						//Popped character is an opening match.
						if (charStack.pop() == '{')
						{
							break;
						}
						
						//It isn't, so we're not balanced.
						else
						{
							return false;
						}
					}
				}
				
				//Closing parentheses.
				case ')':
				{
					//Check if stack is empty.
					if (charStack.isEmpty())
					{
						return false;
					}
					
					//Stack must not be empty, so pop.
					else
					{
						//Popped character is an opening match.
						if (charStack.pop() == '(')
						{
							break;
						}
						
						//It isn't, so we're not balanced.
						else
						{
							return false;
						}
					}		
				}	
			}
		}
		
		//Input is balanced.
		if (charStack.isEmpty())
		{
			return true;
		}

		//Input is not balanced.
		return false;
	}
	
	public static void main(String [ ] args)
	{
		//Enable while loop to start.
		Boolean keepLooping = true;
		
		//Create a scanner to gather user input.
		Scanner in = new Scanner(System.in);
		
		//Keep looping until user wants to exit.
		while (keepLooping)
		{
			//Ask for input.
			System.out.println("Please enter a string to be checked for balance (Press 'q' to exit): ");
			String userInput = in.nextLine();
		
			//Check if user wants to exit.
			if (userInput.charAt(0) == 'q')
			{
				//User wants to exit, so stop looping.
				keepLooping = false;
				break;
			}
		
			//User must not want to quit.
			else
			{
				//Feed input to isBalanced.
				Boolean result = isBalanced(userInput);
				
				//True result.
				if (result == true)
				{
					System.out.println("Your input is balanced!\n");
				}
				
				//False result.
				else if (result == false)
				{
					System.out.println("Your input is not balanced!\n");
				}
			}
		}
	}
}