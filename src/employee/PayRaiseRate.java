package employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PayRaiseRate {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void applyRaise(Employee employee) throws ClassNotFoundException {
        double oldSalary = employee.getSalary();
        double newSalary = oldSalary;
        LocalDate currentDate = LocalDate.now();  // 현재 날짜
        LocalDate hireDate = LocalDate.of(employee.getEnterYear(), employee.getEnterMonth(), employee.getEnterDay());  // 입사일
        // 경과된 일수 계산
        long daysWorked = ChronoUnit.DAYS.between(hireDate, currentDate);
        // 경과된 일수에 맞는 연수를 계산
        int yearsWorked = (int) (daysWorked / 365);


        double raiseRate = getRaiseRate(employee.getRole(), yearsWorked);
        if (raiseRate > 0) {
            newSalary = oldSalary * (1 + raiseRate);
        }

        employee.setSalary(newSalary);
        employeeDAO.updateSalary(employee.getEno(), newSalary);
        System.out.println("급여가 업데이트되었습니다. 직원 ID: " + employee.getEno());
    }

    private double getRaiseRate(String role, int yearsWorked) {
        switch (role) {
            case "Manager":
                if (yearsWorked >= 10) return 0.20; // 10년 이상은 20% 인상
                else if (yearsWorked >= 8) return 0.15; // 8년 이상은 15% 인상
                else if (yearsWorked >= 5) return 0.10; // 5년 이상은 10% 인상
                else if (yearsWorked >= 3) return 0.05; // 3년 이상은 5% 인상
                break;

            case "Staff":
                if (yearsWorked >= 10) return 0.18; // 10년 이상은 18% 인상
                else if (yearsWorked >= 8) return 0.12; // 8년 이상은 12% 인상
                else if (yearsWorked >= 5) return 0.08; // 5년 이상은 8% 인상
                else if (yearsWorked >= 3) return 0.03; // 3년 이상은 3% 인상
                break;

            case "Secretary":
                if (yearsWorked >= 10) return 0.18; // 10년 이상은 18% 인상
                else if (yearsWorked >= 8) return 0.13; // 8년 이상은 13% 인상
                else if (yearsWorked >= 5) return 0.09; // 5년 이상은 9% 인상
                else if (yearsWorked >= 3) return 0.04; // 3년 이상은 4% 인상
                break;

        }
        return 0; // 3년 미만은 급여 인상 없음
    }
}
