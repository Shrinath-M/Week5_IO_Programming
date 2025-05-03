import java.lang.reflect.Method;

public class RoleValidator {
    private static String currentUserRole = "USER";

    public static void main(String[] args) {
        AdminService service = new AdminService();
        validateAccess(service, "deleteUser");
        validateAccess(service, "viewProfile");
    }

    public static void validateAccess(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(currentUserRole)) {
                    System.out.println("Access Denied! You need " + roleAllowed.value() + " role to execute this method.");
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
