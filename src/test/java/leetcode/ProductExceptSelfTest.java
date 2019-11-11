package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ProductExceptSelfTest {

  @Test
  public void productExceptSelfTest() {
    int[] array = new int[]{1,2,3,4};
    Assert.assertArrayEquals(new int[]{24,12,8,6}, ProductExceptSelf.productExceptSelf(array));
  }
}
