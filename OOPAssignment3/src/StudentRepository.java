import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);

    Student getStudentById(int id);

    void deleteStudent(int id);

    void updateStudent(Student student);

    List<Student> getAllStudents();
}