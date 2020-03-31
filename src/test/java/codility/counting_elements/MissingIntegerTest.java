package codility.counting_elements;

import codility.counting_elements.MissingInteger;
import org.junit.Assert;
import org.junit.Test;

public class MissingIntegerTest {

  @Test
  public void missingIntegerTest() {
    Assert.assertEquals(5, MissingInteger.findMissingInteger(new int[] {1, 3, 6, 4, 1, 2}));
    Assert.assertEquals(4, MissingInteger.findMissingInteger(new int[] {1, 2, 3}));
    Assert.assertEquals(1, MissingInteger.findMissingInteger(new int[] {-1, -3}));
  }

}
