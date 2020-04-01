package codility.others;

import org.junit.Assert;
import org.junit.Test;

public class NegativeBaseTest {

  @Test
  public void negateBaseTwoTest() {
    Assert.assertArrayEquals(new int[] {1, 1, 0, 1, 0, 1, 1}, NegateBaseNegativeTwo.negateBaseNegativeTwo(new int[] {1, 1, 1, 0, 0, 1}));
    Assert.assertArrayEquals(new int[] {1, 1, 1, 0, 0, 1}, NegateBaseNegativeTwo.negateBaseNegativeTwo(new int[] {1, 1, 0, 1, 0, 1, 1}));
  }

  @Test
  public void baseNegativeTest() {
    Assert.assertEquals("1101", NegateBaseNegativeTwo.negativeBase(-3, -2));
    Assert.assertEquals("111", NegateBaseNegativeTwo.negativeBase(3, -2));
  }

}
