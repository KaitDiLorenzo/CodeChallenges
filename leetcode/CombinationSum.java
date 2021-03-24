import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public static void main(String[] args) {
    int[] candidates = { 2, 3, 6, 7 };
    int target = 7;

    System.out.println(combinationSum(candidates, target));
  }

  class Node {
    List<Integer> combination;
    int candidateIndex;
    int combinationSum;
    Node parent;
    List<Node> children;

    Node(List<Integer> combination, int candidateIndex, int combinationSum, Node parent) {
      this.combination = combination;
      this.combinationSum = combinationSum;
      this.parent = parent;
      children = new ArrayList<>();
    }

    List<List<Integer>> getCombinations(int[] candidates, int target, List<List<Integer>> combinations) {
      if (combinationSum < target) {
        // do something
      }
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> combinations = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      List<Integer> combination = new ArrayList<>();
      combination.add(candidates[i]);

      Node node = new Node(combination, i, candidates[i], null);

      combinations.addAll(node.getCombinations(candidates, target, combinations));
    }

    return combinations;
  }
}