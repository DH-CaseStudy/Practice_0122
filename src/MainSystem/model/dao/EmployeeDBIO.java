package MainSystem.model.dao;

import MainSystem.Util.DBUtil;
import MainSystem.io.EmployeeIO;
import MainSystem.model.Employee;
import MainSystem.model.ObjectIO;
import MainSystem.student.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//실제로 CRUD 구현 부

public class EmployeeDBIO extends ObjectIO implements EmployeeIO {

    @Override
    public boolean addEmployee(Employee employee) {

        String sql = "" +
                "INSERT INTO EMPLOYEE (eno, name, enteryear, entermonth, enterday, role, secno, salary) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getEno());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getEnterYear());
            pstmt.setInt(4, employee.getEnterMonth());
            pstmt.setInt(5, employee.getEnterDay());
            pstmt.setString(6, employee.getRole());
            pstmt.setString(7, employee.getSecno());
            pstmt.setInt(8, employee.getSalary());

            System.out.println(pstmt.toString());
            int cnt = pstmt.executeUpdate();
            if( cnt>0 ){
                System.out.println("회원 정보 추가 성공");
                return true;
            }else{
                System.out.println("회원 정보 추가 실패");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection();
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {

        String eno = employee.getEno();

        // 업데이트할 항목 선택 (1. 이름, 2. 입사월, 3. 입사년도, 4. 입사일, 5. 직급, 6. 비서번호, 7. 급여)
        System.out.println("업데이트할 항목을 선택하세요:");
        System.out.println("1. 이름");
        System.out.println("2. 입사월");
        System.out.println("3. 입사년도");
        System.out.println("4. 입사일");
        System.out.println("5. 직급");
        System.out.println("6. 비서번호");
        System.out.println("7. 급여");

        int option = Utility.readInput(Integer.class);

        System.out.println("새로운 값을 입력하세요:");
        String newValue = Utility.readInput(String.class);

        String column = "";
        switch(option) {
            case 1:
                column = "name";
                break;
            case 2:
                column = "entermonth";
                break;
            case 3:
                column = "enteryear";
                break;
            case 4:
                column = "enterday";
                break;
            case 5:
                column = "role";
                break;
            case 6:
                column = "secno";
                break;
            case 7:
                column = "salary";
                break;
            default:
                System.out.println("잘못된 옵션입니다.");
                return false;
        }

        String sql = "UPDATE EMPLOYEE SET " + column + " = ? WHERE eno = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 숫자형 컬럼은 정수형으로 변환해서 바인딩
            if (column.equals("entermonth") || column.equals("enteryear") ||
                    column.equals("enterday") || column.equals("salary")) {
                pstmt.setInt(1, Integer.parseInt(newValue));
            } else {
                pstmt.setString(1, newValue);
            }
            pstmt.setString(2, eno);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("업데이트 성공");
                return true;
            } else {
                System.out.println("업데이트 실패: 해당 사번의 직원이 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee getEmployeeById(String eno) {
        String sql = "SELECT * FROM EMPLOYEE WHERE eno = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eno);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                //  단순히 테이블의 데이터를 Employee 객체로 변환하여 반환
                return new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),  // 그대로 저장
                        rs.getString("secno"),
                        rs.getInt("salary")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection();
        return null; // 직원이 존재하지 않는 경우
    }




    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection();
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE WHERE name LIKE ?";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection();
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByRole(String role) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE WHERE role LIKE ?";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, role);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.closeConnection();
        return employees;
    }

}
