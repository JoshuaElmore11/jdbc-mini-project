import doas.EmployeeDAO;
import doas.EmployeeDAOFactory;
import entities.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAO();


        boolean flag = true;

        while (flag) {
            System.out.println("******************************************************");
            System.out.println("*************Choose an Option*************************");
            System.out.println("******************************************************");
            System.out.println("1: Add an Employee");
            System.out.println("2: Update an Employee");
            System.out.println("3: Delete an Employee");
            System.out.println("4: View Employees");
            System.out.println("5: View Employee by ID");
            System.out.println("6: Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:{
                    //add employee
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Email: ");
                    String email = sc.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    employeeDAO.addEmployee(employee);
                    break;
                }
                case 2:{
                    //Update an Employee
                    System.out.print("Enter employee id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    Employee employee = new Employee(id, name, email);
                    employeeDAO.updateEmployee(employee);
                    break;
                }
                case 3:{
                    //delete Employee
                    System.out.print("Enter employee id to delete: ");
                    int id = sc.nextInt();
                    employeeDAO.deleteEmployee(id);
                    break;
                }
                case 4:{
                    //get all
                    List<Employee> list = employeeDAO.getEmployees();
                    for ( Employee e : list ) {
                        System.out.println("Name: " + e.getName() + ", Email: " + e.getEmail());
                    }
                    break;
                }
                case 5:{
                    //get by ID
                    System.out.println("Enter employee ID to view employee: ");
                    int id = sc.nextInt();
                    Employee employee =  employeeDAO.getEmployeeById(id);
                    System.out.println("Name: " + employee.getName() + ", Email: " + employee.getEmail());
                    break;
                }
                case 6:{
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Please Choose between 1 - 6");
                }
            }
        }

        sc.close();
    }
}
