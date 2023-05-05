
public class SavingsAccount extends BankAccount {
	
	//instance variables
	public double rate=.025;
	public int savingsNumber = 0;
	private String accountNumber;
	
	//regular constructor
	public SavingsAccount(String name, double initial)
	{
		super(name, initial);
		accountNumber= super.getAccountNumber()+"-"+savingsNumber;
		
	}
	
	//copy constructor
	public SavingsAccount(SavingsAccount a, double initial)
	{
		
		//calls superclass copyconstructor
		super(a, initial);
		
		//finding savings account number
		savingsNumber= a.savingsNumber+1;
		
		//set account number
		accountNumber= super.getAccountNumber()+"-"+savingsNumber;
		
	}
	
	//calculates interest and adds it to balance
	public void postInterest()
	{
		super.deposit(super.getBalance()*rate*1/12);
	}
	
	//method retrive account number, overrides superclass
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
}
