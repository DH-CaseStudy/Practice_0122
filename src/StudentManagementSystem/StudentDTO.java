package StudentManagementSystem;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private String sno;
    private String name;
    private int korean;
    private int english;
    private int math;
    private int science;
    private int total;
    private float average;
    private char grade;

    public StudentDTO(String sno, String name, int korean, int english, int math, int science) {
        this.sno = sno;
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.science = science;
        this.total = korean + english + math + science;
        this.average = this.total / 4.0f;
        this.grade = calculateGrade(this.average);
    }

    private char calculateGrade(float avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else return 'D';
    }

    public String getSno() { return sno; }
    public String getName() { return name; }
    public float getAverage() { return average; }
    public char getGrade() { return grade; }

    // 각 과목의 점수를 반환하는 메서드들
    public String getKorean() {
        return String.valueOf(korean);
    }

    public String getEnglish() {
        return String.valueOf(english);
    }

    public String getMath() {
        return String.valueOf(math);
    }

    public String getScience() {
        return String.valueOf(science);
    }

    @Override
    public String toString() {
        return sno + "," + name + "," + korean + "," + english + "," + math + "," + science;
    }
}
