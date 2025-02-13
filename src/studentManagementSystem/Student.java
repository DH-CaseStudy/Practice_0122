package studentManagementSystem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private String sno;
    private String name;
    private int korean;
    private int english;
    private int math;
    private int science;
    private int total;
    private double average;
    private String grade;

    public void calculateScores() {
        this.total = korean + english + math + science;
        this.average = total / 4.0;
        this.grade = getGrade();
    }

    private String getGrade() {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - 총점: %d, 평균: %.2f, 학점: %s", sno, name, total, average, grade);
    }
}
