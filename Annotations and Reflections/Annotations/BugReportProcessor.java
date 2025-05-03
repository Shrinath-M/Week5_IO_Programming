import java.lang.reflect.Method;

public class BugReportProcessor {
    public static void main(String[] args) {
        Class<BugTracker> obj = BugTracker.class;

        try {
            Method method = obj.getDeclaredMethod("processData");

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.createdBy());
                    System.out.println("-------------------------");
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
