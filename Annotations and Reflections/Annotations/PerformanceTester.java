public class PerformanceTester {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
        for (int i = 0; i < 1000; i++) { // Simulating fast execution
            Math.sqrt(i);
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slowMethod...");
        for (int i = 0; i < 1000000; i++) { // Simulating slow execution
            Math.sqrt(i);
        }
    }
}
