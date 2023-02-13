import java.util.ArrayList;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int longestOnes = 0;
        ArrayList<NumberGroup> numberGroups = getNumberGroups(nums);

        for(int i = 0; i < numberGroups.size(); i++) {
            int length = 0;

            if(numberGroups.get(i).type == NumberGroupType.ZERO) {
                for(int j = 1; j <= k && j <= numberGroups.get(i).length; j++) {
                    int currentLength = j + longestOnesHelper(numberGroups, k - j, i + 1);
                    
                    if(currentLength > length) {
                        length = currentLength;
                    }
                }
            } else {
                length = numberGroups.get(i).length + longestOnesHelper(numberGroups, k, i + 1);
            }

            if(length > longestOnes) {
                longestOnes = length;
            }
        }

        return longestOnes;
    }

    private class NumberGroup {
        NumberGroupType type;
        int length;
    }

    private enum NumberGroupType {
        ZERO,
        ONE;
    }

    private ArrayList<NumberGroup> getNumberGroups(int[] nums) {
        ArrayList<NumberGroup> numberGroups = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            NumberGroup numberGroup = new NumberGroup();
            int startingIndex = i;

            if(nums[i] == 0) {
                numberGroup.type = NumberGroupType.ZERO;
                
                while(i < nums.length && nums[i] == 0) {
                    i++;
                }
            } else {
                numberGroup.type = NumberGroupType.ONE;

                while(i < nums.length && nums[i] == 1) {
                    i++;
                }
            }

            numberGroup.length = i - startingIndex;

            numberGroups.add(numberGroup);

            i--;
        }

        return numberGroups;
    }
    
    private int longestOnesHelper(ArrayList<NumberGroup> numberGroups, int k, int i) {
        int length = 0;

        if(i < numberGroups.size()) {
            NumberGroup numberGroup = numberGroups.get(i);

            if(numberGroup.type == NumberGroupType.ZERO) {
                int numberGroupLength = numberGroup.length;

                if(numberGroupLength <= k) {
                    length = numberGroupLength + longestOnesHelper(numberGroups, k - numberGroupLength, i + 1);
                } else {
                    length = k;
                }
            } else {
                length = numberGroups.get(i).length + longestOnesHelper(numberGroups, k, i + 1);
            }
        }

        return length;
    }
}
