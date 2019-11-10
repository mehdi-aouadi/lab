package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6])
 * and another arrow at x = 11 (bursting the other two balloons).
 *
 */
public class ArrowsBurstBalloons {
  public static int findMinArrowShots(int[][] points) {
    if(points.length == 0) {
      return 0;
    }
    //sort points
    Arrays.sort(points, Comparator.comparing(point -> point[1]));
    int arrowsNumber = 1;
    int lastEnd = points[0][1];
    int xStart = 0;
    int xEnd = 0;
    for(int[] balloon : points) {
      xStart = balloon[0];
      xEnd = balloon[1];
      if(xStart > lastEnd) {
        lastEnd = xEnd;
        arrowsNumber++;
      }
    }

    return arrowsNumber;
  }
}
