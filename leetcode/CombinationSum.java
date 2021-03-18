import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    Map<Integer, List<List<Integer>>> combinationSums = setCombinationSums(candidates, target, new HashMap<>());

    return combinationSums.get(target);
  }

  private boolean isCandidate(int[] candidates, int value) {
    int i = 0;
    while (i < candidates.length && candidates[i] < value) {
      i++;
    }

    return i < candidates.length && candidates[i] == value;
  }

  private Map<Integer, List<List<Integer>>> setCombinationSums(int[] candidates, int value,
      Map<Integer, List<List<Integer>>> combinationSums) {
    combinationSums.put(value, new ArrayList<>());

    if (isCandidate(candidates, value)) {
      List<Integer> combinationSum = new ArrayList<>();
      combinationSum.add(value);
      combinationSums.get(value).add(combinationSum);
    }

    for (int i = candidates[0]; i <= value / 2; i++) {
      int augend = i;
      int addend = value - i;

      if (combinationSums.get(augend) == null) {
        combinationSums = setCombinationSums(candidates, augend, combinationSums);
      }

      if (!combinationSums.get(augend).isEmpty()) {
        if (combinationSums.get(addend) == null) {
          combinationSums = setCombinationSums(candidates, addend, combinationSums);
        }

        if (!combinationSums.get(addend).isEmpty()) {
          for (List<Integer> addendCombinationSums : combinationSums.get(addend)) {
            for (List<Integer> augendCombinationSum : combinationSums.get(augend)) {
              List<Integer> combinationSum = new ArrayList<>(addendCombinationSums);
              combinationSum.addAll(augendCombinationSum);
              Collections.sort(combinationSum);

              if (!combinationSums.get(value).contains(combinationSum)) {
                combinationSums.get(value).add(combinationSum);
              }
            }
          }
        }
      }
    }

    return combinationSums;
  }
}
