package codility.iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGapTest {

  @Test
  public void binaryGapTest() {
    Assert.assertEquals(2, BinaryGap.binaryGap(9));
    Assert.assertEquals(4, BinaryGap.binaryGap(529));
    Assert.assertEquals(1, BinaryGap.binaryGap(20));
    Assert.assertEquals(0, BinaryGap.binaryGap(15));
    Assert.assertEquals(0, BinaryGap.binaryGap(32));
  }

}
