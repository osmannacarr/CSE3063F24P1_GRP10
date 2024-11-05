import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistrationSystem {
    private Map<String, Student> students = new HashMap<>();
        private Map<String, Advisor> advisors = new HashMap<>();
        private Map<String, Course> courses = new HashMap<>();

        public CourseRegistrationSystem(String filePath) throws IOException {
            loadFromJSON(filePath);
        }

        private void loadFromJSON(String filePath) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(filePath));

            // Load Advisors
            for (JsonNode advisorNode : root.get("advisors")) {
                String advisorID = advisorNode.get("advisorID").asText();
                String name = advisorNode.get("name").asText();
                Advisor advisor = new Advisor(advisorID, name);
                advisors.put(advisorID, advisor);
            }

            // Load Students
            for (JsonNode studentNode : root.get("students")) {
                String studentID = studentNode.get("studentID").asText();
                String studentName = studentNode.get("name").asText();
                String advisorID = studentNode.get("advisorID").asText();
                Advisor advisor = advisors.get(advisorID);
                Student student = new Student(studentID, studentName, advisor);
                students.put(studentID, student);
                advisor.addStudent(student); // Associate student with advisor
            }

            // Load Courses
            for (JsonNode courseNode : root.get("courses")) {
                String courseID = courseNode.get("courseID").asText();
                String name = courseNode.get("name").asText();
                int capacity = courseNode.get("capacity").asInt();
                List<String> prerequisites = new ArrayList<>();
                for (JsonNode prereq : courseNode.get("prerequisites")) {
                    prerequisites.add(prereq.asText());
                }
                Course course = new Course(courseID, name, capacity, prerequisites);
                courses.put(courseID, course);
            }
        }
}
