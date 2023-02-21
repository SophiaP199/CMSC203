/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Create a random number guesser game, utilizing a driver class and a given RNG file.
 * Due: 2/20/2023
 * Platform/compiler: java exclipse
 * I pledge that I have cimpleted the programming assignment independently. 
 * I have not copied the code from a student or any source, I have not given my code to any student.
 * Print your name here: Sophia Pettit
 */

import java.util.Scanner;

public class RandomNumberGuesser 
{
	public static void main(String[] args)
	{
		//initialize the necessary variables
		int correctNum;
		int nextGuess;
		int lowGuess=0;
		int highGuess=100;
		String ifContinue="yes";
		boolean wrongGuess = true;
		
		//creating new Scanner object to read input
		Scanner input= new Scanner(System.in);
		
		//checks to see if user wants to play again
		while(ifContinue.equalsIgnoreCase("yes"))
		{
			
			//variables that need to be reset for every game
			lowGuess=0;
			highGuess=100;
			wrongGuess= true;
			RNG.resetCount();
			
			//generating our random number
			correctNum= RNG.rand();
			
		
			//starting the program
			System.out.println("Enter your first guess: ");
			nextGuess = input.nextInt();
		
			//if the input is not valid, ask for another input 
			while(!(RNG.inputValidation(nextGuess, lowGuess, highGuess)))
			{
			nextGuess = input.nextInt();
			}
			
			//will run a loop as until user guesses correct number
			while(wrongGuess == true)
			{
				
				//evalutating nextGuess and changes wrongGuess
				if(nextGuess == correctNum)
				{
					//give win message and ask if want play again
					System.out.println("Congratulations, you guessed correctly\n Try again? (yes or no)");
					ifContinue = input.nextLine();
					
					//checks to make sure they give correct reponse to yes or no
					while(!(ifContinue.equalsIgnoreCase("yes")||ifContinue.equalsIgnoreCase("no")))
					{
						System.out.println("Please enter 'yes' or 'no'");
						ifContinue = input.nextLine();
					}
					
					//ends the guessing phase
					wrongGuess= false;
				}
				//evaluates count number before it asks for another input
				else if(RNG.getCount() == RNG.getMaxGuessCount())
				{
					System.out.println("You have exceeded the maximum number of guesses, 7. Would you like to try again? (yes or no)");
					ifContinue = input.nextLine();
					
					//checks to make sure they give correct reponse to yes or no
					while(!(ifContinue.equalsIgnoreCase("yes")||ifContinue.equalsIgnoreCase("no")))
					{
						System.out.println("Please enter 'yes' or 'no'");
						ifContinue = input.nextLine();
					}
					//ends the guessing phase
					wrongGuess = false;
				}
		
				//adjusts lowguess,gives error message
				else if(nextGuess < correctNum)
				{
					System.out.println("Your guess is too low");
					lowGuess= nextGuess;
				}
				//adjusts highguess,gives error message
				else
				{
					System.out.println("Your Guess is too high");
					highGuess= nextGuess;
				}
		
				//gives count and prompts user again only if wrong guess
				if(wrongGuess== true)
				{
					//increment count here before count gets printed
					RNG.incrementCount();
					
					System.out.println("Number of guesses is: "+ RNG.getCount());
					System.out.println("Enter your next guess between "+ lowGuess + " and "+ highGuess);
					nextGuess = input.nextInt();
					//evalutating nextGuess again to make getting valid response
					while(!(RNG.inputValidation(nextGuess, lowGuess, highGuess)))
					{
					nextGuess = input.nextInt();
					}
				}
			}
		}
		
		//closing up my program
		input.close();
		System.out.println("Thanks for playing!");
		System.out.println("\nProgrammer name: Sophia Pettit");
	}
}
