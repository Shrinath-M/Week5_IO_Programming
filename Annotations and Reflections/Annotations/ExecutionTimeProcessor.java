import java.lang.reflect.Method;

public class ExecutionTimeProcessor {
    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester();
        Class<?> clazz = tester.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long startTime = System.nanoTime();

                    method.invoke(tester);

                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;

                    System.out.println("Method: " + method.getName() + " | Execution Time: " + executionTime + " nanoseconds");
                    System.out.println("-------------------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
