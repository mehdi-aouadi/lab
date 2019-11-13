package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition
 * to get new method signature.
 * 
 */
public class MergeIntervals {

  private class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
      if(o1[0] > o2[0]) {
        return 1;
      } else if(o1[0] < o2[0]) {
        return -1;
      }
      return 0;
    }
  }
  public int[][] merge(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
    if(intervals.length == 0) {
      return new int[0][0];
    }
    List<int[]> intervalsList = Arrays.asList(intervals);
    Collections.sort(intervalsList, new IntervalComparator());
    int[] last = new int[] {intervalsList.get(0)[0], intervalsList.get(0)[1]};
    for(int index=1; index < intervalsList.size(); index++) {
      int currentLeft = intervalsList.get(index)[0];
      int currentRight = intervalsList.get(index)[1];
      int lastRight = last[1];

      if(currentRight <= lastRight) {
        continue;
      } else if(currentLeft <= lastRight) {
        last[1] = currentRight;
      } else {
        result.add(last);
        last = new int[2];
        last[0] = currentLeft;
        last[1] = currentRight;
      }
    }
    result.add(last);
    int[][] arrayResult = new int[result.size()][2];
    result.toArray(arrayResult);
    return arrayResult;
  }

}
