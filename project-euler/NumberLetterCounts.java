import java.util.HashMap;
import java.util.Map;

class NumberLetterCounts {
    public static void main(String[] args) {
        System.out.println(numberLetterCounts(1000));
    }

    //This function only accepts values between 1 and 999,999
    private static int numberLetterCounts(int max_number) {
        if (max_number < 1 || max_number > 999999) {
            return -1;
        }

        final int THOUSAND = 8;
        final int HUNDRED = 7;
        final int AND = 3;

        int sum = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        counts.put(1, 3);
        counts.put(2, 3);
        counts.put(3, 5);
        counts.put(4, 4);
        counts.put(5, 4);
        counts.put(6, 3);
        counts.put(7, 5);
        counts.put(8, 5);
        counts.put(9, 4);
        counts.put(10, 3);
        counts.put(11, 6);
        counts.put(12, 6);
        counts.put(13, 8);
        counts.put(14, 8);
        counts.put(15, 7);
        counts.put(16, 7);
        counts.put(17, 9);
        counts.put(18, 8);
        counts.put(19, 8);
        counts.put(20, 6);
        counts.put(30, 6);
        counts.put(40, 5);
        counts.put(50, 5);
        counts.put(60, 5);
        counts.put(70, 7);
        counts.put(80, 6);
        counts.put(90, 6);

        for (int i = 1; i <= max_number; i++) {
            if (counts.containsKey(i)) {
                sum += counts.get(i);
            } else {
                int number = i;
                int number_count = 0;

                if (number > 999) {
                    number_count += counts.get(number / 1000) + THOUSAND;
                    number = number % 1000;

                    if (number < 100 && number != 0) {
                        number_count += AND;
                    }

                    if (counts.containsKey(number)) {
                        number_count += counts.get(number);
                        counts.put(i, number_count);
                        number = 0;
                    }
                }

                if (number > 99) {
                    number_count += counts.get(number / 100) + HUNDRED;
                    number = number % 100;

                    if (number != 0) {
                        number_count += AND;
                    }

                    if (counts.containsKey(number)) {
                        number_count += counts.get(number);
                        counts.put(i, number_count);
                        number = 0;
                    }
                }

                if (number > 19) {
                    number_count += counts.get(number - number % 10);
                    number = number % 10;
                }

                if (number != 0) {
                    number_count += counts.get(number);
                }

                counts.put(i, number_count);
                sum += number_count;
            }
        }

        return sum;
    }
}