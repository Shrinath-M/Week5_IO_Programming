import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicInvoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        scanner.close();

        try {
            MathOperations mathOps = new MathOperations();
            Method method = MathOperations.class.getDeclaredMethod(methodName, int.class, int.class);

            int result = (int) method.invoke(mathOps, num1, num2);

            System.out.println("Result of " + methodName + "(" + num1 + ", " + num2 + "): " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method '" + methodName + "' not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
