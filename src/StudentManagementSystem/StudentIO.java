package StudentManagementSystem;

public interface StudentIO extends StudentInput, SearchStudent, SortedStudent {
    void saveStudentData();

    void loadStudentData();
}
