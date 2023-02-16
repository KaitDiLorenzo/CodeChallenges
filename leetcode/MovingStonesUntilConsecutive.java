public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = { a, b, c };
        Arrays.sort(stones);

        return new int[] { min(stones), max(stones) };
    }

    private int min(int[] stones) {
        if (stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1) {
            return 0;
        } else if (stones[1] - stones[0] < 3 || stones[2] - stones[1] < 3) {
            return 1;
        } else {
            return 2;
        }
    }

    private int max(int[] stones) {
        return stones[2] - stones[0] - 2;
    }
}
