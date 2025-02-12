package StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = StudentManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- 학생 관리 시스템 ---");
            System.out.println("1. 학생 목록 출력");
            System.out.println("2. 학생 추가");
            System.out.println("3. 학생 검색");
            System.out.println("4. 평균 점수 기준 정렬");
            System.out.println("5. 학생 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.print();
                    break;
                case 2:
                    manager.input();
                    break;
                case 3:
                    manager.search();
                    break;
                case 4:
                    manager.AverageSort();
                    break;
                case 5:
                    System.out.print("삭제할 학번: ");
                    String sno = scanner.nextLine();
                    manager.delete(sno);
                    break;
                case 0:
                    System.out.println("프로그램 종료!");
                    return;
            }
        }
    }
}
