package L2327;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print("Test 1\nExpected: 653668527\nActual:");
        int n = solution.peopleAwareOfSecret(684, 18, 496);
        System.out.println(n);

        System.out.print("Test 2\nExpected: 6\nActual:");
        n = solution.peopleAwareOfSecret(4, 1, 3);
        System.out.println(n);
    }
}
