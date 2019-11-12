package ctci.chapters.hard;

import org.junit.Assert;
import org.junit.Test;

public class AddWithoutPlusTest {
  @Test
  public void addWithoutPlusTest() {
    Assert.assertEquals(12, AddWithoutPlus.addIterative(2, 10));
    Assert.assertEquals(112, AddWithoutPlus.addIterative(17, 95));
  }
}
