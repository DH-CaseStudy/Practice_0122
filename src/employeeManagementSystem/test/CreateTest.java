package employeeManagementSystem.test;

import employeeManagementSystem.dao.EmployeeDAOImpl;
import employeeManagementSystem.vo.Employee;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CreateTest {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        try {
            employeeDAO.createEmployee(new Employee("sec006", "Secretary six", 2024, 12, 30, "Secretary", null, new BigDecimal(40000.00)));
            Employee employee = employeeDAO.readEmployee("sec006");
            System.out.println(employee);
        } catch (SQLException e) {
            System.err.println("DB 작업중 오류 : " + e.getMessage());
        }
    }
}
