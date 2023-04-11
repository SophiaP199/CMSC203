// Class: CMSC203
//Instructor: Khandan Monshi
//Description: Create a project that allows you to create
//plots, properties and management companies. 
//Build multiple separate classes which call various methods and 
//constructors from each other.
//Due 4/5/23
//Platform/compiler: Eclipse
//I pledge that I have completed the programming assignment independently.
//I have not copied the code from a student or any source. I have not given my code to any student.
//Sophia Pettit

public class ManagementCompany {
	
	//variables go here
	private String companyName;
	private String taxID;
	private double feePercentage;
	private int numOfProperties;
	private Plot tempPlot;

	//constants go here 
	public final int MAX_PROPERTY=5;
	public final int MGMT_WIDTH=10;
	public final int MGMT_DEPTH=10;
	private final Plot managementPlot= new Plot(0,10,10,10);
	
	//iniatlize array here
	private Property[] properties= new Property[5];
	
	//constructors go here
	public ManagementCompany(String name, String ID, double fee)
	{
		//set company info
		companyName= name;
		taxID= ID;
		feePercentage = fee;
		
		numOfProperties=0;
		
	}
	
	//getter methods here
	public String getName()
	{
		return companyName;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public double getFeePercentage()
	{
		return feePercentage;
	}
	
	public int getPropertiesCount()
	{
		return numOfProperties;
	}
	
	public void incrementCount()
	{
		numOfProperties++;
	}
	
	public Plot getPlot()
	{
		return managementPlot;
	}
	
	public Property getProperty(int a)
	{
		return properties[a];
	}
	
	//all the different overloaded versions of addProperty go here
	public int addProperty(String name1, String city1, int rental1, String owner1, int x1, int y1, int depth1, int width1)
	{
		tempPlot = new Plot(x1,y1,depth1,width1);
		
		//start if else statement here, first step: make sure there aren't too many properties already
		if(numOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		//step 2: check to see if property is null is only for the addProperty where you pass another property
		//step 3: make sure the passed property is within the management plot, where you only want to run it if encompasses passes false
		else if(!(managementPlot.encompasses(tempPlot)))
		{
			return -3;
		}
		//step 4: make sure the current plot doesn't overlap any previous ones.
		else
		{
			//variable that checks overlap, initialized to false 
			boolean overlap = false;
			
			//call the Property array and check current plot with already stored plots, tempplot(which is already iniatlized)
			//allows us to check this without adding another propertty
			for(int i=0; i<numOfProperties; i++)
			{
				if(tempPlot.overlaps(properties[i].getPlot()))
				{
					overlap =true;
				}
			}
			
			//returns -4 if overlap is true
			if(overlap == true)
			{
				return -4;
			}
			//if it passes all the tests add the property
			else
			{
				properties[numOfProperties]= new Property(name1, city1, rental1, owner1, x1,y1,depth1,width1);
				incrementCount();
				//increment properties after returning index
				return getPropertiesCount();
			}
		}
	}
	
	public int addProperty(Property a)
	{		
		if(numOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		else if(!(managementPlot.encompasses(a.getPlot())))
		{
			return -3;
		}		
		else
		{
			boolean overlap = false;
			
			for(int i=0; i< numOfProperties; i++)
			{
				if(a.getPlot().overlaps(properties[i].getPlot()))
				{
					overlap= true;
				}
			}	
			if(overlap==true)
			{
				return -4;
			}
			else
			{
				properties[numOfProperties]= new Property(a);
				incrementCount();
				
				return getPropertiesCount()-1;				}
			}
		}
	
	//method get total rent
	public double getTotalRent()
	{
		int sum=0;
		for(int i=0; i<numOfProperties; i++)
		{
			sum+=properties[i].getRentAmount();
		}
		
		return sum;
	}
	//method getHighestRentProperty
	
	public Property getHighestRentPropperty()
	{
		double tempHigh=0;
		int index=0;
		
		for(int i=0; i<numOfProperties;i++)
		{
			if(tempHigh< properties[i].getRentAmount())
			{
				tempHigh= properties[i].getRentAmount();
				index=i;
			}
		}
		
		return properties[index];
	}
	
	//method removeLastProperty
	
	public void removeLastProperty()
	{
		properties[numOfProperties]= null;
	}
	
	//method check number of properties
	
	public boolean isPropertiesFull()
	{
		if(numOfProperties==5)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//method isManagement fee valid
	
	public boolean isManagementFeeValid()
	{
		if(feePercentage <100 && feePercentage >0)
		{
			return true;
		}
		
		else 
		{
		return false;
		}
	}
	
	public double getManagementFee()
	{
		return (feePercentage/100)*getTotalRent();
	}
	
	//method toString, gets all properties in the array
	@Override
	public String toString()
	{
		String temp;
		temp= "List of the properties for "+companyName+", taxID: "+taxID+"\n";
		
		for(int i=0; i<numOfProperties; i++)
		{
			temp += properties[i].getPropertyName()+","+properties[i].getCity()+","+properties[i].getOwner()+","+properties[i].getRentAmount()+"\n";
		}
		
		temp+= "Total management fee: "+ getManagementFee();
		return temp;
	}
}
