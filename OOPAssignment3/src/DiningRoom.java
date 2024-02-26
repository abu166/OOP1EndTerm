public class DiningRoom implements UniversityLocation {
    @Override
    public void enterLocation(Student student) {
        System.out.println(student.getName() + " entered the Dining Room. You can have your meal here.");
    }

    @Override
    public String getLocationName() {
        return "Dining Room";
    }
}