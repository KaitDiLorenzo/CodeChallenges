import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class HappyLadybugs {
    public static String happyLadybugs(String b) {
        if (b.contains("_")) {
            Dictionary<Character, Integer> charCount = new Hashtable<>();

            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);

                if (c != '_') {
                    if (charCount.get(c) == null) {
                        charCount.put(c, 1);
                    } else {
                        charCount.put(c, charCount.get(c) + 1);
                    }
                }
            }

            Enumeration<Integer> e = charCount.elements();
            while (e.hasMoreElements()) {
                if (e.nextElement() == 1) {
                    return "NO";
                }
            }
        } else if (b.length() == 1) {
            return "NO";
        } else if (b.charAt(0) != b.charAt(1) ||
                b.charAt(b.length() - 1) != b.charAt(b.length() - 2)) {
            return "NO";
        } else {
            for (int i = 1; i < b.length() - 1; i++) {
                if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
