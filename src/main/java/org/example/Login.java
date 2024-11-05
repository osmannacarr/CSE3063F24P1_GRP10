import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Login class
public class Login {
    private Map<String, String> studentLogin = new HashMap<>();
    private Map<String, String> advisorLogin = new HashMap<>();

    public Login(JsonNode data) {
        // Load students' login details from JSON
        for (JsonNode student : data.get("students")) {
            String username = student.get("username").asText();
            String password = student.get("password").asText();
            studentLogin.put(username, password);
        }
        // Load advisors' login details from JSON
        for (JsonNode advisor : data.get("advisors")) {
            String name = advisor.get("name").asText();
            String password = "default_password"; // Assign a default password if not in JSON
            advisorLogin.put(name, password);
        }
    }

    public boolean verify(String userType, String username, String password) {
        if (userType.equalsIgnoreCase("Student")) {
            return studentLogin.containsKey(username) && studentLogin.get(username).equals(password);
        } else if (userType.equalsIgnoreCase("Advisor")) {
            return advisorLogin.containsKey(username) && advisorLogin.get(username).equals(password);
        }
        return false;
    }
}