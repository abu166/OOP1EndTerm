import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagement studentManagement = new StudentManagement();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Enter University");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentManagement.addStudent();
                    break;

                case 2:
                    studentManagement.updateStudent();
                    break;

                case 3:
                    studentManagement.deleteStudent();
                    break;

                case 4:
                    studentManagement.enterUniversity();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }



}