import java.util.ArrayList;
import java.util.List;


public class Advisor {
    private String advisorID;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Advisor(String advisorID, String name) {
        this.advisorID = advisorID;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public String getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(String advisorID) {
        this.advisorID = advisorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
