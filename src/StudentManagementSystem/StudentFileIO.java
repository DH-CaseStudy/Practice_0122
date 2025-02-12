package StudentManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileIO {
    private static final String FILE_PATH = "students.txt";  // 텍스트 파일 경로

    // 학생 데이터를 파일에서 읽어오는 메서드
    public List<StudentDTO> loadStudentData() {
        List<StudentDTO> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String sno = data[0];
                String name = data[1];
                int korean = Integer.parseInt(data[2]);
                int english = Integer.parseInt(data[3]);
                int math = Integer.parseInt(data[4]);
                int science = Integer.parseInt(data[5]);
                students.add(new StudentDTO(sno, name, korean, english, math, science));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    // 학생 데이터를 파일에 저장하는 메서드
    public void saveStudentData(List<StudentDTO> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (StudentDTO student : students) {
                bw.write(student.getSno() + "," + student.getName() + "," + student.getKorean() + ","
                        + student.getEnglish() + "," + student.getMath() + "," + student.getScience());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
