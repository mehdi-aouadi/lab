package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ArrowsBurstBalloonsTest {

  @Test
  public void arrowsBurstBalloonsTest() {
    int [][] points = new int[][] {{10,16}, {2,8}, {1,6}, {7,12}};
    Assert.assertEquals(2, ArrowsBurstBalloons.findMinArrowShots(points));
  }
}
