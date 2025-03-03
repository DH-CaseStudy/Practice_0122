package employeeManagementSystem.test;

import employeeManagementSystem.dao.EmployeeDAOImpl;
import employeeManagementSystem.vo.Employee;

import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        try {
            employeeDAO.deleteEmployee("sec005");
            Employee employee = employeeDAO.readEmployee("m005");
            System.out.println(employee);
        } catch (SQLException e) {
            System.err.println("DB 작업중 오류 : " + e.getMessage());
        }
    }
}
