package studentManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=================================================================");
            System.out.println("=".repeat(25) + " 학생 관리 시스템 " + "=".repeat(26));
            System.out.println("=================================================================");
            System.out.println("1. 학생 등록 | 2. 학생 목록 출력 | 3.학번으로 검색 | 4. 평균 순 정렬 | 5. 종료");
            System.out.print("- 선택 : ");

            int cmd = sc.nextInt();

            switch (cmd) {
                case 1 -> studentManager.inputStudent();
                case 2 -> studentManager.outputStudent();
                case 3 -> {
                    System.out.print("- 검색할 학번 입력 : ");
                    String sno = sc.next();
                    Student student = studentManager.searchBySno(sno);
                    System.out.println(student != null ? student : "- 학생을 찾을 수 없습니다.");
                }
                case 4 -> {
                    System.out.println("- 평균 순 정렬");
                    studentManager.sortByAverage().forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("- 프로그램 종료");
                    return;
                }
                default -> System.out.println("- 잘못된 입력입니다.");
            }
        }
    }
}
