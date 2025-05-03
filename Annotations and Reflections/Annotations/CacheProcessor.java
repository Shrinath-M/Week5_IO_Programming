import java.lang.reflect.Method;

public class CacheProcessor {
    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();

        // Manually check if method is annotated (not needed for basic use)
        try {
            Method method = MathOperations.class.getDeclaredMethod("expensiveComputation", int.class);
            if (method.isAnnotationPresent(CacheResult.class)) {
                System.out.println("Annotation @CacheResult detected!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Result: " + mathOps.expensiveComputation(5));
        System.out.println("Result: " + mathOps.expensiveComputation(5));
        System.out.println("Result: " + mathOps.expensiveComputation(7));
        System.out.println("Result: " + mathOps.expensiveComputation(7));
    }
}
