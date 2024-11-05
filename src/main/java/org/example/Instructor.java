import java.util.ArrayList;

public class Instructor {
    private String name;
    private ArrayList<Course> offeredCourses;

    public Instructor(String name) {
        this.name = name;
        this.offeredCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getOfferedCourses() {
        return offeredCourses;
    }

    public void grading(Student student, Course course) {
        System.out.println("Grading " + student.getStudentName() + " for course " + course.getName());
    }
}
