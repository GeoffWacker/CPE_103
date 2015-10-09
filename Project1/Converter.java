/**
 * Project 01 - Converter
 * @author geoffwacker, kevinliu
 * 10.04.15
 */
package com.company;
import java.util.*;

public class Converter 
{
	/**
	 * Convert arithmetic expression in infix notation to postfix notation.
	 * @param expression the given arithmetic expression in infix notation.
	 * @return postfix the postfix expression.
	 */
	public static String infixToPostfix (String expression)
	{
		//Creates an empty string to hold output
		String peekNext;
		String postfix = new String();

		//Creates a new stack to hold inputs
		MyStack converter = new MyStack();

		//Creates a scanner to process the input expression
		Scanner in = new Scanner(expression);
		
		while (in.hasNext()){
			String token = in.next();

			if (token.equals("(")){
				converter.push(token);
				}
			else if(token.equals(")")){
				peekNext = (String) converter.peek();
				while ( !peekNext.equals("("))
				{
					postfix+= converter.pop() + " ";
					peekNext = (String) converter.peek();
				}
				converter.pop();
			}
			else if( token.equals("*")) {
				converter.push("*");
			}
			else if(token.equals("/")) {
				converter.push("/");
			}
			else if(token.equals("+")) {
				while(!converter.isEmpty() && !converter.peek().equals("(")) {
					postfix += converter.pop() + " ";
				}
				converter.push("+");
			}
			else if(token.equals("-")) {
				while (converter.peek().equals("+") || converter.peek().equals("-")) {
					postfix= postfix + converter.pop() + " ";
				}
				converter.push("/");
			}
			else{
				converter.push(token);
			}

		}
		while(!converter.isEmpty()){
			postfix= postfix+ converter.pop() + " ";
		}
		return postfix;
		
	}
	
	/**
	 * Calculate the value of the postfix expression.
	 * @param expression the postfix expression to be calculated.
	 * @return the value Double.parseDouble((String)of the postfix e)xpression.
	 */
	public static double postfixValue (String expression)
	{
		double lhs, rhs, answer;
		//Creates a new stack to hold inputs
		MyStack calculator = new MyStack();

		//Creates a scanner to process the input expression
		Scanner in = new Scanner(expression);
		//
		while (in.hasNext()){
			String token = in.next();
			if(token.matches("[0-9]")){
				calculator.push(token);
			}
			else if (token.equals("^")){
				rhs= Double.parseDouble((String)calculator.pop());
				lhs = Double.parseDouble((String)calculator.pop());
				calculator.push(String.valueOf(Math.pow(lhs,rhs)));
			}
			else if (token.equals("*")){
				rhs= Double.parseDouble((String)calculator.pop());
				lhs = Double.parseDouble((String)calculator.pop());
				calculator.push(String.valueOf(lhs*rhs));
			}
			else if (token.equals("/")){
				rhs= Double.parseDouble((String)calculator.pop());
				lhs = Double.parseDouble((String)calculator.pop());
				calculator.push(String.valueOf(lhs/rhs));
			}
			else if (token.equals("+")){
				rhs= Double.parseDouble((String)calculator.pop());
				lhs = Double.parseDouble((String)calculator.pop());
				calculator.push(String.valueOf(lhs+rhs));
			}
			else if (token.equals("-")){
				rhs= Double.parseDouble((String)calculator.pop());
				lhs = Double.parseDouble((String)calculator.pop());
				calculator.push(String.valueOf(lhs-rhs));
			}
		}
		return(Double.parseDouble((String)calculator.pop()));
	}
}
