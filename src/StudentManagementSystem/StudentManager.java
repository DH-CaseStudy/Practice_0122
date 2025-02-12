package StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements StudentInput, SearchStudent, SortedStudent, StudentOutput {
    private List<StudentDTO> students = new ArrayList<>();
    private StudentFileIO fileIO = new StudentFileIO();
    private static StudentManager instance = new StudentManager();

    private StudentManager() {
        students = fileIO.loadStudentData(); // 프로그램 시작 시 파일에서 학생 데이터를 로드
    }

    // getInstance() 메서드로 인스턴스를 반환
    public static StudentManager getInstance() {
        return instance;
    }
    
    @Override
    public void input() {
        // 학생 정보를 입력하는 로직
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번: "); String sno = scanner.nextLine();
        System.out.print("이름: "); String name = scanner.nextLine();
        System.out.print("국어 점수: "); int korean = scanner.nextInt();
        System.out.print("영어 점수: "); int english = scanner.nextInt();
        System.out.print("수학 점수: "); int math = scanner.nextInt();
        System.out.print("과학 점수: "); int science = scanner.nextInt();

        StudentDTO student = new StudentDTO(sno, name, korean, english, math, science);
        students.add(student);
        fileIO.saveStudentData(students);  // 파일에 저장
    }

    @Override
    public void search() {
        // 학번으로 학생을 검색하는 로직
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 학번: ");
        String sno = scanner.nextLine();
        StudentDTO student = search(sno);
        if (student != null) {
            System.out.println(student);  // 학생 정보 출력
        } else {
            System.out.println("학생을 찾을 수 없습니다.");
        }
    }

    @Override
    public void AverageSort() {
        // 평균 점수 기준으로 학생들 정렬
        students.sort((s1, s2) -> Float.compare(s2.getAverage(), s1.getAverage()));
        print();  // 정렬 후 학생 목록 출력
    }

    @Override
    public void SnoSort() {
        // 학번 기준으로 학생들 정렬
        students.sort((s1, s2) -> s1.getSno().compareTo(s2.getSno()));
        print();  // 정렬 후 학생 목록 출력
    }

    @Override
    public void print() {
        // 학생 목록 출력
        for (StudentDTO student : students) {
            System.out.println(student.getSno() + " | " + student.getName() + " | " + student.getAverage());
        }
    }

    // 학번으로 학생을 찾는 메서드
    public StudentDTO search(String sno) {
        return students.stream().filter(s -> s.getSno().equals(sno)).findFirst().orElse(null);
    }

    public boolean delete(String sno) {
        boolean removed = students.removeIf(s -> s.getSno().equals(sno));
        if (removed) {
            fileIO.saveStudentData(students);  // 학생 삭제 후 파일에 다시 저장
        }
        return removed;
    }

}
