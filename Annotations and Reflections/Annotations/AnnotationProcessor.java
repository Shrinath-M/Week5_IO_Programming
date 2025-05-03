import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<TaskManager> obj = TaskManager.class;

        // Iterate through methods of TaskManager
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task: " + method.getName());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
                System.out.println("Priority Level: " + taskInfo.priority());
                System.out.println("-------------------------");
            }
        }
    }
}

