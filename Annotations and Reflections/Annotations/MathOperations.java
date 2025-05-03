import java.util.HashMap;
import java.util.Map;

public class MathOperations {
    private static final Map<Integer, Integer> cache = new HashMap<>(); // Cache storage

    @CacheResult
    public int expensiveComputation(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }

        System.out.println("Computing result for: " + number);
        int result = computeFactorial(number); // Simulate expensive computation
        cache.put(number, result);  // Store result in cache
        return result;
    }

    private int computeFactorial(int n) {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {} // Simulating delay
        return (n == 0 || n == 1) ? 1 : n * computeFactorial(n - 1);
    }
}
