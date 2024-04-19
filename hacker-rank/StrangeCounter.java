public class StrangeCounter {
    public static long strangeCounter(long t) {
        long time = 0;

        for (int i = 1;; i++) {
            long resetTime = (long) (Math.pow(2, i + 2) - Math.pow(2, i) - 2);
            if (resetTime > t) {
                time = (long) (Math.pow(2, i + 1) - Math.pow(2, i - 1) - 2);
                break;
            } else if (resetTime == t) {
                time = resetTime;
                break;
            }
        }

        return 2 * time - t + 2;
    }
}