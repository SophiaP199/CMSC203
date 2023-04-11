public class Property {
	
	private String name;
	private String city;
	private double rental;
	private String owner;
	private Plot a;
	
	//constructors go here
	
	//constructor #1 has all info
	public Property(String name1, String city1, double rental1, String owner1, int x, int y, int depth, int width)
	{
		name= name1;
		city= city1;
		rental= rental1;
		owner= owner1;
		
		a= new Plot(x,y,depth,width);
		
	}
	
	public Property(String name1, String city1, double rental1, String owner1)
	{
		name=name1;
		city= city1;
		rental=rental1;
		owner= owner1;
		
		a= new Plot(0,0,1,1);
	}
	
	public Property(Property a)
	{
		name = a.name;
		city = a.city;
		rental= a.rental;
		owner = a.owner;
	}
	
	//getters go here
	public String getPropertyName()
	{
		return name;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public double getRentAmount()
	{
		return rental;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public Plot getPlot()
	{
		return a;
	}
	
	//toString method here
	@Override
	public String toString()
	{
		return name+","+city+","+owner+","+rental;
	}
}
