import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable {
	
	//instance variables
	public int orderNumber;
	public int orderTime;
	public Day orderDay;
	public Customer x;
	
	//initialize array of beverages
	ArrayList<Beverage> totalBev = new ArrayList<>();
	
	// method to generate a random number
	public int generateRandomNum()
	{
		Random rand = new Random();
		
		int randomNum = rand.nextInt((90000 - 10000) + 1) + 10000;
		
		return randomNum;
	}
	
	//constructor
	public Order(int time, Day days, Customer c)
	{
		x= new Customer(c.name, c.age);
		orderTime=time;
		orderDay = days;
		orderNumber= generateRandomNum();
	}
	
	//copy constructor(used for sorting in bevShop
	public Order(Order a)
	{
		x = new Customer(a.x);
		orderTime= a.orderTime;
		orderDay = a.orderDay;
		orderNumber = a.orderNumber;
	}
	
	//add coffee
	public void  addNewBeverage(String bevName,Size size,boolean extraShot,boolean extraSyrup)
	{
		
		
		totalBev.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	//add smoothie
	public void  addNewBeverage( String bevName,Size size,int numOfFruits,boolean addProtein)
	{
		totalBev.add(new Smoothie(bevName, size,numOfFruits, addProtein));
	}
	
	//add alcohol
	public void  addNewBeverage( String bevName,Size size)
	{
		totalBev.add(new Alcohol(bevName, size, isWeekend()));

	}
	
	//to string method
	public String toString()
	{
		//customer/ order info
		String temp= "Order number: "+orderNumber+"\n"+orderDay+" "+orderTime+"\n"+x.toString();
		
		//specific beverage info, go through and call to string for each element and add to string temp
		for(int i=0; i<totalBev.size(); i++)
		{
			temp = temp + getBeverage(i).toString()+"\n";
			
		}
		return temp;
	}
	
	//compare order number
	@Override
	public int compareTo(Object o)
	{
		Order a = (Order)o;
		
		if(this.orderNumber > a.orderNumber)
		{
			return 1;
		}
		else if(this.orderNumber ==a.orderNumber)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	//find if on weekend
	public boolean isWeekend()
	{
		if(orderDay== Day.SATURDAY || orderDay== Day.SUNDAY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//return a specific bev in the list
	public Beverage getBeverage(int itemNo)
	{
		return totalBev.get(itemNo);
	}
	
	//find total cost of all drinks
	public double calcOrderTotal()
	{
		//initialize total
		double totalCost=0;
		
		//go through list and add cost for all the beverages
		for(int i=0; i<totalBev.size();i++)
		{
			totalCost+=getBeverage(i).calcPrice();
		}
		
		return totalCost;
	}
	
	//find the number of the specific type of beverages, ex: number of smoothies
	public int findNumOfBeveType(Type type)
	{
		
		int count =0;
		
		for(int i=0; i<totalBev.size();i++)
		{
			if(type== getBeverage(i).bevType)
			{
				count++;
			}
		}
		
		return count;
	}
	
	//int total items
	public int getTotalItems()
	{
		return totalBev.size();
	}

}
