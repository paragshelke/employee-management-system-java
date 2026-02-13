package model;

import java.io.Serializable;

public class Hr extends Employee implements Serializable
{
	private	double commission;

	public Hr()
	{
	
	}

	public Hr(int id, String name, double salary,double commission)
	{
		super(id,name,salary);
		this.commission = commission;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public double calSal()
	{
		return this.getSalary() + this.commission;
	}

	@Override
	public String toString() {
		
		return super.toString() + "Hr [commission=" + commission + "]";
	}
		

}//class Hr ends here
