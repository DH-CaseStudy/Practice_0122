package employeeManagementSystem.test;

import employeeManagementSystem.dao.EmployeeDAOImpl;
import employeeManagementSystem.vo.Employee;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UpdatePartialEmployeeTest {

    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Map<String, Object> fields = new HashMap<>();
        fields.put("salary", new BigDecimal("38000.00"));

        try {
            employeeDAO.updatePartialEmployee("sec007", fields);
            Employee employee = employeeDAO.readEmployee("sec007");
            System.out.println(employee);
        } catch (SQLException e) {
            System.err.println("DB 작업중 오류 : " + e.getMessage());
        }
    }
}
