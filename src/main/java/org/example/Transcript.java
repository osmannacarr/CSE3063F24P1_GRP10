import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private float gpa;
    private List<StudentSemester> semesters;
    private int cumulativeCredit;

    public Transcript() {
        this.semesters = new ArrayList<>();
    }

    public void calculateGpa() {
        float totalGradePoints = 0.0f;
        int totalCredits = 0;

        for (StudentSemester semester : semesters) {
            semester.calculateSGPA();
            totalGradePoints += semester.getSGPA() * semester.getTotalCredit();
            totalCredits += semester.getTotalCredit();
        }

        gpa = (totalCredits > 0) ? (totalGradePoints / totalCredits) : 0.0f;
    }

    public void calculateCumulativeCredit() {
        cumulativeCredit = 0;

        for (StudentSemester semester : semesters) {
            semester.calculateCredit();
            cumulativeCredit += semester.getTotalCredit();
        }
    }

    public float getGpa() { return gpa; }
    public List<StudentSemester> getSemesters() { return semesters; }
    public int getCumulativeCredit() { return cumulativeCredit; }

    public void setGpa(float gpa) { this.gpa = gpa; }
    public void setSemesters(List<StudentSemester> semesters) { this.semesters = semesters; }
    public void setCumulativeCredit(int cumulativeCredit) { this.cumulativeCredit = cumulativeCredit; }
}

