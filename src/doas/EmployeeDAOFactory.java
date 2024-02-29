package doas;

public class EmployeeDAOFactory {
    private static EmployeeDAO employeeDAO;
    private EmployeeDAOFactory() {
    }

    public static EmployeeDAO getEmployeeDAO() {
        if(employeeDAO == null){
            employeeDAO = new EmployeeDAOImplementation();
        }
        return employeeDAO;
    }
}
