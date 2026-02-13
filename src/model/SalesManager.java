package model;

import java.io.Serializable;

public class SalesManager extends Employee implements Serializable
{
	private int target;
	private double incentive;
	
	public SalesManager()
	{
	
	}
	
	public SalesManager(int id, String name, double salary,int target, double incentive)
	{
		super(id,name,salary);
		this.target = target;
		this.incentive = incentive;
	}
	
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	
	public double calSal()
	{
		return this.getSalary() + this.incentive;
	}
	
	@Override
	public String toString() {
		return  super.toString() +  "SalesManager [target=" + target + ", incentive=" + incentive + "]";
	}
	
	
}//class SalesManager ends here
