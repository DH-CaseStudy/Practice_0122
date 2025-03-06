package employeeManagementSystem.test;

import employeeManagementSystem.dao.EmployeeDAOImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

public class SalaryTest {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        try {
            BigDecimal currentMonthlySalary = employeeDAO.getCurrentMonthlySalary("sec007");
            if (currentMonthlySalary != null) {
                System.out.println("연차별 인상률이 적용된 월급 : " + currentMonthlySalary);
                BigDecimal annualSalary = currentMonthlySalary.multiply(new BigDecimal("12"));
                annualSalary.setScale(2, RoundingMode.HALF_UP);
                System.out.println("연차별 인상률이 적용된 연봉 : " + annualSalary);
            } else {
                System.out.println("해당 직원이 없습니다.");
            }
        } catch (SQLException e) {
            System.err.println("DB 작업중 오류 : " + e.getMessage());
        }
    }
}
