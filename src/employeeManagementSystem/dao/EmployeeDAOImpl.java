package employeeManagementSystem.dao;

import employeeManagementSystem.vo.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul";
    private static final String USER = "ssg";
    private static final String PASSWORD = "ssg";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    @Override
    public void createEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO Employee (eno, name, enteryear, entermonth, enterday, role, secno, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getEno());
            pstmt.setString(2, emp.getName());
            pstmt.setInt(3, emp.getEnterYear());
            pstmt.setInt(4, emp.getEnterMonth());
            pstmt.setInt(5, emp.getEnterDay());
            pstmt.setString(6, emp.getRole());
            pstmt.setString(7, emp.getSecNo());
            pstmt.setBigDecimal(8, emp.getSalary());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Employee readEmployee(String eno) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE eno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eno);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getBigDecimal("salary")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE Employee SET name=?, enteryear=?, entermonth=?, enterday=?, role=?, secno=?, salary=? WHERE eno=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getName());
            pstmt.setInt(2, emp.getEnterYear());
            pstmt.setInt(3, emp.getEnterMonth());
            pstmt.setInt(4, emp.getEnterDay());
            pstmt.setString(5, emp.getRole());
            pstmt.setString(6, emp.getSecNo());
            pstmt.setBigDecimal(7, emp.getSalary());
            pstmt.setString(8, emp.getEno());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteEmployee(String eno) throws SQLException {
        if (eno.contains("sec")) {
            makeSecretaryNull(eno);
        }
        String sql = "DELETE FROM Employee WHERE eno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eno);
            pstmt.executeUpdate();
        }
    }

    private void makeSecretaryNull(String eno) throws SQLException {
        String sql = "UPDATE Employee set secno = null where secno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eno);
            pstmt.executeUpdate();
        }
    }

    public List<Employee> getUnassignedSecretaries() throws SQLException {
        List<Employee> secretaries = new ArrayList<>();
        String sql = "SELECT * FROM Employee " +
                     "WHERE role = 'Secretary' " +
                     "AND eno NOT IN (" +
                     "   SELECT secno FROM Employee WHERE role = 'Manager' AND secno IS NOT NULL" +
                     ")";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

             while (rs.next()) {
                 Employee emp = new Employee(
                     rs.getString("eno"),
                     rs.getString("name"),
                     rs.getInt("enteryear"),
                     rs.getInt("entermonth"),
                     rs.getInt("enterday"),
                     rs.getString("role"),
                     rs.getString("secno"),
                     rs.getBigDecimal("salary")
                 );
                 secretaries.add(emp);
             }
        }
        return secretaries;
    }


    @Override
    public BigDecimal getCurrentMonthlySalary(String eno) throws SQLException {
        String sql = "SELECT e.salary, e.enteryear, e.entermonth, e.enterday, p.rate " +
                "FROM Employee e JOIN PayRaiseRate p ON e.role = p.role " +
                "WHERE e.eno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eno);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    BigDecimal baseSalary = rs.getBigDecimal("salary");
                    int entryYear = rs.getInt("enteryear");
                    int entryMonth = rs.getInt("entermonth");
                    int entryDay = rs.getInt("enterday");
                    BigDecimal raiseRate = rs.getBigDecimal("rate");

                    LocalDate joinDate = LocalDate.of(entryYear, entryMonth, entryDay);
                    LocalDate currentDate = LocalDate.now();
                    int yearsOfService = Period.between(joinDate, currentDate).getYears();

                    BigDecimal multiplier = BigDecimal.ONE;
                    if (yearsOfService > 0) {
                        multiplier = BigDecimal.ONE.add(raiseRate).pow(yearsOfService);
                    }

                    BigDecimal currentMonthlySalary = baseSalary.multiply(multiplier);
                    return currentMonthlySalary.setScale(2, RoundingMode.HALF_UP);
                }
            }
        }
        return null;
    }
}