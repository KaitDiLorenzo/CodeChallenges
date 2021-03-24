import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CS {
  public static void main(String[] args) {
    int[] candidates = { 2, 3, 5 };
    int target = 8;

    System.out.println(combinationSum(candidates, target));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> combinations = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      List<Integer> combination = new ArrayList<>();
      combination.add(candidates[i]);

      combinations = getCombinations(candidates, i, candidates[i], target, combination, combinations);
    }

    return combinations;
  }

  public static List<List<Integer>> getCombinations(int[] candidates, int candidateIndex, int combinationSum,
      int target, List<Integer> combination, List<List<Integer>> combinations) {
    if (combinationSum < target) {
      combination.add(candidates[candidateIndex]);
      combinations = getCombinations(candidates, candidateIndex, combinationSum + candidates[candidateIndex], target,
          combination, combinations);
    } else if (combinationSum > target && combination.size() > 2 && candidateIndex + 1 < candidates.length) {
      combinationSum -= combination.get(combination.size() - 1);
      combination.remove(combination.size() - 1);

      combinationSum -= combination.get(combination.size() - 1);
      combination.remove(combination.size() - 1);

      combinations = getCombinations(candidates, candidateIndex + 1, combinationSum, target, combination, combinations);
    } else if (combinationSum == target) {
      combinations.add(combination);
    }

    return combinations;
  }
}
