public class DecodeXoredArray {
    public int[] decode(int[] encoded, int first) {
        int[] decodedArr = new int[encoded.length + 1];
        String[] binaryArr = new String[encoded.length + 1];

        decodedArr[0] = first;
        binaryArr[0] = Integer.toBinaryString(first);

        for (int i = 1; i < binaryArr.length; i++) {
            String binaryEncoded = Integer.toBinaryString(encoded[i - 1]);
            int difference = binaryArr[i - 1].length() - binaryEncoded.length();

            if (difference < 0) {
                difference = Math.abs(difference);
                binaryArr[i - 1] = "0".repeat(difference).concat(binaryArr[i - 1]);
            } else if (difference > 0) {
                binaryEncoded = "0".repeat(difference).concat(binaryEncoded);
            }

            StringBuilder binaryDecoded = new StringBuilder();
            for (int j = 0; j < binaryEncoded.length(); j++) {
                binaryDecoded.append(binaryArr[i - 1].charAt(j) == binaryEncoded.charAt(j) ? "0" : "1");
            }

            binaryArr[i] = binaryDecoded.toString();
            decodedArr[i] = Integer.parseInt(binaryDecoded.toString(), 2);
        }

        return decodedArr;
    }
}
