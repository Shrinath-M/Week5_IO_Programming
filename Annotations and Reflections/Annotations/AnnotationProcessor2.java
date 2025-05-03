import java.lang.reflect.Method;

public class AnnotationProcessor2 {
    public static void main(String[] args) {
        Class<TaskHandler> obj = TaskHandler.class;

        // Iterate through methods of TaskHandler
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method Name: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("-------------------------");
            }
        }
    }
}
