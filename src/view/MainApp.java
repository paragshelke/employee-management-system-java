package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import controller.EmployeeDao;

public class MainApp{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		EmployeeDao dao = new EmployeeDao();
		
		int choice;
			
		do {
			
			System.out.println("\n1. DisplayAllEmployees");
			System.out.println("2. Add Employees");
			System.out.println("3. Remove Employees");
			System.out.println("4  Search Employees");
			System.out.println("5. Update Employees");
			System.out.println("6. Calculate Salary");
			System.out.println("7. Sort Employees");
			System.out.println("8. Exit");
			
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			
		switch (choice) {
		
		case 1:	
			ArrayList<Employee> employees = dao.displayAllEmployee();
			System.out.println("**************Employee Details*************");
			for (Employee employee : employees) 
			{
				System.out.println(employee);
			}	
			break;
		
		case 2:
			 System.out.println("Enter Employee Type (1-HR, 2-Admin, 3-SalesManager): ");
             int type = sc.nextInt();

             System.out.print("Enter ID: ");
             int id = sc.nextInt();
             sc.nextLine();
             
             System.out.print("Enter Name: ");
             String name = sc.nextLine();
             
             System.out.print("Enter Salary: ");
             double salary = sc.nextDouble();

             if (type == 1) 
             {
                 System.out.print("Enter Commission: ");
                 double commission = sc.nextDouble();
                 
                Boolean result = dao.addEmployee(new Hr(id, name, salary, commission));
                
                if(result)
                	System.out.println("Hr added successfully!");
                else
                	System.out.println("No space to add employee!");
                     
             } else if (type == 2) 
             {
                 System.out.print("Enter Allowance: ");
                 double allowance = sc.nextDouble();
                 
                 Boolean result= dao.addEmployee(new Admin(id, name, salary, allowance));
                 
                 if(result)
                	 System.out.println("Admin added successfully!");
                 else
                 	System.out.println("No space to add employee!");
                  
                 
             } else if (type == 3)
             {
                 System.out.print("Enter Target: ");
                 int target = sc.nextInt();
                 
                 System.out.print("Enter Incentive: ");
                 double incentive = sc.nextDouble();
                 
                 Boolean result=  dao.addEmployee(new SalesManager(id, name, salary, target, incentive));
                            
                 if(result)
                	 System.out.println("SalesManager added successfully!");
                 else
                 	System.out.println("No space to add employee!");    
                 
             } else
             {
                 System.out.println("Invalid Type!");
             }
			break;
		
			
		case 3:
			 System.out.println("1. Remove By ID");
             System.out.println("2.	Remove By Name");
             System.out.print("Choose option: ");
             int optionRemove = sc.nextInt();
             sc.nextLine();
            
             switch (optionRemove) {
			case 1:
				
				System.out.println("Enter ID of employee to remove: ");
				int removeID=sc.nextInt();
				
				 if (dao.removeEmployeeByID(removeID))
	                 System.out.println("Employee removed successfully !");
	             else
	                 System.out.println("Employee not found.");
				
				
				break;
				
			case 2:
				
				System.out.println("Enter Name of employee to remove: ");
				String removeName=sc.nextLine();
				
				 if (dao.removeEmployeeByName(removeName))
	                 System.out.println("Employee removed successfully !");
	             else
	                 System.out.println("Employee not found.");
				
				break;	

			default:
				System.out.println("Invalid Choice !");
				break;
			}
             
	
			break;
			
		case 4:
			 System.out.println("1. Search By ID");
             System.out.println("2.	Search By Name");
             System.out.print("Choose option: ");
             int option = sc.nextInt();
             sc.nextLine();
             
             switch (option) {
			case 1:
				System.out.println("Enter ID of Employee to Search: ");
				int searchID=sc.nextInt();
				sc.hasNextLine();
				
				Employee employee=dao.searchEmployeeByID(searchID);
				
				if(employee!=null)
					System.out.println(employee);
				else
					 System.out.println("Employee not found.");
				break;

			case 2:
				System.out.println("Enter Name of Employee to Search: ");
				String searchName=sc.nextLine();
				
				Employee emp=dao.searchEmployeeByName(searchName);
				
				if(emp!=null)
					System.out.println(emp);
				else
					 System.out.println("Employee not found.");
				break;

			default:
				System.out.println("Invalid Choice !");
				break;
			}
		
				
			break;
		
		case 5:
			 System.out.println("1. Update ID");
             System.out.println("2.	Update Name");
             System.out.println("3. Update Salary");
             System.out.print("Choose option: ");
             int optionUpdate = sc.nextInt();
             
             
  			System.out.println("Enter ID of employee to update: ");
			int updateID=sc.nextInt();
			
			switch (optionUpdate) {
			case 1:
				System.out.println("Enter New ID : ");
				int newID = sc.nextInt();
				sc.nextLine();
				
				if(dao.updateEmployeeID(updateID, newID))
	                 System.out.println("Employee updated successfully !");
	            else
	                 System.out.println("Employee not found.");
				
				
				
				break;
				
				
			case 2:
				System.out.println("Enter New Name : ");
				String newName = sc.nextLine();
				
				if(dao.updateEmployeeName(updateID, newName))
	                 System.out.println("Employee updated successfully!");
	            else
	                 System.out.println("Employee not found.");
				
				break;

			case 3:
				System.out.println("Enter New Salary : ");
				Double newsalary =  sc.nextDouble();
				
				if(dao.updateEmployeeSalary(updateID, newsalary))
	                 System.out.println("Employee updated successfully!");
	            else
	                 System.out.println("Employee not found.");
				
				break;
				
			default:
				System.out.println("Invalid Choice!");
				break;
			}
			
			break;
			
		case 6:
			System.out.println("Enter ID of employee to calculate salary: ");
			int calsalID=sc.nextInt();
			
			double calculatedSalary=dao.calculateSalary(calsalID);
			
			if(calculatedSalary!=0)
				System.out.println("Salary: "+calculatedSalary);
			else
				System.out.println("Employee not found.");
			
			break;
		
		
		case 7:
			 System.out.println("1. Sort by ID");
             System.out.println("2. Sort by Name");
             System.out.println("3. Sort by Salary");
             System.out.print("Choose sorting option: ");
             int sortType = sc.nextInt();
             
             switch (sortType) {
			case 1:
				dao.sortEmployeeById();
				
				ArrayList<Employee> sortEmployeeById = dao.displayAllEmployee();
				
				System.out.println("***********************Sorted Employees By ID********************");
				for (Employee employeeSorted : sortEmployeeById) 
				{
					System.out.println(employeeSorted);
				}	
				
				break;
				
			case 2:
				dao.sortEmployeeByName();
				
				ArrayList<Employee> sortEmployeeByName = dao.displayAllEmployee();
				
				System.out.println("***********************Sorted Employees By Name********************");
				for (Employee employeeSorted : sortEmployeeByName) 
				{
					System.out.println(employeeSorted);
				}	
				
				break;
			
			case 3:
				dao.sortEmployeeBySalary();
				
				ArrayList<Employee> sortEmployeeBySalary = dao.displayAllEmployee();
				
				System.out.println("***********************Sorted Employees By Salary********************");
				for (Employee employeeSorted : sortEmployeeBySalary) 
				{
					System.out.println(employeeSorted);
				}	
				
				break;

			default:
				System.out.println("Invalid Choice !");
				break;
			}
			
			
			break;
		
		case 8:
			System.out.println("Exiting.....");
			
			break;
			

		default:
			System.out.println("Invalid Choice");
			
			break;
		}
		
			
		} while (choice!=8);
		
		sc.close();

	}//main ends here

}//class MainApp ends here
