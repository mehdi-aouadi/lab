package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * <p>Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 *
 * <p>Example 1: Input:nums = [1,1,1], k = 2 Output: 2 Note: The length of the array is in range
 * [1, 20,000]. The range of numbers in the array is [-1000, 1000] and the range of the integer k is
 * [-1e7, 1e7].
 *
 */
public class SubArraySum {

  public int subArraySumHashMap(int[] nums, int k) {
    int result = 0;
    int counter = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for(int index = 0; index < nums.length; index++) {
      counter += nums[index];
      if (map.containsKey(counter - k)) {
        result += map.get(counter - k);
      }
      map.put(counter, map.getOrDefault(counter, 0) + 1);
    }
    return result;
  }

  public int subArraySum(int[] nums, int k) {
    int result = 0;
    for(int index = 0; index < nums.length; index++) {
      int counter = nums[index];
      if(counter == k) {
        result++;
      }
      for(int countingIndex = index + 1; countingIndex < nums.length; countingIndex++) {
        counter += nums[countingIndex];
        if(counter == k) {
          result++;
        }
      }
    }
    return result;
  }

}
