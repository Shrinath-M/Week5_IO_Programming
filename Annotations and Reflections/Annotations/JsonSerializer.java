import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, Object> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true); // Allow access to private fields
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj)); // Map annotated name to field value
                }
            }

            // Convert map to JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);

        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static void main(String[] args) {
        User user = new User("Alice123", 25, "alice@example.com");
        String json = toJson(user);
        System.out.println(json);
    }
}
