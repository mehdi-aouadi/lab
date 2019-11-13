package leetcode;

import org.junit.Test;

public class MergeIntervalsTest {

  @Test
  public void mergeArraysTest() {
    MergeIntervals mergeIntervals = new MergeIntervals();
    // int[][] result = mergeArrays.merge(new int[][] {{1, 4}, {0, 4}});
    // int[][] result = mergeArrays.merge(new int[][] {{1, 4}, {0, 1}});
    int[][] result = mergeIntervals.merge(new int[][] {{1, 4}, {2, 3}});
    // int[][] result = mergeArrays.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
  }
}
