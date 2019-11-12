package leetcode;

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

}
