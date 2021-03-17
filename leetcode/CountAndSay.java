class CountAndSay {
  // Constraints: 1<=n<=30
  public String countAndSay(int n) {
    String countAndSay = "1";

    while (n > 1) {
      StringBuilder updatedCountAndSay = new StringBuilder();

      int i = 0;
      while (i < countAndSay.length()) {
        char countedChar = countAndSay.charAt(i);
        int count = 1;

        int j = i + 1;
        while (j < countAndSay.length() && countAndSay.charAt(j) == countedChar) {
          count++;
          j++;
        }

        updatedCountAndSay.append(count).append(countedChar);
        i = j;
      }

      countAndSay = updatedCountAndSay.toString();
      n--;
    }

    return countAndSay;
  }
}