public class MultiplyStrings {
  /*
   * Constraints: 1) You must not use any built-in BigInteger library or convert
   * the inputs to integer directly. 2) 1 <= num1.length, num2.length <= 200 3)
   * num1 and num2 consist of digits only. 4) Both num1 and num2 do not contain
   * any leading zero, except the number 0 itself.
   */
  public String multiply(String num1, String num2) {
    String[] addends = getAddends(num1, num2);

    int[] product = new int[addends[0].length() + 1];
    for (int i = product.length - 1; i > 0; i--) {
      int sum = product[i];
      for (String addend : addends) {
        sum += addend.charAt(i - 1) - 48;
      }

      if (sum > 9) {
        product = carry(sum, i, product);
      } else {
        product[i] = sum;
      }
    }

    String productString = intArrayToString(product);
    return trimLeadingZeros(productString);
  }

  private int[] carry(int value, int index, int[] array) {
    array[index] = value % 10;
    array[index - 1] = value / 10;

    return array;
  }

  private String[] getAddends(String num1, String num2) {
    String[] addends = new String[num2.length()];
    for (int i = num2.length() - 1; i >= 0; i--) {
      int[] addend = new int[num1.length() + num2.length()];
      int addendIndex = addend.length - num2.length() + i;
      for (int j = num1.length() - 1; j >= 0; j--) {
        int product = (num2.charAt(i) - 48) * (num1.charAt(j) - 48) + addend[addendIndex];
        if (product > 9) {
          addend = carry(product, addendIndex, addend);
        } else {
          addend[addendIndex] = product;
        }

        addendIndex--;
      }

      addends[i] = intArrayToString(addend);
    }

    return addends;
  }

  private String intArrayToString(int[] intArray) {
    char[] charArray = new char[intArray.length];
    for (int i = 0; i < intArray.length; i++) {
      charArray[i] = (char) (intArray[i] + 48);
    }

    return new String(charArray);
  }

  private String trimLeadingZeros(String string) {
    int i = 0;
    while (i < string.length() - 1 && string.charAt(i) == '0') {
      i++;
    }
    return string.substring(i);
  }
}
