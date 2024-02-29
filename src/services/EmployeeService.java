package services;

import doas.EmployeeDAO;
import doas.EmployeeDAOFactory;
import entities.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAO();

    //add employee
    public void addEmployee(Employee employee) {

    }

    public void updateEmployee(Employee employee) {

    }

    public void deleteEmployee(int id) {

    }

    public List<Employee> getEmployees() {
        return null;
    }

    public Employee getEmployeeById(int id) {
        return null;
    }
}
