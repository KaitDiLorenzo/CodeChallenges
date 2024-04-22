import java.util.List;

public class BeautifulTriplets {
    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0;

        for (int i = 0; i < arr.size() - 2; i++) {
            int j = arr.subList(i + 1, arr.size()).indexOf(arr.get(i) + d);
            int jChange = i + 1;

            while (j > -1) {
                j += jChange;
                int k = arr.subList(j + 1, arr.size()).indexOf(arr.get(j) + d);
                int kChange = j + 1;

                while (k > -1) {
                    count++;
                    k += kChange;
                    kChange = k + 1;
                    k = arr.subList(k + 1, arr.size()).indexOf(arr.get(j) + d);
                }

                jChange = j + 1;
                j = arr.subList(j + 1, arr.size()).indexOf(arr.get(i) + d);
            }
        }

        return count;
    }
}
