
public abstract class Beverage {
	
	//initialize the characteristics of beverage
	public String bevName;
	public Type bevType;
	public Size sizeOfCup;
	
	//constant values for the price of the beverage
	public final double basePrice=2;
	public final double ifMedPriceAdd=1;
	public final double ifLargePriceAdd=2;
	
	
	//constructor
	public Beverage(String type, String name, Size s)
	{
		//converts the strings to actual enum types
		bevType= Type.valueOf(type);
		sizeOfCup= s;
		//regular setting of variables
		bevName=name;
	}
	
	//abstract method that calculates price of beverage
	abstract double calcPrice();
	
	//toString method
	@Override
	public String toString()
	{
		String temp =sizeOfCup +" "+ bevType+ " "+ bevName;
		return temp;
	}
	
	//overridden equals method
	public boolean equals(Beverage a)
	{
		if(this.bevType==a.bevType&&this.sizeOfCup==a.sizeOfCup&&this.bevName==a.bevName)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//get type for beverage
	public Type getType()
	{
		return bevType;
	}
}
