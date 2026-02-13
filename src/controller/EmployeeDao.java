package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.*;

public class EmployeeDao 
{
	static ArrayList<Employee> employees;
	
	static {
		
	    File file = new File("Employees.txt");

	    if (file.exists()) 
	    {
	       
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employees.txt"))) {
	        	
	            employees = (ArrayList<Employee>) ois.readObject();
	            
	            //System.out.println("Employees loaded from file.");
	            
	        } catch (Exception e) {	        	
	            e.printStackTrace();
	        }
	    } else {
	        
	        employees = new ArrayList<>();

	        employees.add(new Hr(101, "Parag", 50000, 5000));
	        employees.add(new Hr(102, "Pravisha", 48000, 4500));
	        employees.add(new Hr(103, "Monika", 47000, 4000));
	        employees.add(new SalesManager(201, "Raj", 60000, 12, 8000));
	        employees.add(new SalesManager(202, "Ram", 58000, 15, 7500));
	        employees.add(new SalesManager(203, "Mohit", 62000, 10, 9000));
	        employees.add(new Admin(301, "Ankita", 70000, 10000));
	        employees.add(new Admin(302, "Sneha", 68000, 9500));
	        employees.add(new Admin(303, "Siya", 72000, 11000));
	        employees.add(new Admin(304, "Raju", 75000, 12000));

	        saveToFile();
	        
	        //System.out.println("Hardcoded employees saved to file.");
	    }
	}

	
	//methods
	
	static void saveToFile()
	{
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employees.txt"))) 
	    {
	        oos.writeObject(employees);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	  public ArrayList<Employee> displayAllEmployee() 
	  {
	        return employees;
	  }
	
	  public boolean addEmployee(Employee employee)
	  {
		    if (employee != null) 
		    {
		       employees.add(employee);
		       saveToFile();
		       return true;
		    }	
		    return false;
	  }
	  
	  public Employee searchEmployeeByID(int searchID)
	  {
		 for (Employee employee : employees) 
		 {
			if(searchID==employee.getId())
				return employee;
		 }
		 return null;
	  }
	  
	  public Employee searchEmployeeByName(String searchName)
	  {
		 for (Employee employee : employees) 
		 {
			if(searchName.equalsIgnoreCase(employee.getName()))
				return employee;
		 }
		 return null;
	  }
	  
	  
	  public boolean removeEmployeeByID(int removeId)
	  {
		 	Iterator<Employee> it = employees.iterator();
			  
			while(it.hasNext())
			{
					Employee employee1 = it.next();
					if(removeId==employee1.getId())
					{
						it.remove();
						saveToFile(); 
						return true;
					}
			}
			return false;
	  }
	  
	  public boolean removeEmployeeByName(String removeName)
	  {
		 	Iterator<Employee> it = employees.iterator();
			  
			while(it.hasNext())
			{
					Employee employee1 = it.next();
					if(removeName.equalsIgnoreCase(employee1.getName()))
					{
						it.remove();
						saveToFile(); 
						return true;
					}
			}
			return false;
	  }
	  
	  public boolean updateEmployeeID(int updateID, int newID)
	  {
	        Employee employee = searchEmployeeByID(updateID);
	        if (employee != null)
	        {
	            employee.setId(newID);
	            saveToFile(); 
	            return true;
	        }
	        return false;
	    }
	  
	  public boolean updateEmployeeSalary(int updateID, double newSalary)
	  {
	        Employee employee = searchEmployeeByID(updateID);
	        if (employee != null)
	        {
	            employee.setSalary(newSalary);
	            saveToFile(); 
	            return true;
	        }
	        return false;
	    }
	  
	  
	  public boolean updateEmployeeName(int updateID, String newName)
	  {
	        Employee employee = searchEmployeeByID(updateID);
	        if (employee != null)
	        {
	            employee.setName(newName);
	            saveToFile(); 
	            return true;
	        }
	        return false;
	    }
	  
	  public void sortEmployeeById() 
	  {
		  	Collections.sort(employees, new SortById());
	  }
	  
	  public void sortEmployeeByName() 
	  {
		  	Collections.sort(employees, new SortByName());
	  }
	  
	  public void sortEmployeeBySalary() 
	  {
		  	Collections.sort(employees, new SortBySalary());
	  }
	  
	  public double calculateSalary(int calsalID)
	  {
		  Employee employee=searchEmployeeByID(calsalID);
		  
		  if(employee!=null)
		  return employee.calSal();
		  return 0;
	  } 

}//class EmployeeDao ends here
