import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class CarToJson {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create JSON object for Student
            ObjectNode student = objectMapper.createObjectNode();
            student.put("name", "Alice Williams");
            student.put("age", 20);

            // Create an array of subjects
            ArrayNode subjects = objectMapper.createArrayNode();
            subjects.add("Mathematics");
            subjects.add("Physics");
            subjects.add("Computer Science");

            student.set("subjects", subjects);

            // Convert to JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
