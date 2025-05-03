import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
@Target(ElementType.METHOD)           // Can be applied to methods
public @interface CacheResult {
}
