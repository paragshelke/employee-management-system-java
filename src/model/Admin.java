package model;

import java.io.Serializable;

public class Admin extends Employee implements Serializable
{
	private double allowance;

	public Admin()
	{
		
	}

	public Admin(int id, String name, double salary,double allowance ) 
	{
		super(id,name,salary);
		this.allowance = allowance;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
	public double calSal()
	{
		return this.getSalary() + this.allowance;
	}

	@Override
	public String toString() {
		return  super.toString() +  "Admin [allowance=" + allowance + "]";
	}
	
}//class Admin ends here
