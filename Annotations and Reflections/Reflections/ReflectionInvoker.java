import java.lang.reflect.Method;

public class ReflectionInvoker {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(calculator, 5, 10);

            System.out.println("Result of multiply(5, 10): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
