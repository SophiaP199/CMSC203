import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	//initialize constants here
	public int MIN_AGE_FOR_ALCOHOL = 21; 
	public int MAX_ORDER_FOR_ALCOHOL= 3;   
										
	public int MIN_TIME= 8;				
	public int MAX_TIME= 23;				
	public int MAX_FRUIT = 5;	
	
	//initialize instance variables
	public int numOfAlcoholDrinks;
	public ArrayList<Order> allOrders = new ArrayList<>();	
	
	Order currentOrder;
	
	public BevShop()
	{
		//used to access bevshop methods
	}
	@Override
	public boolean isValidTime(int time) {
		
		if(time >=MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits() {
		
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		
		if(numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		
		if(numOfAlcoholDrinks == MAX_ORDER_FOR_ALCOHOL)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public int getNumOfAlcoholDrink() {
		
		return numOfAlcoholDrinks;
	}

	@Override
	public boolean isValidAge(int age) {
		
		if(age >= MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void startNewOrder(int time, Day day, String n, int a) {
		
		currentOrder= new Order(time, day, new Customer(n, a));
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		currentOrder.addNewBeverage(bevName, size,extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		
		currentOrder.addNewBeverage(bevName, size);
		numOfAlcoholDrinks++;
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	@Override
	public int findOrder(int orderNo) {
		
		//default value for index
		int index=-1;
		
		//checks and see if any of the orderNo matches the given num
		for(int i=0; i< allOrders.size(); i++)
		{
			if(allOrders.get(i).orderNumber== orderNo)
			{
				index=i;
			}
		}
		
		return index;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		
		//call find order method
		if(findOrder(orderNo)==-1)
		{
			return -1;
		}
		else
		{
			return allOrders.get(findOrder(orderNo)).calcOrderTotal();
		}
	
	}

	@Override
	public double totalMonthlySale() {
		
		double total=0;
		for(int i=0; i < allOrders.size(); i++)
		{
			total+= allOrders.get(i).calcOrderTotal();
		}
		
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		
		return allOrders.size();
	}

	@Override
	public Order getCurrentOrder() {
		
		return currentOrder;
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return allOrders.get(index);
	}

	@Override
	public void sortOrders() {
		
		//intitializing the temp vars/ min vars
		int start=0;
		Order temp;
		int smallestNum=90001;
		int smallestIndex=0;
		
		//selection sort will run through the array for the max number of the length
		for(int i=0; i<allOrders.size();i++)
		{
			//inner loop finds smallest order num and index
			for( int j= start; j< allOrders.size(); j++)
			{
				
				if(allOrders.get(j).orderNumber <smallestNum)
				{
					smallestIndex = j;
				}
			}
			//the switching of data happens here
			temp = new Order(allOrders.get(smallestIndex));
			//set the value of the smallest index to the value of start of array
			allOrders.set(smallestIndex,allOrders.get(start));
			
			//set the value of the starting point to the smallest current ordernum in array
			allOrders.set(start, temp);
			
			//increments the starting point
			start++;
			
			//reset smallestNum
			smallestNum =90001;
		}
		
	}

}
