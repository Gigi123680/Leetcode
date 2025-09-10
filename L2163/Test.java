package L2163;

public class Test {
    public static void main(String[] args) {
        long ans = 1L << 60;
        System.out.println(ans);

        System.out.println("Test #1 [3, 1, 2]");
        int[] a = {3, 1, 2};
        Solution solution = new Solution();
        System.out.println("Expected: -1");
        System.out.println("Actual: " + solution.minimumDifference(a));

        System.out.println("Test #2 [7, 9, 5, 8, 1, 3]");
        int[] b = {7, 9, 5, 8, 1, 3};
        System.out.println("Expected: 1");
        System.out.println("Actual: " + solution.minimumDifference(b));
    }
}
