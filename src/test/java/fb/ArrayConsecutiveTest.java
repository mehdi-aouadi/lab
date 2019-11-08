package fb;

import org.junit.Assert;
import org.junit.Test;

public class ArrayConsecutiveTest {

  @Test
  public void arrayConsecutiveTest() {
    int[] array = new int[] {83, 78, 80, 81, 79, 82};
    Assert.assertTrue(ArrayConsecutive.isConsecutive(array));
  }
}
