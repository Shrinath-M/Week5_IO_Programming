import java.lang.reflect.Constructor;

public class ReflectionInstance {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            Object studentObject = constructor.newInstance("Alice", 20);
            clazz.getMethod("displayInfo").invoke(studentObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
