import java.util.HashMap;
import java.util.Map;

class LongestNiceSubstring {
    public static void main(String args[]) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }

    public static String longestNiceSubstring(String s) {
        Map<Character, boolean[]> charTracker = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charTracker.containsKey(Character.toLowerCase(currentChar))) {
                if (Character.isLowerCase(currentChar)) {
                    charTracker.get(currentChar)[0] = true;
                } else {
                    charTracker.get(Character.toLowerCase(currentChar))[1] = true;
                }
            } else {
                if (Character.isLowerCase(currentChar)) {
                    boolean[] newCharTracker = { true, false };
                    charTracker.put(currentChar, newCharTracker);
                } else {
                    boolean[] newCharTracker = { false, true };
                    charTracker.put(Character.toLowerCase(currentChar), newCharTracker);
                }
            }
        }

        String lowerCaseS = s.toLowerCase();
        String longestNiceSubstring = "";
        int startingIndex = 0;
        for (int i = 0; i < lowerCaseS.length(); i++) {
            boolean[] currentTracker = charTracker.get(lowerCaseS.charAt(i));
            if (!currentTracker[0] || !currentTracker[1] || i == lowerCaseS.length() - 1) {
                if (i - startingIndex + 1 > longestNiceSubstring.length() && i - startingIndex > 2) {
                    String candidate = longestNiceSubstring(
                            i == lowerCaseS.length() - 1 ? s.substring(startingIndex) : s.substring(startingIndex, i));
                    if (candidate.length() > longestNiceSubstring.length()) {
                        longestNiceSubstring = candidate;
                    }
                    startingIndex = i + 1;
                }
            }
        }

        return longestNiceSubstring;
    }
}