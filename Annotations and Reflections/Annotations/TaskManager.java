public class TaskManager {

    @TaskInfo(assignedTo = "Alice", priority = 1)
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @TaskInfo(assignedTo = "Bob", priority = 3)
    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

