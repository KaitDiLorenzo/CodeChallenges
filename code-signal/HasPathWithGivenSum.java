import java.util.HashSet;

class HasPathWithGivenSum {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean solution(Tree<Integer> t, int s) {
        if (t == null) {
            return false;
        }

        return treeSums(t, new HashSet<>()).contains(s);
    }

    HashSet<Integer> treeSums(Tree<Integer> t, HashSet<Integer> sums) {
        HashSet<Integer> treeSums = new HashSet<>();

        if (t.left == null && t.right == null) {
            treeSums.add(t.value);
        } else {
            if (t.left != null) {
                HashSet<Integer> leftTreeSums = treeSums(t.left, sums);

                for (Integer leftTreeSum : leftTreeSums) {
                    treeSums.add(leftTreeSum + t.value);
                }
            }

            if (t.right != null) {
                HashSet<Integer> rightTreeSums = treeSums(t.right, sums);

                for (Integer rightTreeSum : rightTreeSums) {
                    treeSums.add(rightTreeSum + t.value);
                }
            }
        }

        return treeSums;
    }
}
