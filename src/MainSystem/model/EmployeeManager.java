package MainSystem.model;

import MainSystem.model.dao.EmployeeDBIO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeManager extends EmployeeDBIO {
    private static EmployeeManager instance;
    private static EmployeeDBIO employeeDBIO;

    public static EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
            employeeDBIO = new EmployeeDBIO();
        }

        return instance;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employee.getEno().isEmpty()) {
            System.out.println("올바른 직원 정보가 아닙니다.");
            return false;
        }

        return employeeDBIO.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        if (employee == null || employee.getEno().isEmpty()) {
            System.out.println("올바른 직원 정보가 아닙니다.");
            return false;
        }

        return employeeDBIO.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(String eno) {
        return employeeDBIO.getEmployeeById(eno);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDBIO.getAllEmployees();
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        return employeeDBIO.searchEmployeesByName(name);
    }

    @Override
    public List<Employee> searchEmployeesByRole(String role) {
        return employeeDBIO.searchEmployeesByRole(role);
    }

    @Override
    public List<Employee> getUnassignedSecretaries() {
        return employeeDBIO.getUnassignedSecretaries();
    }

    @Override
    public boolean selectUpdateEmployee(Employee employee){
        return employeeDBIO.selectUpdateEmployee(employee);
    }
}
