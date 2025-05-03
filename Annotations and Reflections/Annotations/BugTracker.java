public class BugTracker {

    @BugReport(description = "Null pointer exception in login module", createdBy = "Alice")
    @BugReport(description = "Memory leak detected in caching module", createdBy = "Bob")
    public void processData() {
        System.out.println("Processing data...");
    }
}
