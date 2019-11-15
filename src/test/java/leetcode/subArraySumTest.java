package leetcode;

import org.junit.Test;

public class subArraySumTest {

  @Test
  public void subArraySumtest() {
    SubArraySum subArraySum = new SubArraySum();
    // int result = subArraySum.subArraySum(new int[] {1,1,1}, 2);
    // int result = subArraySum.subArraySum(new int[] {1,2,3}, 3);
    int result = subArraySum.subArraySumHashMap(new int[] {1,2,3}, 3);
    // int result = subArraySum.subArraySum(new int[] {0,0,0,0,0,0,0,0,0,0}, 0);
  }
}
