import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();
    private static University university = new University();

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = new Student(id, name);

        studentDAO.addStudent(student);
        System.out.println("Student added successfully.");
    }

    public static void updateStudent() {
        System.out.println("List of Students:");
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = studentDAO.getStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        System.out.print("Enter new name: ");
        String newName = scanner.next();

        student.setId(newId);
        student.setName(newName);

        studentDAO.updateStudent(student);

        System.out.println("Student updated successfully.");
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        studentDAO.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    public static void enterUniversity() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = studentDAO.getStudentById(id);

        if (student == null || !student.getName().equals(name)) {
            System.out.println("Invalid student ID or name.");
            System.out.println("You are not allowed to enter the University.");
            return;
        }

        university.enter(student);
    }
}