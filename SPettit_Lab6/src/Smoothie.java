
public class Smoothie extends Beverage {
	
	//variables initialized here
	public boolean hasProtein;
	public int numFruit;
	
	//constants here
	public final double proteinPowderCost =1.5;
	public final double addFruitCost =.5;
	
	//constructor
	public Smoothie( String n, Size s,int f, boolean a)
	{
		//calls super constructor
		super("SMOOTHIE", n, s);
		
		//initializes Smoothie variables
		hasProtein = a;
		numFruit=f;
	}
	
	//toString method
	public String toString()
	{
		//initializes protein string
		String protein;
		
		//checks to the smoothie has protein
		if(hasProtein ==true)
		{
			protein =" does have protein";
		}
		else
		{
			protein =" does not have protein";
		}
		
		//returns String
		String temp= super.toString()+" has "+numFruit+ protein+" and costs $"+calcPrice();
		return temp;
	}
	
	//equals method
	public boolean equals(Beverage a)
	{
		
		//makes sure beverage is actually a smoothie
		if(a instanceof Smoothie)
		{
			//changes a so that we can compare the subclass
			Smoothie temp = (Smoothie) a;
			//uses super class equals and compares the superclass variables, then compares the new temp var for the subclass variables
			if(super.equals(a)&& this.numFruit== temp.numFruit && this.hasProtein==temp.hasProtein)
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
	
	//calcPrice method
	public double calcPrice()
	{
		//initialize cost
		double cost=super.basePrice;
		
		//checks size
		if(super.sizeOfCup== Size.LARGE)
		{
			cost+= super.ifLargePriceAdd;
		}
		if(super.sizeOfCup== Size.MEDIUM)
		{
			cost+=super.ifMedPriceAdd;
		}
		
		//checks if has protein
		if(hasProtein ==true)
		{
			cost+= proteinPowderCost;
		}
		
		//adds cost of fruit
		cost += numFruit * addFruitCost;
		return cost;
	}
}
