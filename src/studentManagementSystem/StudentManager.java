package studentManagementSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager implements StudentManagerInterface {
    private StudentDBIO studentDBIO = StudentDBIO.getInstance();
    private Scanner sc = new Scanner(System.in);
    private StringTokenizer st;

    @Override
    public void inputStudent() {
        Student student = new Student();
        System.out.println("- 학번, 이름, 국어점수, 영어점수, 수학점수, 과학점수를 입력하세요.");
        System.out.print("- ");
        st = new StringTokenizer(sc.nextLine());
        student.setSno(st.nextToken());
        student.setName(st.nextToken());
        student.setKorean(Integer.parseInt(st.nextToken()));
        student.setEnglish(Integer.parseInt(st.nextToken()));
        student.setMath(Integer.parseInt(st.nextToken()));
        student.setScience(Integer.parseInt(st.nextToken()));
        student.calculateScores();
        studentDBIO.addStudent(student);
    }

    @Override
    public void outputStudent() {
        for (Student student : studentDBIO.getStudents()) {
            System.out.println(student);
        }
    }

    @Override
    public Student searchBySno(String sno) {
        for (Student student : studentDBIO.getStudents()) {
            if (student.getSno().equals(sno)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> sortByAverage() {
        return studentDBIO.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getAverage).reversed())
                .toList();
    }
}
