import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
@Target(ElementType.METHOD)           // Can be applied to methods
public @interface Todo {
    String task();              // Task description
    String assignedTo();        // Developer responsible
    String priority() default "MEDIUM";  // Default priority
}
