public class M {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println("Total: " + r.totalMemory());
        System.out.println("Max: " + r.maxMemory());
        System.out.println("Free: " + r.freeMemory());
        System.gc();
        System.out.println("GC done.");
    }
}