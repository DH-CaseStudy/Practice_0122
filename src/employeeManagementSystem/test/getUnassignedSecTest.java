package employeeManagementSystem.test;

import employeeManagementSystem.dao.EmployeeDAOImpl;
import employeeManagementSystem.vo.Employee;

import java.sql.SQLException;
import java.util.List;

public class getUnassignedSecTest {
    public static void main(String[] args) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> unassignedSecretaries = employeeDAO.getUnassignedSecretaries();

        System.out.println("할당되지 않은 비서 목록:");
        for (Employee emp : unassignedSecretaries) {
            System.out.println(emp);
        }
    }
}
