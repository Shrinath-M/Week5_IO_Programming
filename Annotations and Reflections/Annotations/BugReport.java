import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
@Target(ElementType.METHOD)           // Can be applied to methods
@Repeatable(BugReports.class)         // Allows multiple instances on a method
public @interface BugReport {
    String description();  // Bug details
    String createdBy();    // Reported by
}
