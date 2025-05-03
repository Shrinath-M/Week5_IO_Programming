import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // Annotation available at runtime
@Target(ElementType.METHOD)           // Annotation applicable to methods
public @interface TaskInfo {
    String assignedTo();  // Assigned person
    int priority();       // Priority level (e.g., 1-5)
}
