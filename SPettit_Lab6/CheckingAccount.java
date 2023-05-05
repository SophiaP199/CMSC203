
public class CheckingAccount extends BankAccount {
	
	//constant variable
	public static final double FEE= .15;
	
	//constructor
	public CheckingAccount(String name, double initial)
	{
		//calls bankaccountconstructor
		super(name,initial);
		
		//changes accountnumber to add -10
		super.setAccountNumber(super.getAccountNumber()+"-10");
	}
	
	//withdraw method which overrides superclass
	@Override
	public boolean withdraw(double a)
	{
		//adds the fee to withdraw amount
		double temp = a+ FEE;
		
		//passes total to the bankaccount method
		return super.withdraw(temp);
	}
}
