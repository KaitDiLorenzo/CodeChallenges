public class UtopianTree {
    public static int utopianTree(int n) {
        if (n % 2 == 0)
            return (int) Math.pow(2, n / 2 + 1) - 1;
        else
            return (int) (Math.pow(2, n / 2 + 1) - 1) * 2;
    }
}
