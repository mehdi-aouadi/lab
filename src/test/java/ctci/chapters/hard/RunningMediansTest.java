package ctci.chapters.hard;

import org.junit.Assert;
import org.junit.Test;

public class RunningMediansTest {

  @Test
  public void runningMediansTest() {
    int[] array = new int[] {12, 4, 5, 3, 8, 7};
    Assert.assertArrayEquals(new double[] {12.0, 8.0, 5.0, 4.5, 5.0, 6.0}, RunningMedian.getMedians(array), 0);
  }
}
