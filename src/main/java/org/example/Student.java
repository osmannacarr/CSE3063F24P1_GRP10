import java.util.ArrayList;
import java.util.List;

public class Student{
    private String studentID;
    private String studentName;
    private Advisor advisor;
    private List<Course> enrolledCourses = new ArrayList<>();

    
    public Student(String studentID, String studentName, Advisor advisor) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.advisor = advisor;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public String getStudentID() { return studentID; }
    public String getStudentName() { return studentName; }
    public ArrayList<Course> getEnrolledCourses() { return (ArrayList<Course>) enrolledCourses; }
    public StudentSemester getStudentSemester() { return studentSemester; }
    public Transcript getTranscript() { return transcript; }
    public Advisor getAdvisor() { return advisor; }

    public void setStudentID(String studentID) { this.studentID = studentID; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) { this.enrolledCourses = enrolledCourses; }
    public void setStudentSemester(StudentSemester studentSemester) { this.studentSemester = studentSemester; }
    public void setTranscript(Transcript transcript) { this.transcript = transcript; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
}
