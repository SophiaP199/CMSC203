/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Create a program that asks the user for beverage, 
 * and other order information in order to calculate prices for individual orders and entire months of data
 * Due: 5/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sophia
*/


import java.util.Scanner;

//start class
public class BevShopDriverApp 
{
	//start main
	public static void main(String[] args)
	{
		//initialize new bevShop
		BevShop shop = new BevShop();
		
		//initialize variables
		//initialize scanner var
		Scanner input = new Scanner(System.in);
		
		//initialize input variables that will be used to create orders
		String name;
		int age;
		int time;
		Day days;
		
		//initialize input variables for drinks
		String drinkType;
		String size1;
		String drinkName;
		
		//initialize variables for what prompt to ask for/ending the program
		boolean finishOrders=false;
		boolean finishDrinks=false;
		
		//while the program takes more orders
		while(finishOrders ==false)
			{
			//start intro
			System.out.println("Starting a new order\n");
		
			//ask customer info
			System.out.println("Please enter your name: ");
			name= input.nextLine();
		
			System.out.println("Please enter your age: ");
			age= input.nextInt();
		
			//get info to create order
			System.out.println("Please enter the current time");
			time = input.nextInt();
			
			while(!shop.isValidTime(time))
			{
				System.out.println("Invalid time, please reenter time");
				time = input.nextInt();
			}
			input.nextLine();
			
			System.out.println("Please enter what day it is: ");
			String days1= input.nextLine();
			days= Day.valueOf(days1.toUpperCase());
			
			//create a new order
			shop.startNewOrder(time, days, name, age);
			
			//reset finishdrinks
			finishDrinks= false;
			
			//while the customer orders more drinks
			while(finishDrinks==false)
			{
				
				//ask for beverages 
				System.out.println("Enter what type of drink you would like, Smoothie, Alcohol or Coffee");
				drinkType= input.nextLine();
				Type drink = Type.valueOf(drinkType.toUpperCase());
				
				//ask prompt based on type of drink
				if(drink == Type.ALCOHOL)
				{
					System.out.println("Adding alcohol drink");
					if(shop.isEligibleForMore()==true)
					{
						if(shop.isValidAge(age)==true)
						{
							
							System.out.println("What is the name of the alcoholic drink you are ordering?");
							drinkName= input.nextLine();
							System.out.println("What size alcohol drink are you ordering?");
							size1= input.nextLine();
							Size size = Size.valueOf(size1.toUpperCase());
							
							//adds beverage to order
							shop.processAlcoholOrder(drinkName, size);
							
							//order total
							System.out.println("Total on the order: "+shop.getCurrentOrder().calcOrderTotal());
							
							//if reached three alcohol drinks give warning
							if(shop.numOfAlcoholDrinks==3)
							{
								System.out.println("Maximum alcohol drink for this order");
							}
						}
						else
						{
							System.out.println("Sorry you are too young to order alcoholic drinks");
						}
					}
					else
					{
						System.out.println("Sorry you've reached your limit on alcohol drinks");
					}
				}
				else if(drink == Type.COFFEE)
				{
					String response;
					boolean extraShot;
					boolean extraSyrup;
					
					System.out.println("Adding Coffee drink");
					System.out.println("What type of coffee are you ordering?");
					drinkName= input.nextLine();
					
					System.out.println("What size coffee would you like?");
					size1= input.nextLine();
					Size sizeC = Size.valueOf(size1.toUpperCase());
					
					System.out.println("Would you like an extra shot of coffee? Enter 'y' or 'n' ");
					response= input.nextLine();
					if(response.equalsIgnoreCase("y"))
					{
						extraShot = true;
					}
					else
					{
						extraShot = false;
					}
					
					System.out.println("Would you like extra syrup? Please enter 'y' or 'n'");
					response = input.nextLine();
					if(response.equalsIgnoreCase("y"))
					{
						extraSyrup = true;
					}
					else
					{
						extraSyrup = false;
					}
					
					//add new coffee beverage based on order
					shop.processCoffeeOrder(drinkName, sizeC, extraShot, extraSyrup);
					
					//calculates total of order
					System.out.println("Total on the order: "+shop.getCurrentOrder().calcOrderTotal());
				}
				
				else
				{
					String temp;
					boolean protein;
					int numFruit;
					
					System.out.println("Adding smoothie drink");
					System.out.println("What kind of smoothie are you ordering?");
					drinkName= input.nextLine();
					
					System.out.println("What size smoothie are you ordering?");
					temp= input.nextLine();
					Size sizeS = Size.valueOf(temp.toUpperCase());
					
					System.out.println("Are you adding protein powder? Please enter 'y' or 'n'");
					temp = input.nextLine();
					if(temp.equalsIgnoreCase("y"))
					{
						protein =true;
					}
					else
					{
						protein = false;
					}
					
					System.out.println("How many fruit are you adding to your smoothie?");
					numFruit= input.nextInt();
					input.nextLine();
					
					while(numFruit > shop.MAX_FRUIT)
					{
						System.out.println("You can't have more than "+ shop.MAX_FRUIT+", please reenter how many fruits you are adding to your smoothie");
						numFruit = input.nextInt();
						input.nextLine();
					}
					
					//add smoothie
					shop.processSmoothieOrder(drinkName, sizeS, numFruit, protein);
					
					//total order cost
					System.out.println("Total on the order: "+shop.getCurrentOrder().calcOrderTotal());
				}
				
				//Ask if user wants to order more drinks
				System.out.println("Would you like to order more drinks? Please enter 'y' or 'n'");
				String response1= input.nextLine();
				
				if(response1.equalsIgnoreCase("y"))
				{
					finishDrinks= false;
					
				}
				else if(response1.equalsIgnoreCase("n"))
				{
					finishDrinks= true;
					//give summary of all drinks ordered
					shop.allOrders.add(shop.currentOrder);
					shop.currentOrder.toString();
				}
				
			}//end of drink session
		
			//ask if want to start new order
			System.out.println("Would you like to start a new order? Please enter 'y' or 'n'");
			String response2 = input.nextLine();
			if(response2.equalsIgnoreCase("y"))
			{
				finishOrders = false;
			}
			else
			{
				finishOrders = true;
				
				//give total across all orders
				System.out.println("Total number of monthly orders: "+shop.totalNumOfMonthlyOrders());
				System.out.println("Total revenue for the month: "+ shop.totalMonthlySale());
			}
		}//end of orders
	
	}// end of main
	
}//end class
