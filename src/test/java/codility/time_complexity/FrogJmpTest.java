package codility.time_complexity;

import org.junit.Assert;
import org.junit.Test;

public class FrogJmpTest {

  @Test
  public void frogJmpTest() {
    Assert.assertEquals(3, FrogJmp.countJumps(10, 85, 30));
    Assert.assertEquals(3, FrogJmp.countJumps(10, 100, 30));
    Assert.assertEquals(4, FrogJmp.countJumps(10, 101, 30));
  }

}
