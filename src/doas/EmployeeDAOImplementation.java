package doas;

import entities.Employee;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements EmployeeDAO {
    Connection connection;

    public EmployeeDAOImplementation() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employees(name, email) values(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getEmail());
        int count = ps.executeUpdate();
        if ( count > 0) {
            System.out.println("Saved");
        } else {
            System.out.println("Oops! Something went wrong.");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employees where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        int count = ps.executeUpdate();
        if(count > 0){
            System.out.println("Deleted");
        } else {
            System.out.println("No record found.");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employees set name = ?, email = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getEmail());
        ps.setInt(3, employee.getId());
        int count = ps.executeUpdate();
        if(count > 0){
            System.out.println(count + " record(s) updated.");
        } else {
            System.out.println("No record found.");
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        String sql = "select * from employees";
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
            list.add(e);
        }

        return list;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        String sql = "select * from employees where id = ?";
        Employee employee = new Employee();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        return employee;
    }
}
