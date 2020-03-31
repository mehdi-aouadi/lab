package codility.others;

import org.junit.Assert;
import org.junit.Test;

public class SplitArrayTest {

  @Test
  public void splitArrayTest() {
    Assert.assertEquals(4, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 1, 6}, 5));
    Assert.assertEquals(5, SplitArray.splitArray(new int[]{5, 8, 1, 4, 2, 3, 5, 5, 5}, 5));
    Assert.assertEquals(5, SplitArray.splitArray(new int[]{5, 8, 5, 4, 2, 3, 1, 5, 5}, 5));
    Assert.assertEquals(4, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 1, 7, 5}, 5));
    Assert.assertEquals(5, SplitArray.splitArray(new int[]{2, 3, 5, 5, 9, 5, 1, 6}, 5));
    Assert.assertEquals(5, SplitArray.splitArray(new int[]{3, 5, 1, 5, 7, 8, 5, 5, 8}, 5));
    Assert.assertEquals(-1, SplitArray.splitArray(new int[]{3, 5, 1, 5, 7, 8, 5, 5, 8}, 9));
    Assert.assertEquals(3, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 5, 6}, 5));
    Assert.assertEquals(-1, SplitArray.splitArray(new int[]{3, 5, 5, 5, 5}, 5));
    Assert.assertEquals(-1, SplitArray.splitArray(new int[]{5, 5, 5, 5, 5, 5, 5}, 5));
    Assert.assertEquals(6, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 1, 6, 7, 9}, 5));
    Assert.assertEquals(8, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 1, 6, 7, 9, 11, 12}, 5));
    Assert.assertEquals(7, SplitArray.splitArray(new int[]{5, 5, 2, 3, 5, 1, 6, 7, 5, 11, 12}, 5));
  }

}
