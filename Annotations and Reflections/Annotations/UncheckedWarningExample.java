import java.util.ArrayList;

public class UncheckedWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(42);
        list.add(3.14);
        System.out.println("ArrayList contents: " + list);
    }
}
