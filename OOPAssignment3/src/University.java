import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    private List<UniversityLocation> locations;
    private Scanner scanner;

    public University() {
        locations = new ArrayList<>();
        locations.add(new Library());
        locations.add(new OpenSpace());
        locations.add(new DiningRoom());
        scanner = new Scanner(System.in);
    }

    public void enter(Student student) {
        System.out.println("Welcome, " + student.getName() + "! You are at the University.");

        System.out.println("Do you want to enter the University? (yes/no)");
        String enterChoice = scanner.next();

        if (enterChoice.equalsIgnoreCase("yes")) {
            System.out.println("You entered the University.");

            while (true) {
                System.out.println("Choose where you want to go:");
                for (int i = 0; i < locations.size(); i++) {
                    System.out.println((i + 1) + ". " + locations.get(i).getLocationName());
                }
                System.out.println((locations.size() + 1) + ". Leave the University");

                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= locations.size()) {
                    UniversityLocation location = locations.get(choice - 1);
                    location.enterLocation(student);
                } else if (choice == locations.size() + 1) {
                    System.out.println("Where do you want to go?");
                    System.out.println("1. Outside the University");
                    System.out.println("2. Another location within the University");
                    System.out.println("3. Leave the University");

                    int leaveChoice = scanner.nextInt();

                    if (leaveChoice == 1) {
                        System.out.println("You left the University and went outside.");
                        break;
                    } else if (leaveChoice == 2) {
                        continue;
                    } else if (leaveChoice == 3) {
                        System.out.println("You chose to leave the University.");
                        break;
                    } else {
                        System.out.println("Invalid choice.");
                        break;
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("You chose not to enter the University.");
        }
    }
}