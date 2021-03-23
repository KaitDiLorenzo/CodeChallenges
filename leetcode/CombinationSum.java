import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public static void main(String[] args) {
    int[] candidates = { 2, 3, 6, 7 };
    int target = 7;

    System.out.println(combinationSum(candidates, target));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> combinations = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] > target) {
        break;
      }

      combinations = getCombinationSum(candidates, 0, 0, i, target, new ArrayList<>(), combinations);
    }

    return combinations;
  }

  private static List<List<Integer>> getCombinationSum(int[] candidates, int candidateIndex, int combinationSum,
      int rootIndex, int target, List<Integer> combination, List<List<Integer>> combinations) {
    while (combinationSum + candidates[candidateIndex] <= target) {
      combination.add(candidates[candidateIndex]);
      combinationSum += candidates[candidateIndex];
    }

    if (combinationSum == target) {
      combinations.add(combination);
      return combinations;
    }

    combinationSum -= combination.get(combination.size() - 1);
    combination.remove(combination.size() - 1);
    if (combinationSum == 0) {
      return combinations;
    }

    if (candidateIndex + 1 < candidates.length) {
      combinations = getCombinationSum(candidates, candidateIndex + 1, combinationSum, rootIndex, target, combination,
          combinations);
    }

    return combinations;
  }
}