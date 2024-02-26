public class Library implements UniversityLocation {
    @Override
    public void enterLocation(Student student) {
        System.out.println(student.getName() + " entered the Library. You have a productive study.");
    }

    @Override
    public String getLocationName() {
        return "Library";
    }
}