import java.util.Scanner;

public class WifiDiagnosis 
{
	public static void main(String[] args)
	{
		/*
		 * Class: CMSC203 
		 * Instructor:
		 * Description: Create a wifi diagnostic programming, in order to help the user diagnose their wifi problem.
		 * Due: 2/06/2023
		 * Platform/compiler:Eclipse
		 * I pledge that I have completed the programming 
		 * assignment independently. I have not copied the code 
		 * from a student or any source. I have not given my code 
		 * to any student.
		   Print your Name here: Sophia Pettit
		*/
		
		// initialize variables
		Scanner input = new Scanner(System.in);
		String response;
		
		//Start the program and ask for first prompt
		System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.");
		System.out.println("Reboot the computer and try to connect");
		System.out.println("Did that fix the problem?");
		response= input.nextLine();
		
		//check to make sure input in valid
		while(!(response.equalsIgnoreCase("no")||response.equalsIgnoreCase("yes")))
		{
			System.out.println("Invalid answer; try again");
			response= input.nextLine();
		}
		
		
		//begin nested loop, only starts/continues if answer is no to the first prompt
		if(response.equalsIgnoreCase("no"))
		{
			System.out.println("Reboot the router and try to connect");
			System.out.println("Did that fix the problem?");
			response = input.nextLine();
			
			//need to error check every response and can't create functions yet to simplfy this
			while(!(response.equalsIgnoreCase("no")||response.equalsIgnoreCase("yes")))
			{
				System.out.println("Invalid answer; try again");
				response = input.nextLine();
			}
			
			//begins next prompt if response == no
			if(response.equalsIgnoreCase("no"))
			{
				System.out.println("Make sure the cables connecting the router are firmly plugged in and power is getting to the router");
				System.out.println("Did that fix the problem?");
				response = input.nextLine();
				
				//error check again
				while(!(response.equalsIgnoreCase("no")||response.equalsIgnoreCase("yes")))
				{
					System.out.println("Invalid answer; try again");
					response = input.nextLine();
				}
				
				//prompt #3
				if(response.equalsIgnoreCase("no"))
				{
					System.out.println("Move the computer closer to the router and try to connect");
					System.out.println("Did that fix the problem?");
					response = input.nextLine();
					
					//error check #4 :(
					while(!(response.equalsIgnoreCase("no")||response.equalsIgnoreCase("yes")))
					{
						System.out.println("Invalid answer; try again");
						response = input.nextLine();
					}
					
					//last prompt!!
					if(response.equalsIgnoreCase("no"))
					{
						System.out.println("Contact your ISP");
					}
				}
			}
			
		}

		System.out.println("Done");
		System.out.println("Programmer: Sophia Pettit");
		input.close();
	}
}


