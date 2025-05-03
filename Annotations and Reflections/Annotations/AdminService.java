public class AdminService {

    @RoleAllowed("ADMIN")  // Restrict access to ADMIN role
    public void deleteUser() {
        System.out.println("User successfully deleted.");
    }

    @RoleAllowed("USER")  // Allow regular users
    public void viewProfile() {
        System.out.println("Viewing user profile...");
    }
}
