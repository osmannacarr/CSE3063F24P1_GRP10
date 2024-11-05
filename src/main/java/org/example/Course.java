import java.util.ArrayList;

public class Course {
    private String name;
    private String code;
    private int credit;
    private int quota;
    private String term;
    private int year;
    private Instructor instructor;
    private ArrayList<Department> departments;
    private ArrayList<Section> labSessions;
    private ArrayList<Section> courseSessions;
    private ArrayList<String> prerequisite;
    private ArrayList<Student> studentsEnrolled;

    public Course(String name, String code, int credit, int quota, String term, int year) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.quota = quota;
        this.term = term;
        this.year = year;
        this.departments = new ArrayList<>();
        this.labSessions = new ArrayList<>();
        this.courseSessions = new ArrayList<>();
        this.prerequisite = new ArrayList<>();
        this.studentsEnrolled = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    public int getQuota() {
        return quota;
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Section> getLabSessions() {
        return labSessions;
    }

    public ArrayList<Section> getCourseSessions() {
        return courseSessions;
    }

    public ArrayList<String> getPrerequisite() {
        return prerequisite;
    }

    public ArrayList<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        instructor.getOfferedCourses().add(this);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addLabSession(Section section) {
        labSessions.add(section);
    }

    public void addCourseSession(Section section) {
        courseSessions.add(section);
    }

    public void addPrerequisite(String prerequisiteCourseCode) {
        prerequisite.add(prerequisiteCourseCode);
    }

    public void enrollStudent(Student student) {
        if (studentsEnrolled.size() < quota) {
            studentsEnrolled.add(student);
        } else {
            System.out.println("Course quota exceeded.");
        }
    }
}
