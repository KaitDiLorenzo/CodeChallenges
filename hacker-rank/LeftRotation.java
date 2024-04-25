import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        Integer[] arr_rotated = new Integer[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            arr_rotated[i - d < 0 ? arr.size() + i - d : i - d] = arr.get(i);
        }

        return Arrays.asList(arr_rotated);
    }
}
