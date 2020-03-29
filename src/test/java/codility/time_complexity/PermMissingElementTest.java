package codility.time_complexity;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElementTest {

  @Test
  public void permMissingElementTest() {
    Assert.assertEquals(4, PermMissingElement.findMissingElement(new int[]{2, 3, 1, 5}));
  }

}
