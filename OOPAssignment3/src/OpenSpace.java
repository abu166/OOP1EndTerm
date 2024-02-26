public class OpenSpace implements UniversityLocation {
    @Override
    public void enterLocation(Student student) {
        System.out.println(student.getName() + " entered the Open Space. You can relax and socialize here.");
    }

    @Override
    public String getLocationName() {
        return "Open Space";
    }
}