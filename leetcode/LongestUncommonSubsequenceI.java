public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        int lusLength = 0;
        String longerString, shorterString;

        if (a.length() >= b.length()) {
            longerString = a;
            shorterString = b;
        } else {
            longerString = b;
            shorterString = a;
        }

        for (int i = 0; i < longerString.length(); i++) {
            for (int j = longerString.length(); j > i && j - i > lusLength; j--) {
                if (!(shorterString.contains(longerString.subSequence(i, j)))) {
                    lusLength = j - i;
                }
            }
        }

        return lusLength;
    }
}
