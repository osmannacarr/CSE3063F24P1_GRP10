import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main{
    public static void main(String[] args) {
    try {
        CourseRegistrationSystem system = new CourseRegistrationSystem("data.json");
        Login loginSystem = new Login(new ObjectMapper().readTree(new File("data.json")));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the user type (Student/Advisor): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("Student") || userType.equalsIgnoreCase("Advisor")) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (loginSystem.verify(userType, username, password)) {
                System.out.println("Login successful! Welcome, " + username + "!");
            } else {
                System.out.println("Login failed. Invalid username and password.");
            }

        } else {
            System.out.println("Invalid user type.");
        }
        scanner.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
