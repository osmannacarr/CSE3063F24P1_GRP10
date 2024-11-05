//package org.example;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//// Login class
//class Login {
//    private Map<String, String> studentLogin = new HashMap<>();
//    private Map<String, String> advisorLogin = new HashMap<>();
//
//    public Login(JsonNode data) {
//        // Load students' login details from JSON
//        for (JsonNode student : data.get("students")) {
//            String username = student.get("username").asText();
//            String password = student.get("password").asText();
//            studentLogin.put(username, password);
//        }
//        // Load advisors' login details from JSON
//        for (JsonNode advisor : data.get("advisors")) {
//            String name = advisor.get("name").asText();
//            String password = "default_password"; // Assign a default password if not in JSON
//            advisorLogin.put(name, password);
//        }
//    }
//
//    public boolean verify(String userType, String username, String password) {
//        if (userType.equalsIgnoreCase("Student")) {
//            return studentLogin.containsKey(username) && studentLogin.get(username).equals(password);
//        } else if (userType.equalsIgnoreCase("Advisor")) {
//            return advisorLogin.containsKey(username) && advisorLogin.get(username).equals(password);
//        }
//        return false;
//    }
//}
//
//        public static void main(String[] args) {
//            try {
//                CourseRegistrationSystem system = new CourseRegistrationSystem("data.json");
//                Login loginSystem = new Login(new ObjectMapper().readTree(new File("data.json")));
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.print("Please enter the user type (Student/Advisor): ");
//                String userType = scanner.nextLine();
//
//                if (userType.equalsIgnoreCase("Student") || userType.equalsIgnoreCase("Advisor")) {
//                    System.out.print("Enter your username: ");
//                    String username = scanner.nextLine();
//
//                    System.out.print("Enter your password: ");
//                    String password = scanner.nextLine();
//
//                    if (loginSystem.verify(userType, username, password)) {
//                        System.out.println("Login successful! Welcome, " + username + "!");
//                    } else {
//                        System.out.println("Login failed. Invalid username and password.");
//                    }
//
//                } else {
//                    System.out.println("Invalid user type.");
//                }
//                scanner.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//}
//
//        // Department class
//        class Department {
//            private String name;
//            private String faculty;
//
//            public Department(String name, String faculty) {
//                this.name = name;
//                this.faculty = faculty;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public String getFaculty() {
//                return faculty;
//            }
//        }
//
//        // Section class
//        class Section {
//            private String code;
//            private String day;
//            private String hours;
//            private int quota;
//
//            public Section(String code, String day, String hours, int quota) {
//                this.code = code;
//                this.day = day;
//                this.hours = hours;
//                this.quota = quota;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public String getDay() {
//                return day;
//            }
//
//            public String getHours() {
//                return hours;
//            }
//
//            public int getQuota() {
//                return quota;
//            }
//        }
//
//        // Instructor class
//        class Instructor {
//            private String name;
//            private ArrayList<Course> offeredCourses;
//
//            public Instructor(String name) {
//                this.name = name;
//                this.offeredCourses = new ArrayList<>();
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public ArrayList<Course> getOfferedCourses() {
//                return offeredCourses;
//            }
//
//            public void grading(Student student, Course course) {
//                System.out.println("Grading " + student.getStudentName() + " for course " + course.getName());
//            }
//        }
//
//        // Course class
//        class Course {  //Bu kısım da json'a göre düzenlenecek
//            private String name;
//            private String code;
//            private int credit;
//            private int quota;
//            private String term;
//            private int year;
//            private Instructor instructor;
//            private ArrayList<Department> departments;
//            private ArrayList<Section> labSessions;
//            private ArrayList<Section> courseSessions;
//            private ArrayList<String> prerequisite;
//            private ArrayList<Student> studentsEnrolled;
//
//            public Course(String name, String code, int credit, int quota, String term, int year) {
//                this.name = name;
//                this.code = code;
//                this.credit = credit;
//                this.quota = quota;
//                this.term = term;
//                this.year = year;
//                this.departments = new ArrayList<>();
//                this.labSessions = new ArrayList<>();
//                this.courseSessions = new ArrayList<>();
//                this.prerequisite = new ArrayList<>();
//                this.studentsEnrolled = new ArrayList<>();
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public int getCredit() {
//                return credit;
//            }
//
//            public int getQuota() {
//                return quota;
//            }
//
//            public String getTerm() {
//                return term;
//            }
//
//            public int getYear() {
//                return year;
//            }
//
//            public Instructor getInstructor() {
//                return instructor;
//            }
//
//            public ArrayList<Department> getDepartments() {
//                return departments;
//            }
//
//            public ArrayList<Section> getLabSessions() {
//                return labSessions;
//            }
//
//            public ArrayList<Section> getCourseSessions() {
//                return courseSessions;
//            }
//
//            public ArrayList<String> getPrerequisite() {
//                return prerequisite;
//            }
//
//            public ArrayList<Student> getStudentsEnrolled() {
//                return studentsEnrolled;
//            }
//
//            public void setInstructor(Instructor instructor) {
//                this.instructor = instructor;
//                instructor.getOfferedCourses().add(this);
//            }
//
//            public void addDepartment(Department department) {
//                departments.add(department);
//            }
//
//            public void addLabSession(Section section) {
//                labSessions.add(section);
//            }
//
//            public void addCourseSession(Section section) {
//                courseSessions.add(section);
//            }
//
//            public void addPrerequisite(String prerequisiteCourseCode) {
//                prerequisite.add(prerequisiteCourseCode);
//            }
//
//            public void enrollStudent(Student student) {
//                if (studentsEnrolled.size() < quota) {
//                    studentsEnrolled.add(student);
//                } else {
//                    System.out.println("Course quota exceeded.");
//                }
//            }
//        }
//
//        // Student class
//        class Student {
//            private String studentID;
//            private String studentName;
//            private Advisor advisor;
//            private List<Course> enrolledCourses = new ArrayList<>();
//
//            public Student(String studentID, String studentName, Advisor advisor) {
//                this.studentID = studentID;
//                this.studentName = studentName;
//                this.advisor = advisor;
//            }
//
//            public void enrollCourse(Course course) {
//                enrolledCourses.add(course);
//            }
//
//            public String getStudentID() { return studentID; }
//            public String getStudentName() { return studentName; }
//            public ArrayList<Course> getEnrolledCourses() { return enrolledCourses; }
//            public StudentSemester getStudentSemester() { return studentSemester; }
//            public Transcript getTranscript() { return transcript; }
//            public Advisor getAdvisor() { return advisor; }
//
//            public void setStudentID(String studentID) { this.studentID = studentID; }
//            public void setStudentName(String studentName) { this.studentName = studentName; }
//            public void setEnrolledCourses(ArrayList<Course> enrolledCourses) { this.enrolledCourses = enrolledCourses; }
//            public void setStudentSemester(StudentSemester studentSemester) { this.studentSemester = studentSemester; }
//            public void setTranscript(Transcript transcript) { this.transcript = transcript; }
//            public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
//        }
//
//        // Transcript class
//        class Transcript {   //JSON'a eklenecek!
//            private float gpa;
//            private List<StudentSemester> semesters;
//            private int cumulativeCredit;
//
//            public Transcript() {
//                this.semesters = new ArrayList<>();
//            }
//
//            public void calculateGpa() {
//                float totalGradePoints = 0.0f;
//                int totalCredits = 0;
//
//                for (StudentSemester semester : semesters) {
//                    semester.calculateSGPA();
//                    totalGradePoints += semester.getSGPA() * semester.getTotalCredit();
//                    totalCredits += semester.getTotalCredit();
//                }
//
//                gpa = (totalCredits > 0) ? (totalGradePoints / totalCredits) : 0.0f;
//            }
//
//            public void calculateCumulativeCredit() {
//                cumulativeCredit = 0;
//
//                for (StudentSemester semester : semesters) {
//                    semester.calculateCredit();
//                    cumulativeCredit += semester.getTotalCredit();
//                }
//            }
//
//            public float getGpa() { return gpa; }
//            public List<StudentSemester> getSemesters() { return semesters; }
//            public int getCumulativeCredit() { return cumulativeCredit; }
//
//            public void setGpa(float gpa) { this.gpa = gpa; }
//            public void setSemesters(List<StudentSemester> semesters) { this.semesters = semesters; }
//            public void setCumulativeCredit(int cumulativeCredit) { this.cumulativeCredit = cumulativeCredit; }
//        }
//
//        // StudentSemester class
//        class StudentSemester { //JSNO'a eklenecek!
//            private HashMap<Course, Float> courses;
//            private float SGPA;
//            private int semesterNo;
//            private float totalCredit;
//            private List<String> letterGrades;
//
//            public StudentSemester(int semesterNo) {
//                this.semesterNo = semesterNo;
//                this.courses = new HashMap<>();
//            }
//
//            public void calculateSGPA() {
//                float totalGradePoints = 0.0f;
//                float totalCredits = 0.0f;
//
//                for (Course course : courses.keySet()) {
//                    float grade = courses.get(course);
//                    float credit = course.getCredit();
//                    totalGradePoints += grade * credit;
//                    totalCredits += credit;
//                }
//
//                SGPA = (totalCredits > 0) ? (totalGradePoints / totalCredits) : 0.0f;
//            }
//
//            public void calculateCredit() {
//                totalCredit = 0.0f;
//                for (Course course : courses.keySet()) {
//                    totalCredit += course.getCredit();
//                }
//            }
//
//            public void calculateLetterGrade() {
//                letterGrades = new ArrayList<>();
//
//                for (Course course : courses.keySet()) {
//                    float grade = courses.get(course);
//                    String letterGrade;
//
//                    if (grade >= 90) {
//                        letterGrade = "A";
//                    } else if (grade >= 80) {
//                        letterGrade = "B";
//                    } else if (grade >= 70) {
//                        letterGrade = "C";
//                    } else if (grade >= 60) {
//                        letterGrade = "D";
//                    } else {
//                        letterGrade = "F";
//                    }
//
//                    letterGrades.add(letterGrade);
//                }
//            }
//
//            public HashMap<Course, Float> getCourses() { return courses; }
//            public float getSGPA() { return SGPA; }
//            public int getSemesterNo() { return semesterNo; }
//            public float getTotalCredit() { return totalCredit; }
//            public List<String> getLetterGrades() { return letterGrades; }
//
//            public void setCourses(HashMap<Course, Float> courses) { this.courses = courses; }
//            public void setSGPA(float SGPA) { this.SGPA = SGPA; }
//            public void setSemesterNo(int semesterNo) { this.semesterNo = semesterNo; }
//            public void setTotalCredit(float totalCredit) { this.totalCredit = totalCredit; }
//            public void setLetterGrades(List<String> letterGrades) { this.letterGrades = letterGrades; }
//        }
//
//        // Advisor class placeholder (to avoid compilation errors)
//        class Advisor {
//            private String advisorID;
//            private String name;
//            private List<Student> students = new ArrayList<>();
//
//            public Advisor(String advisorID, String name) {
//                this.advisorID = advisorID;
//                this.name = name;
//            }
//
//            public void addStudent(Student student) {
//                students.add(student);
//            }
//            public String getAdvisorID() {
//                return advisorID;
//            }
//
//            public void setAdvisorID(String advisorID) {
//                this.advisorID = advisorID;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public List<Student> getStudents() {
//                return students;
//            }
//
//            public void setStudents(List<Student> students) {
//                this.students = students;
//            }
//
//            public class CourseRegistrationSystem {
//                private Map<String, Student> students = new HashMap<>();
//                private Map<String, Advisor> advisors = new HashMap<>();
//                private Map<String, Course> courses = new HashMap<>();
//
//                public CourseRegistrationSystem(String filePath) throws IOException {
//                    loadFromJSON(filePath);
//                }
//
//                private void loadFromJSON(String filePath) throws IOException {
//                    ObjectMapper mapper = new ObjectMapper();
//                    JsonNode root = mapper.readTree(new File(filePath));
//
//                    // Load Advisors
//                    for (JsonNode advisorNode : root.get("advisors")) {
//                        String advisorID = advisorNode.get("advisorID").asText();
//                        String name = advisorNode.get("name").asText();
//                        Advisor advisor = new Advisor(advisorID, name);
//                        advisors.put(advisorID, advisor);
//                    }
//
//                    // Load Students
//                    for (JsonNode studentNode : root.get("students")) {
//                        String studentID = studentNode.get("studentID").asText();
//                        String studentName = studentNode.get("name").asText();
//                        String advisorID = studentNode.get("advisorID").asText();
//                        Advisor advisor = advisors.get(advisorID);
//                        Student student = new Student(studentID, studentName, advisor);
//                        students.put(studentID, student);
//                        advisor.addStudent(student); // Associate student with advisor
//                    }
//
//                    // Load Courses
//                    for (JsonNode courseNode : root.get("courses")) {
//                        String courseID = courseNode.get("courseID").asText();
//                        String name = courseNode.get("name").asText();
//                        int capacity = courseNode.get("capacity").asInt();
//                        List<String> prerequisites = new ArrayList<>();
//                        for (JsonNode prereq : courseNode.get("prerequisites")) {
//                            prerequisites.add(prereq.asText());
//                        }
//                        Course course = new Course(courseID, name, capacity, prerequisites);
//                        courses.put(courseID, course);
//                    }
//                }
//            }
//        }
