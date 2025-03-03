package employeeManagementSystem.dao;

import employeeManagementSystem.vo.Employee;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface EmployeeDAO {
    void createEmployee(Employee emp) throws SQLException;

    Employee readEmployee(String eno) throws SQLException;

    void updateEmployee(Employee emp) throws SQLException;

    void deleteEmployee(String eno) throws SQLException;

    BigDecimal getCurrentMonthlySalary(String eno) throws SQLException;
}
