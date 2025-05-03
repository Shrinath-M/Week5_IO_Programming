public class TaskHandler {

    @ImportantMethod(level = "CRITICAL")
    public void securityCheck() {
        System.out.println("Performing security check...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void dataBackup() {
        System.out.println("Backing up data...");
    }

    @ImportantMethod  // Uses default level "HIGH"
    public void userNotification() {
        System.out.println("Sending notifications to users...");
    }
}
