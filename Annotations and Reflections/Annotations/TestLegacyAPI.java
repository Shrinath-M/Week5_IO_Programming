class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: This is an outdated feature! Please use newFeature().");
    }

    public void newFeature() {
        System.out.println("This is the improved feature! Use this instead.");
    }
}

public class TestLegacyAPI {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
