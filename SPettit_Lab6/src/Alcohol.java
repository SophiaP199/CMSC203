
public class Alcohol extends Beverage{
	
	//initialize instance variables
	public boolean onWeekend;
	
	//constants
	public final double weekendCost =.6;
	

	public Alcohol(String n, Size s, boolean a)
	{
		super("ALCOHOL", n, s);
		onWeekend = a;
	}
	
	//toString method
	public String toString()
	{
		//create string for when on weekend
		String ifOnWeekend;
		if(onWeekend ==true)
		{
			ifOnWeekend =", this drink was offered on the weekend";
		}
		else
		{
			ifOnWeekend=", this drink was not offered on the weekend";
		}
		String temp = super.toString()+ ifOnWeekend +" the cost is $"+ calcPrice();
		return temp;
	}
	
	//equals method
	public boolean equals(Beverage a)
	{
		//makes sure beverage is actually an alcohol
		if(a instanceof Alcohol)
		{
			//changes a so that we can compare the subclass
			Alcohol temp = (Alcohol) a;
			//uses super class equals and compares the superclass variables, then compares the new temp var for the subclass variables
			if(super.equals(a)&& this.onWeekend==temp.onWeekend)
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
		//initialize base price
		double price =2.0;
		
		//add cost based on size
		if(super.sizeOfCup== Size.LARGE)
		{
			price += super.ifLargePriceAdd;
		}
		if(super.sizeOfCup== Size.MEDIUM)
		{
			price += super.ifMedPriceAdd;
		}
		
		//if onweekend add to price
		if(onWeekend)
		{
			price +=.6;
		}
		
		//return cost
		return price;
	}
}
