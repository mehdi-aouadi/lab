package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] array, int target) {
    Map<Integer, Integer> visitedValues = new HashMap<>();
    for (int index = 0; index < array.length; index++) {
      int value = array[index];
      int complement = target - value;
      if(visitedValues.containsKey(complement)) {
        return new int[] {visitedValues.get(complement), index};
      }
      visitedValues.put(complement, index);
    }
    return null;
  }

  public static boolean twoSumBinarySearch(int[] array, int target) {
    Arrays.sort(array);
    for(int index = 0; index < array.length; index++) {
      int current = array[index];
      int complement = target - current;
      int complementIndex = Arrays.binarySearch(array, complement);
      if(complementIndex >= 0) {
        return true;
      }
    }
    return false;
  }

}
