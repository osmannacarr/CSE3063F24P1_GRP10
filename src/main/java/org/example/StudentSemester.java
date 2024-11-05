import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentSemester{
    private HashMap<Course, Float> courses;
    private float SGPA;
    private int semesterNo;
    private float totalCredit;
    private List<String> letterGrades;

    public StudentSemester(int semesterNo) {
        this.semesterNo = semesterNo;
        this.courses = new HashMap<>();
    }

    public void calculateSGPA() {
        float totalGradePoints = 0.0f;
        float totalCredits = 0.0f;

        for (Course course : courses.keySet()) {
            float grade = courses.get(course);
            float credit = course.getCredit();
            totalGradePoints += grade * credit;
            totalCredits += credit;
        }

        SGPA = (totalCredits > 0) ? (totalGradePoints / totalCredits) : 0.0f;
    }

    public void calculateCredit() {
        totalCredit = 0.0f;
        for (Course course : courses.keySet()) {
            totalCredit += course.getCredit();
        }
    }

    public void calculateLetterGrade() {
        letterGrades = new ArrayList<>();

        for (Course course : courses.keySet()) {
            float grade = courses.get(course);
            String letterGrade;

            if (grade >= 90) {
                letterGrade = "A";
            } else if (grade >= 80) {
                letterGrade = "B";
            } else if (grade >= 70) {
                letterGrade = "C";
            } else if (grade >= 60) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }

            letterGrades.add(letterGrade);
        }
    }

    public HashMap<Course, Float> getCourses() { return courses; }
    public float getSGPA() { return SGPA; }
    public int getSemesterNo() { return semesterNo; }
    public float getTotalCredit() { return totalCredit; }
    public List<String> getLetterGrades() { return letterGrades; }

    public void setCourses(HashMap<Course, Float> courses) { this.courses = courses; }
    public void setSGPA(float SGPA) { this.SGPA = SGPA; }
    public void setSemesterNo(int semesterNo) { this.semesterNo = semesterNo; }
    public void setTotalCredit(float totalCredit) { this.totalCredit = totalCredit; }
    public void setLetterGrades(List<String> letterGrades) { this.letterGrades = letterGrades; }
}
