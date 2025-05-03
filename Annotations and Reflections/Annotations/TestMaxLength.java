public class TestMaxLength {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName");
            System.out.println(user1);

            User user2 = new User("VeryLongUsername");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
