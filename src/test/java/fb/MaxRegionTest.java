package fb;

import org.junit.Assert;
import org.junit.Test;

public class MaxRegionTest {

  @Test
  public void maxRegionTest() {
    int[][] grid = new int[][] {
        {1, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {1, 0, 0, 0},
    };

    Assert.assertEquals(5, MaxRegion.maxRegion(grid));

  }

}
