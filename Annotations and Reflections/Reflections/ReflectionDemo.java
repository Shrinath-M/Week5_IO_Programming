import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\nClass: " + clazz.getName());

            System.out.println("\n🔹 Constructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println("  " + constructor);
            }

            System.out.println("\n🔹 Methods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("  " + method);
            }

            System.out.println("\n🔹 Fields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println("  " + field);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class '" + className + "' not found!");
        }
    }
}
