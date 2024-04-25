import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SparseArrays {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> matchingStrings = new ArrayList<>();
        Map<String, Integer> stringCount = new HashMap<>();

        for (String s : stringList) {
            stringCount.merge(s, 1, Integer::sum);
        }

        for (String q : queries) {
            matchingStrings.add(stringCount.get(q) == null ? 0 : stringCount.get(q));
        }

        return matchingStrings;
    }
}