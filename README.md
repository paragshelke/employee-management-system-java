# Employee Management System

## Overview

The Employee Management System is a console-based Java application for managing employee records efficiently. It demonstrates strong object-oriented programming principles, file handling, collections, exception handling, and follows the Model-View-Controller (MVC) architecture for clean and maintainable code.

The application simulates real-world HR operations, allowing users to manage employee information in a structured way.

## Features

**CRUD Operations**  
- Add employees dynamically (HR, Admin, SalesManager).  
- Display all employees with complete details.  
- Search employees by ID or Name.  
- Update employee details such as ID, Name, or Salary.  
- Remove employees by ID or Name.  

**Sorting Functionality**  
- Sort employees by ID, Name, or Salary.  
- Uses Comparable for natural ordering and Comparator for flexible custom sorting.  

**Salary Calculation**  
- Calculates total salary based on employee type using polymorphism.  
- Abstract Employee class defines calSal() method implemented in each subclass.

**File Handling**  
- Persist employee records in a file (Employees.txt) using Java Serialization.  
- Automatically loads existing data at startup and saves changes to file.  

**Exception Handling**  
- Handles IOExceptions, ClassNotFoundException, and invalid user inputs.  
- Prevents program crashes and provides informative error messages.  

**Object-Oriented Design**  
- Abstract base class Employee with subclasses HR, Admin, and SalesManager.  
- Encapsulation with private fields and getters/setters.  
- Polymorphism for salary calculation.  
- Comparable and Comparator for flexible sorting.  

**MVC Architecture**  
- Model package: Employee classes and attributes.  
- Controller package: EmployeeDao handles all business logic, CRUD, sorting, and file I/O.  
- View package: MainApp provides a menu-driven console interface.  

**User-Friendly Console Interface**  
- Interactive menu with numbered options.  
- Nested menus for sorting, searching, updating, and removing employees.  
- Input validation ensures smooth user experience.

## Technologies and Concepts Used

- Core Java (OOP, collections, exceptions, file I/O)  
- Abstraction, Encapsulation, Inheritance, Polymorphism  
- ArrayList for dynamic storage and sorting  
- Serialization for persistence  
- Comparable and Comparator for sorting  
- MVC architecture for clean separation of concerns  
- Exception handling for robustness

## Folder Structure

src  
  ├─ model  
  │    ├─ Employee.java  
  │    ├─ Admin.java  
  │    ├─ HR.java  
  │    └─ SalesManager.java 
  ├─ controller  
  │    └─ EmployeeDao.java  
  └─ view  
       └─ MainApp.java  

Employees.txt (auto-generated serialized employee data)

## How to Run

1. Open a terminal or command prompt.  
2. Navigate to the project src folder.  
3. Compile all Java files:  javac model/.java controller/.java view/*.java
4. Run the application:
5. Follow the interactive console menu:  
   - Display, Add, Remove, Update, Search Employees  
   - Calculate Salary  
   - Sort Employees by ID, Name, or Salary  
   - Exit the program

## Possible Enhancements

- Replace file-based persistence with a database (MySQL, PostgreSQL).  
- Implement role-based access control for different employee types.  
- Add a GUI using Swing or JavaFX.  
- Generate reports (highest salary, total payroll, etc.). 

## Author

Name: Parag shelke   
GitHub: https://github.com/paragshelke

