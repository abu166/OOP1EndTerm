import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO implements StudentRepository{
    private static final String INSERT_QUERY = "INSERT INTO students (id, name) VALUES (?, ?)";

    private static final String DELETE_QUERY = "DELETE FROM students WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE students SET name = ? WHERE id = ?";

    private static final String SELECT_QUERY = "SELECT * FROM students WHERE id = ?";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM students";


    @Override
    public void addStudent(Student student) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Student(studentId, name);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
        }

        return null;
    }
    @Override
    public void deleteStudent(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
    @Override
    public void updateStudent(Student student) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getId());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student with ID " + student.getId() + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                students.add(new Student(studentId, name));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }

        return students;
    }
}