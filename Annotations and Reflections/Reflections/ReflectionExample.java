import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);
            person.displayAge();  // Original age

            // Get the private field 'age' using Reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);  // Allow access to private field

            // Modify the private field 'age'
            ageField.set(person, 30);

            // Retrieve the modified value
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + modifiedAge);

            person.displayAge();  // Confirm modified age

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
