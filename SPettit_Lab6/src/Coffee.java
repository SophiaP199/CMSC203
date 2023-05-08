

public class Coffee extends Beverage{
	
	//initializing variables
	public boolean extraShot;
	public boolean extraSyrup;
	
	//constants go here
	public final double extraCost=.5;
	
	//constructor
	public Coffee(String n, Size s, boolean extraS, boolean extraSyr)
	{
		//call super constructor to set up the beverage
		//pass as strings, then convert to enum types in the super constructor
		super("COFFEE",n,s);
		
		//sets the boolean variables 
		extraShot = extraS;
		extraSyrup = extraSyr;
		
	}
	
	// toString for coffee class
	public String toString()
	{
		String extraStuff;
		//the output is different based on extra shot or extra syrup
		if(extraShot== true && extraSyrup== true)
		{
			extraStuff=" which contains both an extra shot of coffee and extra syrup";
		}
		else if(extraShot == true)
		{
			extraStuff=" which contains an extra shot of coffee";
		}
		else if(extraSyrup == true)
		{
			extraStuff=" which contains extra syrup";
		}
		else
		{
			extraStuff ="";
		}
		String temp = super.toString()+ extraStuff +", price is $"+ calcPrice();
		
		return temp;
	}
	
	//overidden calc price method
	public double calcPrice()
	{
		//initialize price
		double price =super.basePrice;
		
		//calculate price based on size
		if(super.sizeOfCup == Size.LARGE)
		{
			price+=super.ifLargePriceAdd;
		}
		else if(super.sizeOfCup== Size.MEDIUM)
		{
			price +=super.ifMedPriceAdd;
		}
		
		//calculate price due to whether the coffee has extra stuff
		if(extraShot== true && extraSyrup== true)
		{
			price += (extraCost*2);
		}
		else if(extraShot == true||extraSyrup ==true)
		{
			price += extraCost;
		}
		
		return price;
	}
	
	//overrideen equals method
	public boolean equals(Beverage a)
	{
		//makes sure beverage is actually a coffee
		if(a instanceof Coffee)
		{
			//changes a so that we can compare the subclass
			Coffee temp = (Coffee) a;
			//uses super class equals and compares the superclass variables, then compares the new temp var for the subclass variables
			if(super.equals(a)&& this.extraShot== temp.extraShot && this.extraSyrup==temp.extraSyrup)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	
}
