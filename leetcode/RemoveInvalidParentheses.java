import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoveInvalidParentheses {
  public static void main(String[] args) {
    System.out.println(removeInvalidParentheses(")o(v("));
  }

  public static List<String> removeInvalidParentheses(String s) {
    return removeInvalidRightParentheses(removeInvalidLeftParentheses(s));
  }

  private static Set<String> removeInvalidLeftParentheses(String s) {
    Set<String> partiallyRemovedInvalidLeftParentheses = new HashSet<>();
    partiallyRemovedInvalidLeftParentheses.add(s);

    Set<String> removedInvalidLeftParentheses = new HashSet<>();
    List<Integer> rightParenthesesIndices = new ArrayList<>();

    while (!partiallyRemovedInvalidLeftParentheses.isEmpty()) {
      Set<String> newPartiallyRemovedInvalidLeftParentheses = new HashSet<>();
      for (String strToFix : partiallyRemovedInvalidLeftParentheses) {
        boolean isInvalid = false;
        for (int i = strToFix.length() - 1; i >= 0; i--) {
          if (strToFix.charAt(i) == '(') {
            if (rightParenthesesIndices.isEmpty()) {
              isInvalid = true;
              for (int j = i; j < strToFix.length(); j++) {
                if (strToFix.charAt(j) == '(') {
                  newPartiallyRemovedInvalidLeftParentheses
                      .add(strToFix.substring(0, j).concat(strToFix.substring(j + 1)));
                }
              }
            } else {
              rightParenthesesIndices.remove(0);
            }
          } else if (strToFix.charAt(i) == ')') {
            rightParenthesesIndices.add(i);
          }
        }

        if (!isInvalid) {
          removedInvalidLeftParentheses.add(strToFix);
        }

        rightParenthesesIndices.clear();
      }

      partiallyRemovedInvalidLeftParentheses = newPartiallyRemovedInvalidLeftParentheses;
    }

    return removedInvalidLeftParentheses;
  }

  private static List<String> removeInvalidRightParentheses(Set<String> removedInvalidLeftParentheses) {
    Set<String> partiallyRemovedInvalidRightParentheses = removedInvalidLeftParentheses;

    Set<String> removedInvalidRightParentheses = new HashSet<>();
    List<Integer> leftParenthesesIndices = new ArrayList<>();

    while (!partiallyRemovedInvalidRightParentheses.isEmpty()) {
      Set<String> newPartiallyRemovedInvalidRightParentheses = new HashSet<>();
      for (String strToFix : partiallyRemovedInvalidRightParentheses) {
        boolean isInvalid = false;
        for (int i = 0; i < strToFix.length(); i++) {
          if (strToFix.charAt(i) == ')') {
            if (leftParenthesesIndices.isEmpty()) {
              isInvalid = true;
              for (int j = i; j >= 0; j--) {
                if (strToFix.charAt(j) == ')') {
                  newPartiallyRemovedInvalidRightParentheses
                      .add(strToFix.substring(0, j).concat(strToFix.substring(j + 1)));
                }
              }
            } else {
              leftParenthesesIndices.remove(0);
            }
          } else if (strToFix.charAt(i) == '(') {
            leftParenthesesIndices.add(i);
          }
        }

        if (!isInvalid) {
          removedInvalidRightParentheses.add(strToFix);
        }

        leftParenthesesIndices.clear();
      }

      partiallyRemovedInvalidRightParentheses = newPartiallyRemovedInvalidRightParentheses;
    }

    return new ArrayList<>(removedInvalidRightParentheses);
  }
}
