import java.util.TreeSet;

class TwoStrings {
    public static String twoStrings(String s1, String s2) {
        String result = "NO";

        TreeSet<Character> s1Set = new TreeSet<>();
        TreeSet<Character> s2Set = new TreeSet<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Set.add(s2.charAt(i));
        }

        for (char letter : s1Set) {
            if (s2Set.contains(letter)) {
                result = "YES";
                break;
            }
        }

        return result;
    }
}
