package studentManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentDBIO extends ObjectIO{
    private static final StudentDBIO INSTANCE = new StudentDBIO();
    private List<Student> students = new ArrayList<>();

    private StudentDBIO() {

    }

    public static StudentDBIO getInstance() {
        return INSTANCE;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void saveData() {

    }

    @Override
    public void loadData() {

    }
}
