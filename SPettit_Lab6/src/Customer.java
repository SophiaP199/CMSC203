
public class Customer {
	
	// instance variables
	public int age;
	public String name;
	
	//constructor
	public Customer(String n, int a)
	{
		age=a;
		name=n;
	}
	
	//copy constructor
	public Customer(Customer a)
	{
		age= a.age;
		name= a.name;
	}
	
	//tostring method
	public String toString()
	{
		return "name: "+ name+" "+ age;  
	}
	
}
